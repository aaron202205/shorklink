package top.dooc.shortlink;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author aaronchen
 * @date 2024/3/19 上午11:05
 */
@SpringBootApplication
@MapperScan("top.dooc.shortlink.dao.mapper")
public class ShortLinkApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShortLinkApplication.class, args);
    }
}
