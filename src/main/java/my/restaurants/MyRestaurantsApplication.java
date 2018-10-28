package my.restaurants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MyRestaurantsApplication {
	
	   public static List<String> missingWords(String s, String t) {
	       List<String> result = new ArrayList<String>();
	       int j = 0;
	       int start = 0; int end = 1;
	       for(int i = 0; i < s.length() && j < t.length();i++){
	           if(s.charAt(i) == ' ')continue;
	           if(s.charAt(i) == t.charAt(j)){
	               j++;
	               if(start!=end){
	                   result.add(s.substring(start,end));
	                   start = i;
	                   end = i;
	               }
	           }else{
	               // System.out.println("Start:"+start+"; End:"+end+":"+s.charAt(i));
	               if(start == end){
	                  start = i;
	               }else{
	                  end = i;
	               }
	           }
	       }
	        return result;
	    }

	public static void main(String[] args) {
//		SpringApplication.run(MyRestaurantsApplication.class, args);
		missingWords("I am using HackerRank to improve programming","am HackerRank to improve");
		Map<String, Integer> map;
//		map.keySet()
	}
}
