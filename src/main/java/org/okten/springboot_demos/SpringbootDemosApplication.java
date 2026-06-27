package org.okten.springboot_demos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(
        basePackages = "org.okten.springboot_demos",
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ASPECTJ,
                pattern = "org.okten.springboot_demos.hw_springBootDemo.*" // Шлях до моєї першої дз с машинами
        )
)
public class SpringbootDemosApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemosApplication.class, args);
    }
}
