import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationManagerResolver;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtIssuerAuthenticationManagerResolver;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import vn.gobiz.dota.chen.config.properties.MultiOAuth2ResourceServerProperties;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@Slf4j
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Autowired
    private CustomTokenFilter customTokenFilter;

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManagerResolver<HttpServletRequest> authenticationManagerResolver) throws Exception {
        http
                .csrf().disable()
                .formLogin().disable()
                .rememberMe().disable()
                .addFilterAt(customTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .logout().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.OPTIONS).permitAll()
                        .requestMatchers("/actuator/**").permitAll()
                        .requestMatchers("/swagger/**").permitAll()
                        .requestMatchers("/internal/**").permitAll()
                        .requestMatchers("/public/**").permitAll()
                        .requestMatchers("/internal/**").permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2.authenticationManagerResolver(authenticationManagerResolver))
                .exceptionHandling()
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint());
        return http.build();
    }




    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("permissions");
        jwtGrantedAuthoritiesConverter.setAuthorityPrefix("");
        converter.setPrincipalClaimName("preferred_username");
        converter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
        return converter;
    }

    @ConditionalOnMissingBean
    @Bean
    public AuthenticationManagerResolver<HttpServletRequest> authenticationManagerResolver(MultiOAuth2ResourceServerProperties properties,
                                                                                           OAuth2ResourceServerProperties resourceServerProperties,
                                                                                           JwtAuthenticationConverter jwtAuthenticationConverter) {
        var trustedIssuers = new HashSet<String>();
        trustedIssuers.add(resourceServerProperties.getJwt().getIssuerUri());
        if (properties.getTrustedIssuers() != null && !properties.getTrustedIssuers().isEmpty()) {
            trustedIssuers.addAll(properties.getTrustedIssuers());
        }
        final Map<String, AuthenticationManager> managers = new HashMap<>();
        trustedIssuers.stream().forEach(l -> {
            log.info("Init authentication manager for issuer: {}", l);
            final var decoder = JwtDecoders.fromIssuerLocation(l);
            final var provider = new JwtAuthenticationProvider(decoder);
            provider.setJwtAuthenticationConverter(jwtAuthenticationConverter);
            managers.put(l, provider::authenticate);
        });
        return new JwtIssuerAuthenticationManagerResolver(managers::get);
    }
}
