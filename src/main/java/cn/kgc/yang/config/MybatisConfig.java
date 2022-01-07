package cn.kgc.yang.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.kgc.yang.mapper")
public class MybatisConfig {

}
