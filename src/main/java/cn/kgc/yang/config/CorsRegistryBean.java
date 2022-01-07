package cn.kgc.yang.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties("core.config")
public class CorsRegistryBean {
    private String Mapping;
    private String Headers;
    private String Origins;
    private String Methods;
}
