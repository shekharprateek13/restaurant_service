package restaurant.service.batchservice;

import java.util.List;

import restaurant.service.model.Restaurant;

public interface IRestaurantBatchService {
	
	public void fetchRestaurants(String city, int page, int size);
	
	public void saveRestaurants(List<Restaurant> restaurantList);

}
