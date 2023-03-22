package net.ydclass.online_ydclass;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("net.ydclass.online_ydclass.mapper")
@EnableTransactionManagement
public class OnlineYdclassApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineYdclassApplication.class, args);
	}

}
