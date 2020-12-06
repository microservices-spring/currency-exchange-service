package com.microservice.currencyexhangeservice.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.currencyexhangeservice.model.ExchangeValue;
import com.microservice.currencyexhangeservice.repository.ExchangeServiceRepository;

@RestController
@RequestMapping("currency-exchange")
public class CurrencyExchangeController {
	@Autowired
	private Environment env;

	@Autowired
	private ExchangeServiceRepository repo;
	
	@GetMapping("/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangevalue(@PathVariable String from, @PathVariable String to) {
		List<ExchangeValue> exchangeValues = repo.findByFromAndTo(from, to);
		if(exchangeValues != null && exchangeValues.size() > 0) {
			exchangeValues.get(0).setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return exchangeValues.get(0);
		}
		return null;
//		return new ExchangeValue(101L, "USD", "INR", BigDecimal.valueOf(65),
//				Integer.parseInt(env.getProperty("local.server.port")));
	}
}
