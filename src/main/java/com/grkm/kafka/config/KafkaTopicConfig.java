package com.grkm.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

/**
 * @author Gorkem TANAGARDIGIL
 * @version 1.0.0
 * @since 9.02.2022 22:30
 */
@Configuration
public class KafkaTopicConfig {

    @Bean
    public KafkaAdmin.NewTopics createTopics() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("KafkaOne").build(),
                TopicBuilder.name("KafkaTwo").build(),
                TopicBuilder.name("KafkaThree").build());
    }

}
