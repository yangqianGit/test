package com.springboot;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ItemControllerTest.class)
@Import(OrderSpringBoot.class)
public class ItemControllerTest {
	@Autowired
	private LoadBalancerClient loadBalancerClient;// 自动注入

	// @Test
	// public void test() {
	// String serviceId = "app-item";
	// for (int i = 0; i < 100; i++) {
	// ServiceInstance serviceInstance = this.loadBalancerClient
	// .choose(serviceId);
	// System.out.println("第" + (i + 1) + "次：" + serviceInstance.getHost()
	// + ": " + serviceInstance.getPort());
	// }
	// }
}
