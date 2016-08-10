package movies.monolith.controller;

/**
 * Created by tri.bui on 8/9/16.
 */
public class Error {
    public int code;
    public String message;

    public Error(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
