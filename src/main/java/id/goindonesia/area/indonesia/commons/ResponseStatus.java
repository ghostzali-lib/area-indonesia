package id.goindonesia.area.indonesia.commons;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by ghostzali on 22/04/17.
 */
public enum ResponseStatus {
    OK(200),
    CREATED(201),
    UPDATED(202),
    DELETED(203),
    FOUND(204),
    EXIST(400),
    NOT_CREATED(401),
    NOT_UPDATED(402),
    NOT_DELETED(403),
    NOT_FOUND(404),
    NULL(500),
    ERROR(505),
    EMPTY(510);

    private int instance;

    ResponseStatus(int status) {
        this.instance = status;
    }

    public static Stream<ResponseStatus> stream() {
        return Arrays.stream(ResponseStatus.values());
    }

    public int get() {
        return instance;
    }

    public void set(int status) {
        stream().forEach(s -> {
            this.instance = (s.get() == status) ? status : this.instance;
        });
    }

    @Override
    public String toString() {
        return "" + instance;
    }
}
