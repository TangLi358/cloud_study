package springcloud.service.impl;

import com.lyl.springcloud.dao.PaymentDao;
import com.lyl.springcloud.service.PaymentService;
import entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
//    @Autowired
    @Resource
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPayment(@Param("id") Long id){
        return paymentDao.getPayment(id);
    }

}
