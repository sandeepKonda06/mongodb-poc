package com.vertex.mongodbpoc.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class ApplicationProperties {
    @Value("${app.data.mongodb.connection.host}")
    private String mongodbHost;
    @Value("${app.data.mongodb.connection.port}")
    private Integer mongodbPort;
    @Value("${app.data.mongodb.connection.database}")
    private String mongodbDatabase;
    @Value("${app.data.mongodb.connection.username}")
    private String mongodbUsername;
    @Value("${app.data.mongodb.connection.password}")
    private String mongodbPassword;
    @Value("${app.data.mongodb.connection.timeout}")
    private Integer mongodbTimeout;
}
