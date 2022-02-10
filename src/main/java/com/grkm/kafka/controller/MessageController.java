package com.grkm.kafka.controller;

import com.grkm.kafka.domain.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gorkem TANAGARDIGIL
 * @version 1.0.0
 * @since 10.02.2022 09:35
 */
@RestController
@RequestMapping("api/v1/messages")
public class MessageController {

    private final KafkaTemplate<String ,String> kafkaTemplate;
    private final String[] topics= {"KafkaOne","KafkaTwo"};

    @Autowired
    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publish(@RequestBody MessageRequest messageRequest) {

        for (String topic : topics) {
            kafkaTemplate.send(topic, messageRequest.getData()).addCallback(new ListenableFutureCallback<>() {
                @Override
                public void onFailure(Throwable ex) {
                    System.out.println("System failure!");
                }

                @Override
                public void onSuccess(SendResult<String, String> result) {
                    System.out.println("Success!!!!");
                }
            });
        }
    }
}
