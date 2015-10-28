package org.pin.fetch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.pin.entity.Attribution;
import org.pin.entity.Ingredient;
import org.pin.entity.MetadataArticle;
import org.pin.entity.MetadataLink;
import org.pin.entity.MetadataRecipe;
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
	
	public PinFetch() { 
		
	}
	/** 
	 * public constructor to initialize the PinFetch object with pinId
	 * @param pinId String containing the unique Id of the pin
	 */
	public PinFetch(String pinId) { 
		
		this.pinId = pinId.trim();
	}
	
	/** 
	 * public constructor to initialize the PinFetch object
	 * @param pinId String containing the pinID
	 * @param accessToken String containing the accessToken
	 */
	public PinFetch(String pinId,String accessToken) { 
		
		this.pinId = pinId;
		this.accessToken = accessToken;
	}
	
	/** 
	 * Returns the full url of the pin endpoint api
	 * @return String containing the full url
	 */
	private String getFullUrl() { 
		
		String url = this.baseUrl + this.pinId + this.accessTokenParam + this.accessToken + this.suffixParam;
		return url;
	}
	
	/** 
	 * Fetches and returns the pin
	 * @return Pin object associated with the  JSON response
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
	 * Converts a JSON response into a pin object
	 * @param json JSONObject containing the JSON response
	 * @return Pin object containing the necessary fields
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
		pin.setMetaRecipe((getMetadataRecipeInfo(data)));
		pin.setMetaArticle(getMetadataArticleInfo(data));
		pin.setMetaLink(getMetadataLinkInfo(data));
		pin.setAttribution((getPinAttributionInfo(data)));
		
		return pin;
	}
	
	/** 
	 * Returns the metaDataLink information associated with a given json object
	 * @param json JSONObject containing the metadata
	 * @return MetadataLink containing the metadata link information
	 */
	public MetadataLink getMetadataLinkInfo(JSONObject json) { 
		
		MetadataLink metaDataLink = new MetadataLink();
		JSONObject metaData = (JSONObject) json.get("metadata");
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
	 * Returns the article info associated with the pin meta data
	 * @param json JSONObject containing the JSON response
	 * @return MetadataArticle object
	 */
	public MetadataArticle getMetadataArticleInfo(JSONObject json) { 
		
		MetadataArticle metaDataArticle = new MetadataArticle();
		JSONObject metaData = (JSONObject) json.get("metadata");
		JSONObject article = (JSONObject) metaData.get("article");
		
		if (article != null) { 
			
			metaDataArticle.setDescription((String) article.get("description"));
			metaDataArticle.setName((String) article.get("name"));
			metaDataArticle.setPublishedAt((String) article.get("published_at"));
			metaDataArticle.setAuthors(getMetadataArticleAuthors(metaData));
		}
		
		return metaDataArticle;
	} 
	
	/** 
	 * Returns a list of author associated with a meta data article
	 * @param metadata JSONObject containing the meta data
	 * @return List<String> containing the author list
	 */
	public List<String> getMetadataArticleAuthors(JSONObject metadata) { 
		
		JSONObject article = (JSONObject) metadata.get("article");
		List<String> authorList = new ArrayList<String>();
		if (article != null) { 
			JSONArray jsonArray = (JSONArray) article.get("authors");
			for (int i = 0; i < jsonArray.size(); i++) { 
				JSONObject author = (JSONObject) jsonArray.get(i);
				authorList.add((String) author.get("name"));
			}
		}
		
		return authorList;
	}
	/** 
	 * Returns the attribution information associated with a given pin object
	 * @param json JSON object containing the entire json response
	 * @return Attribution containing the attribution information
	 */
	public Attribution getPinAttributionInfo(JSONObject json) {  
		
		Attribution attribute = new Attribution();
		JSONObject attribution = (JSONObject) json.get("attribution");
		
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
	
	/** 
	 * Extracts the metadata recipe information for a given pin (if present)
	 * @param json JSON object containing the metadata information
	 * @return MetadataRecipe object containing the required information
	 */
	public MetadataRecipe getMetadataRecipeInfo(JSONObject json) {  
		
		MetadataRecipe recipe = new MetadataRecipe();
		JSONObject metadataJSON = (JSONObject) json.get("metadata");
		JSONObject recipeJSON = (JSONObject) metadataJSON.get("recipe");
		
		if (recipeJSON != null) { 
			
			recipe.setName((String) recipeJSON.get("name"));
			recipe.setIngredients(getIngredientInfo(metadataJSON));
			JSONObject servings = (JSONObject) recipeJSON.get("servings");
			recipe.setServes((String) servings.get("serves"));
			recipe.setServingSummary((String) servings.get("summary"));
		}
		
		return recipe;
	} 
	
	/** 
	 * If a recipe exists returns a list of ingredients mentioned
	 * @param json JSONObject containing the recipe information
	 * @return List<Ingredient> containing the ingredient list
	 */
	public List<Ingredient> getIngredientInfo(JSONObject json) { 
		
		List<Ingredient> ingredientList = new ArrayList<Ingredient>();
		JSONObject recipe = (JSONObject) json.get("recipe");
		Ingredient single;

		if (recipe != null) { 
			
			JSONArray ingredients = (JSONArray) recipe.get("ingredients"); 
			
			for (int i = 0; i < ingredients.size(); i++) {  
				
				single = new Ingredient();
				JSONObject temp = (JSONObject) ingredients.get(i);
				single.setCategory((String) temp.get("category"));
				JSONArray innerItems = (JSONArray) temp.get("ingredients");
				Map<String,String> ingredientMap = new HashMap<String,String>();  
				
				for (int j = 0; j < innerItems.size(); j++) {  
					
					JSONObject innerTemp = (JSONObject) innerItems.get(j);
					ingredientMap.put((String)innerTemp.get("name"),(String) innerTemp.get("amount"));
				}
				
				single.setIngredients(ingredientMap);
				ingredientList.add(single);
			}
		}
		
		return ingredientList;
	}
}
