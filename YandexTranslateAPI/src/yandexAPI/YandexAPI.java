package yandexAPI;

import java.io.IOException;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import yandexAPI.entities.YandexConstants;
import yandexAPI.entities.YandexLanguage;
import yandexAPI.entities.YandexResponse;

/**
 * @author Bumbleboss
 */
public class YandexAPI {
	
	String apiKey;
	/**
	 *@param key
	 *	     API key registered on Yandex for your application
	 */
	public YandexAPI(String key) {
		this.apiKey = key;
	}

	private OkHttpClient client = new OkHttpClient();
	private YandexConstants con = new YandexConstants();
	private Gson gson = new Gson(); 
	
	/**
	 * <p> Retrives the text language from Yandex after filling the params
	 * 
	 * @param text
	 * 		  The text for detecting it's language
	 * 
	 * @return Text's language
	 * 
	 * @throws YandexException
	 */
	public YandexResponse getTextLanguage(String text) throws YandexException {
		String json = null;
		try {
			json = getJSONPOST(con.getURL(con.DETECT, apiKey, text, null));
		}catch(Exception e) {
			e.printStackTrace();
		}
		YandexResponse inf = gson.fromJson(json, YandexResponse.class);
		
		if(inf.getCode() != 200){
			String[] exp = con.getResponseCode(inf.getCode());
			throw new YandexException(exp[0], exp[1]);
		}
		return inf;
	}
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
			json = getJSONPOST(con.getURL(con.TRANSLATE, apiKey, text, lang+"-"+langto));
		}catch(Exception e) {
			e.printStackTrace();
		}
		YandexResponse inf = gson.fromJson(json, YandexResponse.class);
		
		if(inf.getCode() != 200){
			String[] exp = con.getResponseCode(inf.getCode());
			throw new YandexException(exp[0], exp[1]);
		}
		return inf;
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
			json = getJSONPOST(con.getURL(con.TRANSLATE, apiKey, text, langto.toString()));
		}catch(Exception e) {
			e.printStackTrace();
		}
		YandexResponse inf = gson.fromJson(json, YandexResponse.class);
		
		if(inf.getCode() != 200){
			String[] exp = con.getResponseCode(inf.getCode());
			throw new YandexException(exp[0], exp[1]);
		}
		return inf;
	}
	
	private String getJSONPOST(String url) throws IOException {
		Request request = new Request.Builder()
				.url(url).method("POST", RequestBody.create(null, new byte[0])).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}
}
