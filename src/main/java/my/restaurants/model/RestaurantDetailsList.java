package my.restaurants.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor @ToString
public class RestaurantDetailsList {
	private Integer total_entries;
	private Integer per_page;
	private Integer current_page;
	private List<Restaurant> restaurants;
}
