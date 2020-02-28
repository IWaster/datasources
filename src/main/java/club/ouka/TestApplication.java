package club.ouka;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description:
 * User: Ouka
 * Date: 2020-02-26
 * Time: 17:19
 */
@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
                                  DataSourceTransactionManagerAutoConfiguration.class,
                                  JdbcTemplateAutoConfiguration.class})
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class,args);
    }
}
