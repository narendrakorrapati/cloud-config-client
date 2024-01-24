package com.narendra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.narendra.config.DataSourceConfig;

@RestController
public class HomeController {

	private DataSourceConfig dataSourceConfig;
	
	public HomeController(DataSourceConfig dataSourceConfig) {
		this.dataSourceConfig = dataSourceConfig;
	}
	
	@GetMapping("/dsconfig")
	public ResponseEntity<DataSourceConfig> getDSConfig() {
		return new ResponseEntity<>(dataSourceConfig, HttpStatus.OK);
	}
}
