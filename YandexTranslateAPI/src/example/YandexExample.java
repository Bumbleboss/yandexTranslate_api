package example;

import yandexAPI.YandexAPI;
import yandexAPI.YandexException;
import yandexAPI.YandexLanguage;
/**
 * @author Bumbleboss
 */
public class YandexExample {

	public static void main (String[] args) {
		
		YandexAPI api = new YandexAPI("trnsl.1.1.20170914T045446Z.7af5b16bee437b84.8b04c10bc54392d10bbc12d9e3ba83b329fe6124");		
		try {
			System.out.println(api.getYandexResponse("Hello there!", YandexLanguage.French)
					.getText().get(0));
		} catch (YandexException e) {
			e.printStackTrace();
		}
	}	
}
