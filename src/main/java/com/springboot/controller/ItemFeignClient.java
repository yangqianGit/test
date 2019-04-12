package com.springboot.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 申明这是一个Feign客户端，并且指明服务id
 */
@FeignClient(value = "app-item", fallback = ItemServiceFallback.class)
public interface ItemFeignClient {

	@RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
	public Item query(@PathVariable("id") Long id);
}
