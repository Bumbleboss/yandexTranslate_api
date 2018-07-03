package yandexAPI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Retruns with a response code and it's description. See the following examples:
 * <ul>
 *   <li> <b> 401 </b> Provided API key must be valid 
 *   <li> <b> 402 </b> The provided API key is blocked
 *   <li> <b> 404 </b> Exceeded the daily limit on the amount of translated text
 *   <li> <b> 413 </b> Exceeded the maximum text size
 *   <li> <b> 422 </b> The provided text cannot be translated
 *   <li> <b> 501 </b> The specified translation direction is not supported
 *   <li> <b> 502 </b> A valid input language must be provided
 * </ul>
 */
public class YandexException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public YandexException(String error, String error_description) { 	
		super("\n["+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) +"] [Yandex] [Error]: "+ error +" [Error Description]: " + error_description);
	}
}
