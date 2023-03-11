/**
 * 
 */
package com.droppa.services.spring.droppaclone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

import lombok.RequiredArgsConstructor;

/**
 * @author Ernest Mampana
 *
 */
@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		return 
	}
}
