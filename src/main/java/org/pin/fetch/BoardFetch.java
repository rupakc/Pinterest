package org.pin.fetch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.pin.entity.Pin;
import org.pin.util.Utils;

/** 
 * Retrieves all the pins associated with a given board given the baord ID
 * @author Rupak Chakraborty
 * @since 28 October,2015
 */
public class BoardFetch {
	
	private String baseUrl = "https://api.pinterest.com/v1/boards/";
	private String accessParam = "/pins/?access_token=";
	private String accessToken = "AVznr7S7VFjxhfRRy-XfgU-e4AvyFA5OMH0zxYlCX1c48uAdAQAAAAA";
	private String suffixUrl = "&fields=id%2Clink%2Cnote%2Curl%2Ccounts%2Cmedia%2Cmetadata%2Cattribution%2Cboard%2Ccolor%2Coriginal_link%2Ccreated_at%2Ccreator%2Cimage";
	private String boardId = ""; 
	
	/** 
	 * public constructor to initialize the board object with default values
	 */
	public BoardFetch() {
		
		boardId = "146367125328626364";
	}
	
	/** 
	 * public constructor to initialize the board fetch object with boardId
	 * @param boardId String containing the boardId
	 */
	public BoardFetch(String boardId) {  
		
		this.boardId = boardId;
	}
	
	/** 
	 * public constructor to initialize the board fetch object
	 * @param boardId String containing the board Id
	 * @param accessToken String containing the access token
	 */
	public BoardFetch(String boardId,String accessToken) {  
		
		this.boardId = boardId;
		this.accessToken = accessToken;
	}
	
	/** 
	 * Returns the complete link to the board endpoint of the API
	 * @return String containing the complete link
	 */
	private String getCompleteLink() { 

		String link = this.baseUrl + this.boardId + this.accessParam + this.accessToken + this.suffixUrl;
		
		return link;
	}
	
	/** 
	 * Returns the list of pins in a given data response
	 * @param response JSONObject containing the response
	 * @return List<Pin> containing the pins
	 */
	@SuppressWarnings("unchecked")
	public List<Pin> getBoardPins(JSONObject response) { 
		
		List<Pin> boardPins = new ArrayList<Pin>();
		PinFetch pinFetch = new PinFetch();
		JSONArray dataArray = (JSONArray) response.get("data");
		JSONObject singlePin; 
		
		for (int i = 0; i < dataArray.size(); i++) {  
			
			singlePin = (JSONObject) dataArray.get(i);
			singlePin.put("data", singlePin);
			boardPins.add(pinFetch.getPinInfo(singlePin));
		} 
		
		return boardPins;
	}
	
	/** 
	 * Returns the list of Pins present on a board
	 * @return List<Pin> containing the pins on a given board
	 */
	public List<Pin> boardProcessingPipeline() { 
		
		String url = getCompleteLink();
		String nextPage = url;
		List<Pin> boardPins=new ArrayList<Pin>();
		JSONObject cursor;
		try {
			while(nextPage != null) { 
				String page = Utils.getPageResponse(nextPage);
				JSONObject response = Utils.getJSONPage(page);
				boardPins.addAll(getBoardPins(response)); 
				cursor = (JSONObject) response.get("page");
				nextPage = (String) cursor.get("next");
				System.out.println(boardPins.size());
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
		return boardPins;
	}
}
