package yandexAPI.entities;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YandexResponse {

	@SerializedName("code")
	@Expose
	private Integer code;
	@SerializedName("lang")
	@Expose
	private String lang;
	@SerializedName("text")
	@Expose
	private List<String> text;
	
	/**
	 * @return Response code
	 */
	public Integer getCode() {
		return code;
	}
	
	/**
	 * @return Language direction of provided text
	 */
	public String getLang() {
		return lang;
	}
	
	/**
	 * <br> Can be null on some calls
	 * @return Translated text in a {@link java.util.List List}
	 */
	public List<String> getText() {
		return text;
	}
}