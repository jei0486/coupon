package com.shoppingmall.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoppingmall.entity.UserCouponEntity;
import com.shoppingmall.repository.UserCouponRepository;
import com.shoppingmall.vo.TimeAttackVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaService {

    final ObjectMapper mapper;
    private final UserCouponRepository userCouponRepository;
/*
Spring에서 컨테이너 팩토리는 KafkaListenerContainerFactory, ConcurrentKafkaListenerContainerFactory 두 가지가 제공됨
전자는 동시성 처리를 지원히지 않고, 후자는 동시성 처리를 지원하기 때문에 후자를 사용할 경우에는
하나의 컨슈머에서 여러개의 파티션을 연결하여 멀티 소비가 가능함
* */

    // TimeAttackCouponIssue
    @KafkaListener(containerFactory = "timeAttackCouponKafkaListenerContainerFactory", topics = "${spring.kafka.consumer.timeAttackCouponConsumerConfig.topic}")
    public void TimeAttackCouponIssue(String vo) {
        log.info("TimeAttackCouponIssue > TimeAttackVo : {}" , vo);
        try {
            TimeAttackVO timeAttackVO = mapper.readValue(vo,TimeAttackVO.class);

            log.info("TimeAttackCouponIssue > TimeAttackVo : {}" , String.valueOf(timeAttackVO));
            UserCouponEntity userCouponEntity = UserCouponEntity.builder()
                    .id(UUID.randomUUID().toString())
                    .user_id(timeAttackVO.getUser_id())
                    .policy_id(timeAttackVO.getKey())
                    .issued_at(LocalDateTime.now())
                    .build();

            userCouponRepository.save(userCouponEntity);
            log.info("userCouponEntity : {}",String.valueOf(userCouponEntity));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

//    @KafkaListener(containerFactory = "timeAttackCouponKafkaListenerContainerFactory", topics = "${spring.kafka.consumer.timeAttackCouponConsumerConfig.topic}")
//    public void TimeAttackCouponIssue(ConsumerRecord<String, String> consumerRecord) {
//        log.info("TimeAttackCouponIssue > ConsumerRecord : {}" , String.valueOf(consumerRecord));
//    }

}
