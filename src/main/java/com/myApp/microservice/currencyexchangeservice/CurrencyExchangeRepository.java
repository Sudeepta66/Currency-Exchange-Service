package com.myApp.microservice.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<currencyExchange,Long> {
	currencyExchange findByFromAndTo(String from,String to);

}
