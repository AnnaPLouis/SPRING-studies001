package com.cydeo.entity;



import com.cydeo.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name="paymentDetails")
@NoArgsConstructor
public class PaymentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private BigDecimal merchantPayoutAmount;
    private BigDecimal commissionAmount;
    @Column(columnDefinition = "DATE")
    private LocalDate payoutDate;

    @OneToOne(mappedBy = "paymentDetail")
    private Payment payment;

    public PaymentDetail(BigDecimal merchantPayoutAmount, BigDecimal commissionAmount, LocalDate payoutDate) {
        this.merchantPayoutAmount = merchantPayoutAmount;
        this.commissionAmount = commissionAmount;
        this.payoutDate = payoutDate;
    }
}