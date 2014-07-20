package com.angelhacks.cultureshock;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.apache.http.auth.AuthenticationException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


class UserSession {
    private final String _username;
    private final String _password;
    private final String _authToken;

    UserSession(String username, String password) {
        _username = username;
        _password = password;
        _authToken = null;
    }

    UserSession(String authToken) {
        _authToken = authToken;

        // TODO: fill in username later
        _username = null;
        _password = null;
    }

    public String getUsername() {
        return _username;
    }

    public UserSession authenticate() throws AuthenticationException {
        // TODO: do stuff here
        if (_username == null) {
            throw new AuthenticationException("no username");
        }

        return this;
    }

    /**
    * @return {"category": ["subcategoryA", "subcategoryB", ...]} where
    *   the list may be null if there are no subcategories
    */
    public Map<String, Object> getCategories(String country) throws IOException {
        URL url;
        InputStream is = null;
        BufferedReader br = null;

        try {
            url = new URL("http://mm-server.tk:3448/" + country + "/categories");
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(br, HashMap.class);
    }

    /**
     * @return {"tips": [{"tip": "the actual tip", "likes": 0, "dislikes": 0, "tags": ["tagA", "tagB"]}]}
     */
    public Map<String, Object> getTips(String country, String category, String subcategory, List<String> tags) throws IOException {
        InputStream is = null;
        BufferedReader br = null;

        try {
            // TODO: I know there's a better way to do this, but it's crunch time
            String urlString = "http://mm-server.tk:3448/" + country + "/tips?";
            if (category != null) {
                urlString += category + "&";
            }
            if (subcategory != null) {
                urlString += subcategory + "&";
            }
            if (tags != null) {
                String tagsString = "";
                for (String tag : tags) {
                    tagsString += tag;
                }
                tagsString = tagsString.substring(0, tagsString.length() - 1);
                urlString += tagsString;
            }


            URL url = new URL(urlString);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(br, HashMap.class);
    }
}
