package example;

import yandexAPI.YandexAPI;
import yandexAPI.YandexException;
import yandexAPI.YandexLanguage;
/**
 * @author Bumbleboss
 */
public class YandexExample {

	public static void main (String[] args) {
		
		YandexAPI api = new YandexAPI("your token");		
		try {
			System.out.println(api.getYandexResponse("Hello there!", YandexLanguage.French)
					.getText().get(0));
		} catch (YandexException e) {
			e.printStackTrace();
		}
	}	
}
