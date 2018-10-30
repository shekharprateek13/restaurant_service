package restaurant.service.service;

import java.util.List;
import java.util.Optional;

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
		Optional<Restaurant> optional = restaurantRepository.findById((id));
		return optional.get();
	}
	
	@Override
	public List<Restaurant> getRestaurantDetailsByIds(List<Integer> ids) {
		return restaurantRepository.findAllById(ids);
	}

	@Override
	public List<Restaurant> getAllRestaurants(String city, Integer page, Integer per_page) {
		List<Restaurant> restaurantList = restaurantRepository.findRestaurantsByCity(city,page,per_page);
		return restaurantList;
	}
}