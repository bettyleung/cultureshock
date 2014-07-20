import java.util.Map;
import java.util.HashMap;
import javax.naming.AuthenticationException;

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
    public Map<String, Object> getCategories() {
        Map<String, Object> json = new HashMap<String, Object>();

        // TODO:
        //   download http://mm-server.tk:3448/categories programatically
        //   process the JSON using gson 
        //   create and return a specialized object instead of a Map, if possible

        return json;
    }
}