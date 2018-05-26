package cn.rlshop.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hr on 2017/8/23.
 */
@Configuration
// 注意，由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解
@AutoConfigureAfter(MyBatisConfig.class)
public class MapperScannerConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //设置sqlSession工厂
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        //设置mapper扫描包
        mapperScannerConfigurer.setBasePackage("cn.rlshop.mapper");
        return mapperScannerConfigurer;
    }




}
