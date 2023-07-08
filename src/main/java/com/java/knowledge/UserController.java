/**
 * 
 */
package com.java.knowledge;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Viraj Bansode
 *
 * 08-Jul-2023
 */

@RestController
@RefreshScope
public class UserController {
	
	@Value("${my.user.name}")
	private String userName;
	
	@Value("${office.name}")
	private String officeName;
	
	@GetMapping("/details")
	public String getDetails() {
		
		return "Welcome "+userName+", greetings from : "+officeName;
		
	}

}
