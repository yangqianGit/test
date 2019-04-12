package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class OrderController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private OrderProperties orderProperties;

	@Autowired
	private ItemFeignClient itemFeignClient;

	@GetMapping(value = "order/{id}")
	@HystrixCommand(fallbackMethod = "queryFallbackMethod")
	public Item query(@PathVariable("id") Long id) {
		String itemUrl = "http://app-item/item/{id}";
		Item result = restTemplate.getForObject(itemUrl, Item.class, id);
		System.out.println("订单系统调用商品服务,result:" + result);
		return result;
	}

	@GetMapping(value = "order2/{id}")
	public Item query2(@PathVariable("id") Long id) {
		String itemUrl = "http://app-item/item/{id}";
		Item result = restTemplate.getForObject(itemUrl, Item.class, id);
		System.out.println("订单系统调用商品服务,result:" + result);
		return result;
	}

	@GetMapping(value = "order3/{id}")
	public Item query3(@PathVariable("id") Long id) {
		Item result = itemFeignClient.query(id);
		System.out.println("order3-订单系统调用商品服务,result:" + result);
		return result;
	}

	/**
	 * 请求失败执行的方法 fallbackMethod的方法参数个数类型要和原方法一致
	 *
	 * @param id
	 * @return
	 */
	public Item queryFallbackMethod(Long id) {
		return new Item(id, "查询商品信息出错!", null, null, null);
	}
}
