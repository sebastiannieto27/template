package co.com.core.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.prodigious.capabilities.festivities")
/**
 * Main Spring configuration, Java-based
 * @author hencabal
 *
 */
public class AppConfig {

//	@Bean
//	public FestivityService getFestivityService() {
//		return new FestivityServiceImpl();
//	}
	
}
