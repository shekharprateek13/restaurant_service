package restaurant.service.service;

import java.util.List;

import restaurant.service.model.Restaurant;

public interface IRestaurantService {
	public Restaurant getRestaurantDetails(Integer id);
	public List<Restaurant> getAllRestaurants(String city, Integer page, Integer per_page);
	public List<Restaurant> getRestaurantDetailsByIds(List<Integer> ids);
}