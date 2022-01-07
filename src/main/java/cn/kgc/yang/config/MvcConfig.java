package cn.kgc.yang.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MvcConfig implements WebMvcConfigurer {//配置mvc 实现WebMvcConfigurer


    //消息转换器
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(mediaTypes);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converters.add(0, converter);
    }


    @Autowired
    CorsRegistryBean corsRegistryBean;

    //配置跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(corsRegistryBean.getMapping())
                .allowedOriginPatterns(corsRegistryBean.getOrigins())
                .allowedMethods(corsRegistryBean.getMethods())
                .allowedHeaders(corsRegistryBean.getHeaders());
    }

    @Bean
    public MessageSource messageSource() {
        //加载国际化源码
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        //路径
        source.setBasename("classpath:valitationMessages/valitationMessage");
        //字符集
        source.setDefaultEncoding("UTF-8");
        return source;
    }
}
