package id.goindonesia.area.indonesia.commons;

/**
 * Created by ghostzali on 26/04/17.
 */
public class GeneralErrorResponse extends ResponseData {
    public GeneralErrorResponse(ResponseStatus status) {
        super(status);
    }

    public GeneralErrorResponse(ResponseStatus status, String message) {
        super(status, message);
    }

    public GeneralErrorResponse(ResponseStatus status, Object content) {
        super(status, content);
    }

    public GeneralErrorResponse(ResponseStatus status, String message, Object content) {
        super(status, message, content);
    }

    public static ResponseData errorWithoutMessage() {
        return new GeneralErrorResponse(ResponseStatus.ERROR);
    }

    public static ResponseData errorWithMessage(Exception e) {
        return new GeneralErrorResponse(ResponseStatus.ERROR, e.getLocalizedMessage());
    }

    public static ResponseData error(Exception e) {
        return new GeneralErrorResponse(ResponseStatus.ERROR, e.getLocalizedMessage(), e);
    }
}
