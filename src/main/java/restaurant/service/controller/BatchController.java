package restaurant.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import restaurant.service.batchservice.IRestaurantBatchService;

@RestController
@RequestMapping("/batch")
public class BatchController {

	@Autowired
	IRestaurantBatchService restaurantBatchService;

	@GetMapping("/fetchRestaurants")
	public void fetchRestaurants(@RequestParam("city") String city, @RequestParam("page") Integer page,@RequestParam("page_size")Integer page_size) {
		restaurantBatchService.fetchRestaurants(city,page,page_size);
	}
}