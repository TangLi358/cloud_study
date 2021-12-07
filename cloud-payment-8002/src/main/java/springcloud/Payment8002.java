package springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //标记这个是eureka的client端
public class Payment8002 {
    public static void main(String[] args) {
        SpringApplication.run(Payment8002.class,args);
    }
}
