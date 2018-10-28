/**
 * 
 */
package my.restaurants.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author shekh
 */
@Getter @Setter @NoArgsConstructor 
@AllArgsConstructor @ToString 
@Entity
@Table(name="restaurant")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
public class Restaurant {

	@Id
	private Integer id;
	private String name;
	private String address;
	private String city;
	private String state;
	private String area;

	@JsonProperty("postal_code")
	@Column(name = "postal_code")
	private Integer postalCode;
	
	private String country;
	
	@JsonProperty("phone")
	@Column(name = "phone")
	private String phoneNumber;
	
	@JsonProperty("lat")
	private Double latitude;
	
	@JsonProperty("lng")
	private Double longitude;
	private Double price;
	
	@JsonProperty("reserve_url")
	@Column(name = "reserve_url")
	private String reserveURL;
	
	@JsonProperty("mobile_reserve_url")
	@Column(name = "mobile_url")
	private String mobileURL;
	
	@JsonProperty("image_url")
	@Column(name = "image_url")
	private String imageURL;

	@JsonIgnore
	@Column(nullable = false, updatable = false)
	@CreatedDate
	private Date createdAt;

	@JsonIgnore
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
}