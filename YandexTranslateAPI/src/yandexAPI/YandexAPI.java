package yandexAPI;

import java.io.IOException;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class YandexAPI {
	
	String apikey;
	
	public YandexAPI(String key) {
		this.apikey = key;
	}

	private static OkHttpClient client = new OkHttpClient();
	
	public YandexResponse getYandexResponse(String sentence, YandexLanguage lang, YandexLanguage langto) throws YandexException{
		String json = null;
		try{
			json = getJSONPOST("https://translate.yandex.net/api/v1.5/tr.json/translate?key="+apikey+"&text="+sentence+"&lang="+lang+"-"+langto);
		}catch(Exception e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();		
		YandexResponse inf = gson.fromJson(json, YandexResponse.class);
		
		if(inf.getCode().equals("401")){
			throw new YandexException("Invalid API key.", "Please provide a valid API key.");
		}else if(inf.getCode().equals("402")) {
			throw new YandexException("Blocked API key", "Your API key is blocked.");
		}else if(inf.getCode().equals("404")) {
			throw new YandexException("Limit Exceeded","Exceeded the daily limit on the amount of translated text.");
		}else if(inf.getCode().equals("413")) {
			throw new YandexException("Limit Exceeded","Exceeded the maximum text size.");
		}else if(inf.getCode().equals("422")) {
			throw new YandexException("Translate error","The text cannot be translated.");
		}else if(inf.getCode().equals("501")) {
			throw new YandexException("Invalid language","The specified translation direction is not supported.");
		}else if(inf.getCode().equals("502")) {
			throw new YandexException("Invalid parameter", "Please put a valid input language");
		}else{
			return inf;
		}
	}
	
	private static String getJSONPOST(String url) throws IOException {
		Request request = new Request.Builder()
				.url(url)
				.method("POST", RequestBody.create(null, new byte[0])).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}
}
