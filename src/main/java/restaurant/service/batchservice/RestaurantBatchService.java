package restaurant.service.batchservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import restaurant.service.model.Restaurant;
import restaurant.service.model.RestaurantDetailsList;
import restaurant.service.repository.RestaurantRepository;

@Service
public class RestaurantBatchService implements IRestaurantBatchService {
	
	@Autowired
	RestaurantRepository restaurantRepository;

	@Override
	public void fetchRestaurants(String city, int page, int size) {
		RestaurantDetailsList restaurantDetailsList = this.getRestaurantsList(city, page, size);
		saveRestaurants(restaurantDetailsList.getRestaurants());
	}

	@Override
	public void saveRestaurants(List<Restaurant> restaurantList) {
		restaurantRepository.saveAll(restaurantList);
	}
	
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
}