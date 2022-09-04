package maven_test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="maven_test.*")
public class ServletConfig extends WebMvcConfigurationSupport {
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

	@Bean
	public SessionLocaleResolver localeResolver(){
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		return sessionLocaleResolver;
	}
	
	/*
	// 쿠키를 이용한 Locale 이용시 이 부분을 주석처리를 풀어서 사용하고 위에 있는 SessionLocaleResolver 클래스를 사용하는
	// @Bean 메소드는 주석처리 한다
	@Bean
	public CookieLocaleResolver localeResolver(){
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		return cookieLocaleResolver;
	} 
	 */
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
    	LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
    	localeChangeInterceptor.setParamName("language");
    	return localeChangeInterceptor;
    }
    
    
    @Bean
    public UrlBasedViewResolver urlBasedViewResolver(){
    	UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
    	urlBasedViewResolver.setPrefix("/WEB-INF/views/");
    	urlBasedViewResolver.setSuffix(".jsp");
    	return urlBasedViewResolver;
    }

	
    @Override
	protected void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/cmmn/validator.do").setViewName("cmmn/validator");
	}


}
