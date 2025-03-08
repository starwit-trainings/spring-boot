package de.starwit.valkey_demo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class SenderService {

    private Logger log = LoggerFactory.getLogger(SenderService.class);

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Value("${spring.redis.streamId:test}")
    private String streamId;

    @PostConstruct
    public void init() {
        log.info("streamId: " + streamId);
        System.out.println("Service init");       
    }

    @Scheduled(fixedRate = 1000)
    public void sendMessage() {
        System.out.println("test");
        log.info("send message to " + streamId);
        try {
            Map<String, String> messageMap = new HashMap<>();
            messageMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
            messageMap.put("message", "Hello from producer " + LocalDateTime.now());

            RecordId recordId = redisTemplate.opsForStream()
                    .add(StreamRecords.newRecord()
                            .in(streamId)
                            .ofMap(messageMap));

            log.info("Message sent to stream {} with id {}", streamId, recordId);

        } catch (Exception e) {
            log.error("Error sending message to stream: ", e);
        }
    }
}
