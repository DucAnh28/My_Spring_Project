//package ducanh.pro.authservice.config.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests(authorizeRequests ->
//                authorizeRequests
//                    .antMatchers("/public/**").permitAll()  // cho phép truy cập public
//                    .anyRequest().authenticated()  // yêu cầu xác thực với các request còn lại
//            )
//            .oauth2ResourceServer(oauth2ResourceServer ->
//                oauth2ResourceServer.jwt(jwtConfigurer ->
//                    jwtConfigurer.jwtAuthenticationConverter(jwtAuthenticationConverter())
//                )
//            );
//
//        return http.build();
//    }
//
//    private JwtAuthenticationConverter jwtAuthenticationConverter() {
//        return new JwtAuthenticationConverter();
//    }
//}
