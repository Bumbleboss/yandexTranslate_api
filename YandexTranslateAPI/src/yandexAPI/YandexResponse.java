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
	
	public String getCode() {
		return code;
	}
	public String getLang() {
		return lang;
	}
	public List<String> getText() {
		return text;
	}
}