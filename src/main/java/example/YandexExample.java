package example;

import yandexAPI.YandexAPI;
import yandexAPI.YandexLanguage;
/**
 * @author Bumbleboss
 */
public class YandexExample {

	public static void main (String[] args) {
		YandexAPI api = new YandexAPI("your-token");
			
		//TRANSLATE THE TEXT FROM LANGUAGE TO ANOTHER
		System.out.println(api.getYandexResponse("Hello there!", YandexLanguage.French)
				.getText().get(0));
			
		//TRANSLATE THE TEXT FROM LANGUAGE TO ANOTHER WITH GIVING THE TEXT ORIGIN LANGUAGE
		System.out.println(api.getYandexResponse("Hello there!", YandexLanguage.English, YandexLanguage.French)
				.getText().get(0));
			
		//GET LANGUAGE OF THE TEXT
		System.out.println(api.getTextLanguage("Hello there!").getLang());

	}	
}
