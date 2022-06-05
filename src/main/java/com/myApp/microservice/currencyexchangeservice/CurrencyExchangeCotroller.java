package com.myApp.microservice.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeCotroller {
	
	@Autowired
	private Environment env;
	@Autowired
	private CurrencyExchangeRepository exchangeRepo ;
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public currencyExchange retrieveExchangeValue(@PathVariable String from,@PathVariable String to) 
	{
		String port = env.getProperty("local.server.port");
		//currencyExchange currencyExchange = new currencyExchange(1000L,from,to,BigDecimal.valueOf(50));
		currencyExchange currencyExchange = exchangeRepo.findByFromAndTo(from, to);
		if(currencyExchange==null)
		{
			throw new UserException("Resource not found");
		}
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}
	

}
