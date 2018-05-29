package hello;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
/***
 * @Configuration   @EnableAutoConfiguration  @ComponentScan
 */
/*
public class Application extends WebMvcConfigurerAdapter {
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		*/
/**
		 *1. 先定义一个convert的信息转化对象：
		 * 2.添加fastJson的配置信息，比如是否要格式化返回json数据。
		 * 3.在convert中添加配置信息。
		 * 4.将convert添加到converts中。
		 *//*

		//1. 先定义一个convert的信息转化对象：
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		//2.添加fastJson的配置信息，比如是否要格式化返回json数据。
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		//3.在convert中添加配置信息。
		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
		//4.将convert添加到converts中。
		converters.add(fastJsonHttpMessageConverter);
	}

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}*/

public class Application{
	/**
	 * 第二种方式使用fastjson
	 * @param args
	 */
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverts(){
		//需要先定义一个convert转化消息对象
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		//2.添加fastJson的配置信息，比如是否要格式化返回json数据。
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

		//3.在convert 中添加配置信息：
		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

		return new HttpMessageConverters(fastJsonHttpMessageConverter);
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class,args);
	}
}
