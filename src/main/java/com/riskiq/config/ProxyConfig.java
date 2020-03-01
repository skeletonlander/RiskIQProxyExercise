package com.riskiq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @author riskiq
 * @created 1/17/18
 */
@Component
@ConfigurationProperties(value = "riskiq.proxy")
@EnableScheduling
public class ProxyConfig {

    private String userFile;
    private String serviceOwnerFile;

    public String getUserFile() {
        return userFile;
    }

    public void setUserFile(String userFile) {
        this.userFile = userFile;
    }

    public String getServiceOwnerFile() {return serviceOwnerFile;}
    public void setServiceOwnerFile(String serviceOwnerFile) {this.serviceOwnerFile = serviceOwnerFile;}
}