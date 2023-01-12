package otel_demo_server; 

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Data
@ConfigurationProperties(prefix = "server")
@ConstructorBinding
public class ConfigProperties {
    // none right now
}
