package com.microservice.currencyexhangeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.currencyexhangeservice.model.ExchangeValue;

public interface ExchangeServiceRepository extends JpaRepository<ExchangeValue, Long>{
	public List<ExchangeValue> findByFromAndTo(String from, String to);
}
