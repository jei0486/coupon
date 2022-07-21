package com.shoppingmall.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="COUPON")
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CouponEntity {

    @Id
    private String id;      // UUID
    private String c_name; // 쿠폰 이름
    private int discount; // 할인율 혹은 할인되는 가격

    private LocalDateTime reg_date;
    // 세일 시작 시간 ~ 끝나는 시간
    private String start_dt;
    private String end_dt;

    private char rate_yn; // 할인율 혹은 할인 가격 여부
}
