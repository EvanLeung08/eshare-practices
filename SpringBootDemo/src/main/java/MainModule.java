import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liangyh on 2016/9/10.
 * Email:10856214@163.com
 */
@RestController
@EnableAutoConfiguration
public class MainModule {
    @RequestMapping("/sayHello")
    String sayHello() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainModule.class, args);
    }
}
