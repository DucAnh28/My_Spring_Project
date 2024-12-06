package ducanh.pro.commonconfig.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "gobiz.dota.resource-server", ignoreUnknownFields = false)
public class MultiOAuth2ResourceServerProperties implements Serializable {
    private List<String> trustedIssuers;
}