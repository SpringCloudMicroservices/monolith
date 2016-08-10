package movies.monolith;

import io.jsonwebtoken.Claims;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tri.bui on 8/10/16.
 */
public class RequestUtils {
    public final static String CLAIMS = "claims";

    public static String getUserId(HttpServletRequest request) {
        final Claims claims = (Claims)request.getAttribute(CLAIMS);
        if (claims == null) return null;
        return claims.getSubject();
    }

    public static void attachJwtClaims(HttpServletRequest request, Claims claims) {
        request.setAttribute(RequestUtils.CLAIMS, claims);
    }
}
