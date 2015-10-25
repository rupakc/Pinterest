package org.pin.fetch;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.pin.entity.Attribution;
import org.pin.entity.MetadataArticle;
import org.pin.entity.MetadataLink;
import org.pin.entity.Pin;
import org.pin.util.Utils;

/** 
 * Fetches information relating to a given pin from Pinterest
 * @author Rupak Chakraborty
 * @since 25 October,2015
 */
public class PinFetch {
	
	String baseUrl = "https://api.pinterest.com/v1/pins/";
	String accessTokenParam = "/?access_token=";
	String accessToken = "AVznr7S7VFjxhfRRy-XfgU-e4AvyFA5OMH0zxYlCX1c48uAdAQAAAAA";
	String suffixParam = "&fields=id%2Clink%2Cnote%2Curl%2Cattribution%2Cboard%2Ccolor%2Ccounts%2Ccreated_at%2Ccreator%2Cimage%2Cmedia%2Cmetadata%2Coriginal_link";
	String pinId = "";
	
	/** 
	 * 
	 * @param pinId
	 */
	public PinFetch(String pinId) { 
		
		this.pinId = pinId.trim();
	}
	
	/** 
	 * 
	 * @param pinId
	 * @param accessToken
	 */
	public PinFetch(String pinId,String accessToken) { 
		
		this.pinId = pinId;
		this.accessToken = accessToken;
	}
	
	/** 
	 * 
	 * @return
	 */
	private String getFullUrl() { 
		
		String url = this.baseUrl + this.pinId + this.accessTokenParam + this.accessToken + this.suffixParam;
		return url;
	}
	
	/** 
	 * 
	 * @return
	 */
	public Pin getPin() { 
		Pin pin = null;
		String url = getFullUrl();
		try {
			String page = Utils.getPageResponse(url);
			JSONObject parsedResponse = Utils.getJSONPage(page);
			pin = getPinInfo(parsedResponse);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return pin;
	}
	
	/** 
	 * 
	 * @param json
	 * @return
	 */
	public Pin getPinInfo(JSONObject json) { 
		
		Pin pin = new Pin();
		JSONObject data = (JSONObject) json.get("data");
		JSONObject counts = (JSONObject) data.get("counts");
		JSONObject creator = (JSONObject) data.get("creator");
		JSONObject board = (JSONObject) data.get("board");
		JSONObject image = (JSONObject) data.get("image");
		JSONObject media = (JSONObject) data.get("media");
		image = (JSONObject) image.get("original");
		pin.setLikeCount((Long)(counts.get("likes")));
		pin.setCommentCount((Long)counts.get("comments"));
		pin.setRepinCount((Long)counts.get("repins"));
		pin.setCreatorFirstName((String) creator.get("first_name"));
		pin.setCreatorLastName((String) creator.get("last_name"));
		pin.setCreatorId((String) creator.get("id"));
		pin.setCreatorUrl((String) creator.get("url"));
		pin.setLink((String) data.get("link"));
		pin.setOriginalLink((String) data.get("original_link"));
		pin.setBoardUrl((String) board.get("url"));
		pin.setBoardId((String) board.get("id"));
		pin.setBoardName((String) board.get("name"));
		pin.setUrl((String) data.get("url"));
		pin.setNote((String) data.get("note"));
		pin.setMediaType((String) media.get("type"));
		pin.setColor((String) data.get("color"));
		pin.setCreatedAt((String) data.get("created_at"));
		pin.setImageUrl((String) image.get("url"));
		pin.setImageHeight((Long) image.get("height"));
		pin.setImageWidth((Long) image.get("width"));
		pin.setId((String) data.get("id"));
		
		return pin;
	}
	
	/** 
	 * 
	 * @param json
	 * @return
	 */
	public MetadataLink getMetadataLinkInfo(JSONObject json) { 
		
		MetadataLink metaDataLink = new MetadataLink();
		JSONObject data = (JSONObject) json.get("data");
		JSONObject metaData = (JSONObject) data.get("metadata");
		JSONObject link = (JSONObject) metaData.get("link");
		
		if (link != null) { 
			
			metaDataLink.setDescription((String) link.get("description"));
			metaDataLink.setFavicon((String) link.get("favicon"));
			metaDataLink.setTitle((String) link.get("title"));
			metaDataLink.setLocale((String) link.get("locale"));
			metaDataLink.setSiteName((String) link.get("site_name"));
		}
		
		return metaDataLink;
	}
	
	/** 
	 * 
	 * @param json
	 * @return
	 */
	public MetadataArticle getMetadataArticleInfo(JSONObject json) { 
		
		MetadataArticle metaDataArticle = new MetadataArticle();
		JSONObject data = (JSONObject) json.get("data");
		JSONObject metaData = (JSONObject) data.get("metadata");
		JSONObject article = (JSONObject) metaData.get("article");
		
		if (article != null) { 
			
			metaDataArticle.setDescription((String) article.get("description"));
			metaDataArticle.setName((String) article.get("name"));
			metaDataArticle.setPublishedAt((String) article.get("published_at"));
			metaDataArticle.setAuthors(Utils.convertJSONArrayToList((JSONArray) article.get("authors")));
		}
		
		return metaDataArticle;
	} 
	
	/** 
	 * 
	 * @param json
	 * @return
	 */
	public Attribution getPinAttributionInfo(JSONObject json) {  
		
		Attribution attribute = new Attribution();
		JSONObject data = (JSONObject) json.get("data");
		JSONObject attribution = (JSONObject) data.get("attribution");
		
		if (attribution != null) { 
			
			attribute.setAuthorName((String) attribution.get("author_name"));
			attribute.setAuthorUrl((String) attribution.get("author_url"));
			attribute.setProviderFaviconUrl((String) attribution.get("provider_favicon_url"));
			attribute.setProviderName((String) attribution.get("provider_name"));
			attribute.setTitle((String) attribution.get("title"));
			attribute.setUrl((String) attribution.get("url"));
		}
		
		return attribute;
	}
}
