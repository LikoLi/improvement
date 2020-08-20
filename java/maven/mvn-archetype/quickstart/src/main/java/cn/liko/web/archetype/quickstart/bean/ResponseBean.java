package cn.liko.web.archetype.quickstart.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ResponseBean
 *
 * @author liko
 * @date 2020/6/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBean<T> {

    /**
     * Response Code
     */
    public static final int SUCCESS = 200;
    public static final int NOT_MODIFIED = 304;
    public static final int BAD_REQUEST = 400;
    public static final int UNAUTHORIZED = 401;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    public static final int METHOD_NOT_ALLOWED = 405;
    public static final int REQUEST_TIMEOUT = 408;
    public static final int ERROR = 500;

    /**
     * Return Msg
     */
    public static final String MSG_UNAUTHORIZED = "UNAUTHORIZED";
    public static final String MSG_ERROR = "ERROR";
    public static final String MSG_OK = "OK";

    /**
     * Param
     */
    private int code;
    private String msg;
    private T data;

    /**
     * Success return
     * @param <T>
     * @return
     */
    public static <T> ResponseBean<T> success() {
        return new ResponseBean<>(SUCCESS, MSG_OK, null);
    }

    public static <T> ResponseBean<T> success(T data) {
        return new ResponseBean<>(SUCCESS, MSG_OK, data);
    }

    public static <T> ResponseBean<T> success(String msg, T data) {
        return new ResponseBean<>(SUCCESS, msg, data);
    }

    public static <T> ResponseBean<T> successMsg(String msg) {
        return new ResponseBean<>(SUCCESS, msg, null);
    }

    /**
     * Error return
     * @param <T>
     * @return
     */
    public static <T> ResponseBean<T> error() {
        return new ResponseBean<>(BAD_REQUEST, MSG_ERROR, null);
    }

    public static <T> ResponseBean<T> error(T data) {
        return new ResponseBean<>(BAD_REQUEST, MSG_ERROR, data);
    }

    public static <T> ResponseBean<T> error(String msg, T data) {
        return new ResponseBean<>(BAD_REQUEST, MSG_ERROR, data);
    }

    public static <T> ResponseBean<T> errorMsg(String msg) {
        return new ResponseBean<>(BAD_REQUEST, msg, null);
    }

    /**
     * Unauthorized Msg
     * @param <T>
     * @return
     */
    public static <T> ResponseBean<T> unauthorized() {
        return new ResponseBean<>(UNAUTHORIZED, MSG_UNAUTHORIZED, null);
    }

    public static <T> ResponseBean<T> unauthorized(String msg) {
        return new ResponseBean<>(UNAUTHORIZED, msg, null);
    }

}
