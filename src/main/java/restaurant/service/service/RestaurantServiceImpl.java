package restaurant.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restaurant.service.model.Restaurant;
import restaurant.service.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements IRestaurantService {

	@Autowired
	RestaurantRepository restaurantRepository;

	@Override
	public Restaurant getRestaurantDetails(Integer id) {
		return null;
	}

	@Override
	public List<Restaurant> getAllRestaurants(String city, Integer page, Integer per_page) {
		List<Restaurant> restaurantList = restaurantRepository.findRestaurantsByCity(city,page,per_page);
		return restaurantList;
	}
}