package restaurant.service.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
public class ApiException {
	
	private int httpStatusCode;
	private HttpStatus httpStatus;
	private String message;

}