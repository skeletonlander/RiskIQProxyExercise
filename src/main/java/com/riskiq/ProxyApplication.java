package com.riskiq;

import com.riskiq.config.ProxyConfig;
import com.riskiq.repository.ServiceOwnerRepository;
import com.riskiq.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.google.common.io.Resources;

@SpringBootApplication
public class ProxyApplication {

	private ProxyConfig proxyConfig;

	@Autowired
	public void setProxyConfig(ProxyConfig proxyConfig) {
		this.proxyConfig = proxyConfig;
	}

	@Bean
	UserRepository userRepository() {
		return new UserRepository(Resources.getResource(proxyConfig.getUserFile()));
	}

	@Bean
	ServiceOwnerRepository serviceOwnerRepository() {
		return new ServiceOwnerRepository(Resources.getResource(proxyConfig.getServiceOwnerFile()));
	}

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}
}
