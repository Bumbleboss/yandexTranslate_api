package example;

import yandexAPI.YandexAPI;
import yandexAPI.YandexException;
import yandexAPI.YandexLanguage;
/**
 * @author Bumbleboss
 */
public class Example {

	public static void main (String[] args) {
		
		YandexAPI api = new YandexAPI("your token");		
		try {
			System.out.println(api.getYandexResponse("Hello there!", YandexLanguage.English, YandexLanguage.French)
					.getText().get(0));
		} catch (YandexException e) {
			e.printStackTrace();
		}
	}	
}
