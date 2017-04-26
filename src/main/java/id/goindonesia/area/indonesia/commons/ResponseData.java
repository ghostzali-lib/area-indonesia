package id.goindonesia.area.indonesia.commons;

/**
 * Created by ghostzali on 22/04/17.
 */
public class ResponseData {

    private ResponseStatus status;
    private String message;
    private Object content;

    public ResponseData(ResponseStatus status) {
        this.status = status;
    }

    public ResponseData(ResponseStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseData(ResponseStatus status, Object content) {
        this.status = status;
        this.content = content;
    }

    public ResponseData(ResponseStatus status, String message, Object content) {
        this.status = status;
        this.message = message;
        this.content = content;
    }

    public static ResponseData success() {
        return new ResponseData(ResponseStatus.OK);
    }

    public static ResponseData success(String message) {
        return new ResponseData(ResponseStatus.OK, message);
    }

    public static ResponseData success(Object content) {
        return new ResponseData(ResponseStatus.OK, content);
    }

    public static ResponseData success(String message, Object content) {
        return new ResponseData(ResponseStatus.OK, message, content);
    }

    public static ResponseData error() {
        return new ResponseData(ResponseStatus.ERROR);
    }

    public static ResponseData error(String message) {
        return new ResponseData(ResponseStatus.ERROR, message);
    }

    public static ResponseData error(Object content) {
        return new ResponseData(ResponseStatus.ERROR, content);
    }

    public static ResponseData error(String message, Object content) {
        return new ResponseData(ResponseStatus.ERROR, message, content);
    }

    public static ResponseData custom(ResponseStatus status) {
        return new ResponseData(status);
    }

    public static ResponseData custom(ResponseStatus status, String message) {
        return new ResponseData(status, message);
    }

    public static ResponseData custom(ResponseStatus status, Object content) {
        return new ResponseData(status, content);
    }

    public static ResponseData custom(ResponseStatus status, String message, Object content) {
        return new ResponseData(status, message, content);
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getContent() {
        return content;
    }
}
