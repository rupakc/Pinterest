package org.pin.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/** 
 * Defines a set of utility functions to used frequently 
 * @author Rupak Chakraborty
 * @since 25 October,2015
 */
public class Utils {
	
	/** 
	 * Given a JSON response in form of a string converts it into a JSON Object
	 * @param page String containing the JSON response
	 * @return JSON Object containing the response
	 * @throws ParseException
	 */
	public static JSONObject getJSONPage(String page) throws ParseException { 
		
		JSONParser parser = new JSONParser();
		JSONObject jsonPage = (JSONObject) parser.parse(page);
		
		return jsonPage;
		
	}
	
	/** 
	 * Given a url opens it and returns a String containing the response
	 * @param url String containing the unique url
	 * @return String containing the contents of the given url
	 * @throws IOException
	 */
	public static String getPageResponse(String url) throws IOException { 
		
		StringBuilder page = new StringBuilder("");
		String temp = "";
		URL link = new URL(url);
		BufferedReader br = new BufferedReader(new InputStreamReader(link.openStream()));
		
		while((temp = br.readLine()) != null) { 
			
			page = page.append(temp);
		}
		
		return page.toString();
	}
	
	/** 
	 * Converts a comma separated string to a list
	 * @param s String containing the comma separated values
	 * @return List<String> containing the contents of the string
	 */
	public static List<String> convertCsvToList(String s) { 
		
		List<String> stringList = new ArrayList<String>();
		String [] values = s.split(",");
		for (String val : values) { 
			stringList.add(val.trim());
		}
		
		return stringList;
	}
	
	/** 
	 * Converts a comma separated String into a set
	 * @param s String containing the comma separated values
	 * @return Set<String> containing the values
	 */
	public static Set<String> convertCsvToSet(String s) { 
		
		List<String> stringList = convertCsvToList(s);
		Set<String> set = new HashSet<String>();
		for (String list : stringList) { 
			set.add(list);
		}
		
		return set;
	}
}
