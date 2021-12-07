package springcloud.contraoller;

import entities.CommonResult;
import entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import springcloud.service.PaymentService;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*** 插入結果：" + result);
        if (result > 0) {
            return new CommonResult(200, "success", result);
        }
        return new CommonResult(400, "fail", null);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPayment(id);
        log.info("*** 插入結果：" + result);
        if (null != result) {
            return new CommonResult(200, "success", result);
        }
        return new CommonResult(400, "fail", null);
    }
}
