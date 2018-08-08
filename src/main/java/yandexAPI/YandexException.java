package yandexAPI;

public class YandexException extends Exception{

    private static final long serialVersionUID = 1L;
    public YandexException(String error, String error_description) {
        super(error + "; " + error_description);
    }
}
