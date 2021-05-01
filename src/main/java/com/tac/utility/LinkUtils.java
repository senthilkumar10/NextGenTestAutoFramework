package com.tac.utility;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author senthil
 * To Check the any broken links in the site
 */
public class LinkUtils {

    // hits the given url and returns the HTTP response code
    public static int getResponseCode(String link) {
        URL url;
        HttpURLConnection con = null;
        Integer responsecode = 0;
        try {
            url = new URL(link);
            con = (HttpURLConnection) url.openConnection();
            responsecode = con.getResponseCode();
        } catch (Exception e) {
            // skip
        } finally {
            if (null != con)
                con.disconnect();
        }
        return responsecode;
    }

}
