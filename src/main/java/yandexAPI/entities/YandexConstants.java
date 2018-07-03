package yandexAPI.entities;

import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
/**
 * @author Bumbleboss
 */

public class YandexConstants {
	
	private String URL = "translate.yandex.net";
	
	private String API_VERSION = "api/v1.5/";
	
	private String JSON = "tr.json/";
	
	public String TRANSLATE = "translate";
	
	public String DETECT = "detect";
		
	/**
	 * @param path
	 * 		  Call end whether its translation or detecting language
	 * 
	 * @param key
	 * 		  API key registered on Yandex for your application
	 * 
	 * @param text
	 * 		  Input text for translation or detecting language
	 * 
	 * @param lang
	 *        Input language (Can be null)
	 *        
	 * @return A formatted URL with added with the given parameters
	 */
	public String getURL(String path, String key, String text, String lang) {
		Builder uri = new HttpUrl.Builder();
		
		uri.scheme("https").host(URL).addPathSegments(API_VERSION+JSON+path);
		uri.addQueryParameter("key", key);
		uri.addQueryParameter("text", text);
		
		if(lang != null) {
			uri.addQueryParameter("lang", lang);
		}
		return uri.build().url().toString();
	}
	
	/**
	 * @param code
	 * @return Response codes of every call end
	 */
	public String[] getResponseCode(int code) {
		switch (code) {
			case 401: return new String[] {"Invalid API key", "Please provide a valid API key"};
			case 402: return new String[] {"Blocked API key", "Your API key is blocked"};
			case 404: return new String[] {"Limit Exceeded", "Exceeded the daily limit on the amount of translated text"};
			case 413: return new String[] {"Limit Exceeded", "Exceeded the maximum text size"};
			case 422: return new String[] {"Translate error", "The text cannot be translated"};
			case 501: return new String[] {"Invalid language", "The text cannot be translated"};
			case 502: return new String[] {"Invalid parameter", "Please put a valid input language"};
		}
		return null;
	}
}
