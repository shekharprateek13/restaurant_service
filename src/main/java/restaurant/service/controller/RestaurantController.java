/**
 * 
 */
package restaurant.service.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import restaurant.service.model.Restaurant;
import restaurant.service.service.IRestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	
	@Autowired
	IRestaurantService restaurantService;
	
	@GetMapping(value="{id}",produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Restaurant getRestaurants(@PathVariable("id") Integer id){
		return restaurantService.getRestaurantDetails(id);
	}
	
	@GetMapping(value="/getbyids",produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Restaurant> getRestaurantsListByIds(@RequestParam("ids") String ids ){
		List<Integer> list = Arrays.asList(ids.split(",")).stream().mapToInt( s -> Integer.parseInt(s)).boxed().collect(Collectors.toList());
		return restaurantService.getRestaurantDetailsByIds(list);
	}
	
	@GetMapping(produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Restaurant> getRestaurantsList(@RequestParam("city") String city, @RequestParam("page") Integer page,@RequestParam("page_size")Integer page_size){
		return restaurantService.getAllRestaurants(city,page,page_size);
	}
}