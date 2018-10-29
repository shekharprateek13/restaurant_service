package restaurant.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import restaurant.service.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	
	@Query(value = "Select * from restaurant where city = :city limit :page, :page_size",nativeQuery = true)
	public List<Restaurant> findRestaurantsByCity(@Param("city") String city,@Param("page") Integer page,@Param("page_size") Integer page_size);
}