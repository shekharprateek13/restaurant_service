package my.restaurants.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import my.restaurants.model.Restaurant;
import my.restaurants.model.RestaurantDetailsList;

@Service
public class RestaurantServiceImpl implements IRestaurantService {
	
	private RestaurantDetailsList getRestaurantsList(String city,Integer page,int size){
		RestTemplate restTemplate = new RestTemplate();
		RestaurantDetailsList restaurantDetailsList = null;
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://opentable.herokuapp.com/api/restaurants")
				.queryParam("city",city)
				.queryParam("page",page)
				.queryParam("per_page",size);
		
		restaurantDetailsList = restTemplate.getForObject(builder.toUriString(),RestaurantDetailsList.class);
		return restaurantDetailsList;
	}

	@Override
	public Restaurant getRestaurantDetails(Integer id) {
		return null;
	}

	@Override
	public RestaurantDetailsList getAllRestaurants(String city, int page, int size) {
		return this.getRestaurantsList(city, page, size);
	}
}