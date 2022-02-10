package com.grkm.kafka.listener;

import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author Gorkem TANAGARDIGIL
 * @version 1.0.0
 * @since 10.02.2022 09:24
 */
@Component
public class KafkaListeners {

    @KafkaListener(topics = "KafkaOne", groupId = "groupId")
    void kafkaOneListener(String data) {
        final StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> kStream = builder.stream("KafkaOne");
        final Topology topology = builder.build();
        System.out.println(topology.describe());
        System.out.println("KafkaOne " + "Listener received: " + data + "💪" ) ;
    }

    @KafkaListener(topics = "KafkaTwo", groupId = "groupId")
    void kafkaTwoListener(String data) {
        final StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> kStream = builder.stream("KafkaTwo");
        kStream.to("KafkaThree");
        final Topology topology = builder.build();
        System.out.println(topology.describe());
        System.out.println("KafkaTwo " + "Listener received: " + data + "💪" ) ;
    }

    @KafkaListener(topics = "KafkaThree", groupId = "groupId")
    void kafkaThreeListener(String data) {
        final StreamsBuilder builder = new StreamsBuilder();
        final Topology topology = builder.build();
        System.out.println(topology.describe());
        System.out.println("KafkaThree " + "Listener received: " + data + "💪");
    }
}
