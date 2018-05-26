package cn.rlshop;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.rlshop.intercetor.OrderInterceptor;

/**
 * Created by hdl on 2018/2/29.
 */
//Sping SpringMVC的注解都可以使用
@SpringBootApplication(scanBasePackages = "cn.rlshop")
@MapperScan(basePackages ={"cn.rlshop.mapper"})
//web项目启动类  启动类上面必须加注解
public class Application {
	//SpringBoot 内置了tomcat  支持右键Run启动web项目
	//所有的Spring配置文件 都可以省略     在application.properties中添加自己的配置
    public static void main(String[] args) { 
        SpringApplication.run(Application.class,args);

    }
    
    


}
