package yandexAPI;

import java.io.IOException;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author Bumbleboss
 */
public class YandexAPI {
	
	String apikey;
	/**
	 *@param key
	 *	     API key registered on Yandex for your application. 
	 */
	public YandexAPI(String key) {
		this.apikey = key;
	}

	private static OkHttpClient client = new OkHttpClient();
	/**
	 * <p> Retrives translation from Yandex after filling the params
	 * 
	 * @param text
	 * 		  The text to translate
	 * @param lang
	 * 		  The language of the given text
	 * @param langto
	 * 		  The language you want the text to be translated to
	 * 
	 * @return Translated text
	 * 
	 * @throws YandexException
	 */
	public YandexResponse getYandexResponse(String text, YandexLanguage lang, YandexLanguage langto) throws YandexException {
		String json = null;
		try{
			json = getJSONPOST("https://translate.yandex.net/api/v1.5/tr.json/translate?key="+apikey+"&text="+text+"&lang="+lang+"-"+langto);
		}catch(Exception e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();		
		YandexResponse inf = gson.fromJson(json, YandexResponse.class);
		
		if(inf.getCode() != 200){
			String[] exp = getResponseCode(inf.getCode());
			throw new YandexException(exp[0], exp[1]);
		}else{
			return inf;
		}
	}
	
	/**
	 * <p> Retrives translation from Yandex after filling the params
	 * 
	 * @param text
	 * 		  The text to translate
	 * @param langto
	 * 		  The language you want the text to be translated to
	 * 
	 * @return Translated text
	 * 
	 * @throws YandexException
	 */
	public YandexResponse getYandexResponse(String text, YandexLanguage langto) throws YandexException {
		String json = null;
		try{
			json = getJSONPOST("https://translate.yandex.net/api/v1.5/tr.json/translate?key="+apikey+"&text="+text+"&lang="+langto);
		}catch(Exception e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();		
		YandexResponse inf = gson.fromJson(json, YandexResponse.class);
		
		if(inf.getCode() != 200){
			String[] exp = getResponseCode(inf.getCode());
			throw new YandexException(exp[0], exp[1]);
		}else{
			return inf;
		}
	}
	
	private static String getJSONPOST(String url) throws IOException {
		Request request = new Request.Builder()
				.url(url).method("POST", RequestBody.create(null, new byte[0])).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}
	
	private String[] getResponseCode(int code) {
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
