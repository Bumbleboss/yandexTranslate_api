package yandexAPI;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YandexResponse {

	@SerializedName("code")
	@Expose
	private String code;
	@SerializedName("lang")
	@Expose
	private String lang;
	@SerializedName("text")
	@Expose
	private List<String> text;
	
	/**
	 * @return Response code
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * @return Language of the text
	 */
	public String getLang() {
		return lang;
	}
	
	/**
	 * @return Translated text in a {@link java.util.List List}
	 */
	public List<String> getText() {
		return text;
	}
}