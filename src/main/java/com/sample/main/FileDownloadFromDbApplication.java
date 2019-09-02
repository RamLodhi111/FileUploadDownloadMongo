package com.sample.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan("com.sample.*")
@EnableMongoRepositories("com.sample.repository")
public class FileDownloadFromDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileDownloadFromDbApplication.class, args);
	}

}
