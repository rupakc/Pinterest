package org.pin.fetch;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.pin.entity.User;
import org.pin.util.Utils;

/** 
 * Retrieves information about a given user from Pinterest
 * @author Rupak Chakraborty
 * @since 25 October,2015
 */
@SuppressWarnings("unused")
public class UserFetch {
	
	private String baseUrl = "https://api.pinterest.com/v1/users/";
	private String accessTokenParam = "/?access_token=";
	private String accessToken = "AVznr7S7VFjxhfRRy-XfgU-e4AvyFA5OMH0zxYlCX1c48uAdAQAAAAA";
	private String userName;
	
	/** 
	 * 
	 * @param userName
	 */
	public UserFetch(String userName) { 
		
		this.userName = userName.trim();
	} 
	
	/** 
	 * 
	 * @param userName
	 * @param accessToken
	 */
	public UserFetch(String userName,String accessToken) { 
		
		this.userName = userName;
		this.accessToken = accessToken;
	}
	
	/** 
	 * 
	 * @param userName
	 * @return
	 */
	private String getFullLink(String userName) { 
		
		String url = this.baseUrl + userName.trim() + accessTokenParam + accessToken;
		return url;
	}
	
	/** 
	 * 
	 * @return
	 */
	private String getFullLink() { 
		
		String url = this.baseUrl + this.userName.trim() + accessTokenParam + accessToken;
		return url;
	} 
	
	/** 
	 * 
	 * @return
	 */
	private User getUserInfo() { 
		
		User pinUser = null;
		String url = getFullLink();
		try {
			String jsonResponse = Utils.getPageResponse(url);
			JSONObject response = Utils.getJSONPage(jsonResponse);
			pinUser = populateUserInfo(pinUser, response);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
		return pinUser;
	}
	
	/** 
	 * 
	 * @param userName
	 * @return
	 */
	private User getUserInfo(String userName) { 
		
		User pinUser = null;
		String url = getFullLink(userName);
		try {
			String jsonResponse = Utils.getPageResponse(url);
			JSONObject response = Utils.getJSONPage(jsonResponse);
			pinUser = populateUserInfo(pinUser, response);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
		return pinUser;
	}
	
	/** 
	 * 
	 * @param user
	 * @param json
	 * @return
	 */
	private User populateUserInfo(User user,JSONObject json) { 
		
		if (user == null) { 
			user = new User();
		} 
		
		JSONObject data = (JSONObject) json.get("data"); 
		
		user.setUrl((String) data.get("url"));
		user.setId((String) data.get("id"));
		user.setFirstName((String) data.get("first_name"));
		user.setLastName((String) data.get("last_name"));
		
		return user;
	}
}
