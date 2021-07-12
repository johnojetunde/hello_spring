package com.shegoestech.hello_spring;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private String appName;
    private String ipAddress;
    private String password;
    private String basePathUrl;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBasePathUrl() {
        return basePathUrl;
    }

    public void setBasePathUrl(String basePathUrl) {
        this.basePathUrl = basePathUrl;
    }

    @Override
    public String toString() {
        return "AppConfig{" +
                "appName='" + appName + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", password='" + password + '\'' +
                ", basePathUrl='" + basePathUrl + '\'' +
                '}';
    }
}
