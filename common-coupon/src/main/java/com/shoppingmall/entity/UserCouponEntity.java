package com.shoppingmall.entity;

import com.shoppingmall.dto.CouponResponseDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="USER_COUPON")
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserCouponEntity {

    @Id
    private String id;
    private String policy_id;
    private String user_id;
    private LocalDateTime issued_at;
    private LocalDateTime used_at;
    private String use_yn;

    public CouponResponseDto toResponseDto() {

        return CouponResponseDto.builder()

                .build();
    }
}
