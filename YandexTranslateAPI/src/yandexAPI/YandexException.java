package yandexAPI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class YandexException extends Exception{
	
	public YandexException(String error, String error_description) { 	
		super("\n["+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) +"] [Yandex] [Error]: "+ error +" [Error Description]: " + error_description);
	}
}
