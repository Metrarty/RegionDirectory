package com.example.RegionDirectory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
//@MapperScan(value = "com.example.RegionDirectory.service.mapper.RegionMapper")
public class RegionDirectoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegionDirectoryApplication.class, args);
	}

}
