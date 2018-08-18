package gontustart2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("gontustart2")

public class WebMvcConfig implements WebMvcConfigurer {
 
	//Linking the property file message.properties to error
	@Bean
	public ResourceBundleMessageSource messageSource()
	{
		ResourceBundleMessageSource rms=new ResourceBundleMessageSource();
		rms.setBasenames("resources/messages");
		return rms; 
	}
	
	
   @Bean
   public InternalResourceViewResolver resolver()
   {
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      //resolver.setViewClass(JstlView.class);
      resolver.setPrefix("/WEB-INF/views/");
      resolver.setSuffix(".jsp");
      return resolver;
   }
}