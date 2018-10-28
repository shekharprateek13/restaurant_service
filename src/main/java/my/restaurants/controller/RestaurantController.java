/**
 * 
 */
package my.restaurants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import my.restaurants.model.RestaurantDetailsList;
import my.restaurants.service.IRestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	
	@Autowired
	IRestaurantService restaurantService;
	
	@GetMapping("{id}")
	public void getRestaurants(@PathVariable("id") Integer id){
		
	}
	
	@GetMapping(produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public RestaurantDetailsList getRestaurantsList(@RequestParam("city") String city){
		return restaurantService.getAllRestaurants(city, 1,100);
	}
}