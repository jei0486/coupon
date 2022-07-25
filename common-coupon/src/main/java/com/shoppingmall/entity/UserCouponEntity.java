package com.shoppingmall.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shoppingmall.dto.CouponResponseDto;
import com.shoppingmall.dto.UserCouponResponseDto;
import lombok.*;

import javax.persistence.*;
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_id", referencedColumnName = "id")
    private CouponEntity coupon;

    public UserCouponResponseDto toResponseDto() {

        return UserCouponResponseDto.builder()
                .user_id(user_id)
                .discount(coupon.getDiscount())
                .c_name(coupon.getC_name())
                .rate_yn(coupon.getRate_yn())
                .start_dt(coupon.getStart_dt())
                .end_dt(coupon.getEnd_dt())
                .build();
    }
}
