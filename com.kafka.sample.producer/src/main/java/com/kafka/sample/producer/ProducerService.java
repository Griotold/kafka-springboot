package com.kafka.sample.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;


    public void sendMessage(String topic , String key, String message) {
        for (int i = 0; i < 10; i++) {
            log.info("ProductService.sendMessage topic = {}, key = {}, message = {}", topic, key, message + " " + i);
            kafkaTemplate.send(topic, key, message + " " + i);
        }

    }
}
