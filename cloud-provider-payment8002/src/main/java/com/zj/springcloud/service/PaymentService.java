package com.zj.springcloud.service;

import com.zj.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    int add(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
