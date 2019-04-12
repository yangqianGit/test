package com.springboot.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class ItemServiceFallback implements ItemFeignClient {

	@Override
	public Item query(@PathVariable("id") Long id) {
		return new Item(id, "服务降级方法queryItemById", null, "服务降级方法queryItemById",
				null);
	}

}
