package com.vertex.mongodbpoc.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DbConfig {

    private final @NonNull ApplicationProperties properties;

    @Bean
    public MongoClient mongodbClient() {
        ServerAddress server = new ServerAddress(properties.getMongodbHost(), properties.getMongodbPort());
        MongoCredential credential = MongoCredential.createCredential(properties.getMongodbUsername(),
                properties.getMongodbDatabase(),
                properties.getMongodbPassword().toCharArray());
        MongoClientOptions param = new MongoClientOptions.Builder()
                .connectTimeout(properties.getMongodbTimeout())
                .build();
        return new MongoClient(server, credential, param);
    }

    @Bean
    public MongoDatabase mongopocDb(@NonNull @Qualifier("mongodbClient") final MongoClient mongoClient) {
        return mongoClient.getDatabase(properties.getMongodbDatabase());
    }

    @Bean
    public MongoCollection<Document> invoiceCollection(@NonNull @Qualifier("mongopocDb") final MongoDatabase database) {
        return database.getCollection("invoice");
    }
}
