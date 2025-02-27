package ducanh.pro.musicservice.config;

import lombok.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class AuditingConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }

    public static class AuditorAwareImpl implements AuditorAware<String> {

        @NonNull
        @Override
        public Optional<String> getCurrentAuditor() {
            return Optional.ofNullable("SecurityContextHolder.getContext().getAuthentication().getName()");
        }
    }
}
