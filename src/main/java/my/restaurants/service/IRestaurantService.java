package my.restaurants.service;

import my.restaurants.model.Restaurant;
import my.restaurants.model.RestaurantDetailsList;

public interface IRestaurantService {
	public Restaurant getRestaurantDetails(Integer id);
    public RestaurantDetailsList getAllRestaurants(String city, int page, int size);
}