<img align="right" src="https://translate.yandex.com/icons/favicon.png" height="100" width="100">

# Yandex Translate API
Java API wrapper for Yandex Translate
POST request to [Yandex Translate API site](https://translate.yandex.com/) with given information.

# How to use
For setting the token
```Java
YandexAPI api = new YandexAPI("your token");
```
Requesting translations
```Java
try {
  	System.out.println(inf.getYandexResponse("Hello there!", YandexLanguage.English, YandexLanguage.French)
	.getText().get(0));
} catch (YandexException e) {
	e.printStackTrace();
}
```

# Notes
* Check the legal terms for the usage of the API before using this. You can find it [here](https://yandex.com/legal/translate_api/).

# Used Libraries
* [gson-2.8.2](https://github.com/google/gson)
* [okhttp-3.9.1](https://github.com/square/okhttp)
* [okio-1.13.0](https://github.com/square/okio/)