package com.zj.springcloud.controller;

import com.zj.springcloud.entities.Code;
import com.zj.springcloud.entities.CommonResult;
import com.zj.springcloud.entities.Payment;
import com.zj.springcloud.service.PaymentService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @ApiOperation(value = "添加支付订单")
    @PostMapping("/add")
    public CommonResult add(@RequestBody Payment payment) {
        int result = paymentService.add(payment);
        log.info("*****插入操作返回结果:" + result);

        if (result > 0) {
            return new CommonResult(Code.SUCCESS.getCode(), "插入数据库成功，server port: " + serverPort, result);
        } else {
            return new CommonResult(Code.ERROR.getCode(), "插入数据库失败, server port: " + serverPort, null);
        }
    }

    @ApiOperation(value = "根据id查询支付订单")
    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果:{}", payment);
        if (payment != null) {
            return new CommonResult(Code.SUCCESS.getCode(), "查询成功!server port: " + serverPort, payment);
        } else {
            return new CommonResult(Code.ERROR.getCode(), "没有对应记录,查询ID: " + id + " ,server port: " + serverPort, null);
        }
    }
}