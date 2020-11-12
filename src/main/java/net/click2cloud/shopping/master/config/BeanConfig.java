/**
 * 
 */
package net.click2cloud.shopping.master.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Admin
 *
 */
@Configuration
public class BeanConfig {
	
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

}
