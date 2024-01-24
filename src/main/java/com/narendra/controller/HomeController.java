package com.narendra.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.narendra.config.DataSourceConfig;

@RestController
@RefreshScope
public class HomeController {

	@Value("${spring.jpa.show-sql}")
	private String jpaShowSql;
	
	private DataSourceConfig dataSourceConfig;
	
	public HomeController(DataSourceConfig dataSourceConfig) {
		this.dataSourceConfig = dataSourceConfig;
	}
	
	@GetMapping("/dsconfig")
	public ResponseEntity<DataSourceConfig> getDSConfig() {
		dataSourceConfig.setJpaShowSql(jpaShowSql);
		return new ResponseEntity<>(dataSourceConfig, HttpStatus.OK);
	}
}
