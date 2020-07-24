package br.com.minami.adapter;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

@Configuration
public class SpringBootAdapter implements WebMvcConfigurer{

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		PageableHandlerMethodArgumentResolver phmar = new PageableHandlerMethodArgumentResolver();
		phmar.setFallbackPageable(PageRequest.of(0, 30));
		argumentResolvers.add(phmar);
		
	}
	
}
