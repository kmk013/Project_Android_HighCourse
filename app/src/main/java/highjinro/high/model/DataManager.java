package highjinro.high.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.util.Pair;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import highjinro.high.search.Reg;

/**
 * Created by KOHA on 7/9/16.
 */

public class DataManager {
    /* Login Type
    * 0 Facebook
    * 1: Twitter
    * 2 Kakao
    * 3 Naver
    * 4 Native Login
    * */

    /* Data Keys */
    public static final String DATABASE_VERSION = "database_version";
    public static final String USER_PROFILE_URL = "user_profile_url";
    public static final String HAS_ACTIVE_USER = "has_active_user";
    public static final String USER_TOKEN = "user_token";
    public static final String USER_TOKEN_SECRET = "user_token_secret";
    public static final String HANGEULRO_SERVER_TOKEN = "server_token";
    public static final String USER_NAME = "user_name";
    public static final String USER_ID = "user_id";
    public static final String LOGIN_TYPE = "login_type";
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public DataManager(Context c) {
        this.context = c;
        preferences = context.getSharedPreferences("Hangeulro", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void save(String key, String data) {
        editor.putString(key, data);
        editor.apply();
    }

    public void saveUserCredential(String facebookToken) {
        editor.putString(USER_TOKEN, facebookToken);
        editor.apply();
    }

    public void saveUserCredential(String[] twitterToken) {
        editor.putString(USER_TOKEN, twitterToken[0]);
        editor.putString(USER_TOKEN_SECRET, twitterToken[1]);
        editor.apply();
    }



    public void saveNativeLoginUserInfo(JSONObject user) {
        editor.putInt(LOGIN_TYPE, 4);
        try {
            editor.putBoolean(HAS_ACTIVE_USER, true);
            editor.putString(USER_NAME, user.getString("name"));
            editor.putString(HANGEULRO_SERVER_TOKEN, user.getString("token"));
            editor.putString(USER_ID, user.getString("userid"));
            editor.apply();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public Pair<Boolean, Reg> getActiveUser() {
        if (preferences.getBoolean(HAS_ACTIVE_USER, false)) {
            int userType = preferences.getInt(LOGIN_TYPE, -1);
            String id = preferences.getString(USER_ID, "");
            String name = preferences.getString(USER_NAME, "");
            String url = preferences.getString(USER_PROFILE_URL, "");
            String token = preferences.getString(HANGEULRO_SERVER_TOKEN, "");
            Log.e("asdf", "name : " + name + "url : " + url);
            Reg user = new Reg(id, token);
            return Pair.create(true, user);
        } else return Pair.create(false, null);
    }

    public String getFacebookUserCredential() {
        if (preferences.getBoolean(HAS_ACTIVE_USER, false) && preferences.getInt(LOGIN_TYPE, -1) == 0) {
            return preferences.getString(USER_TOKEN, "");
        } else return "";
    }

    public String[] getTwitterUserCredentials() {
        if (preferences.getBoolean(HAS_ACTIVE_USER, false) && preferences.getInt(LOGIN_TYPE, -1) == 1)
            return new String[]{preferences.getString(USER_TOKEN, ""),
                    preferences.getString(USER_TOKEN_SECRET, ""),
                    preferences.getString(USER_ID, "")
            };
        else return new String[]{""};
    }

    public int getCurrentDatabaseVersion() {
        return preferences.getInt(DATABASE_VERSION, -1);
    }
    public void saveCurrentDatabaseVersion(int version){
        editor.putInt(DATABASE_VERSION, version);
        editor.apply();
    }

    public void removeAllData() {
        editor.clear();
        editor.apply();
    }

    public String getString(String key) {
        return preferences.getString(key, "");
    }

    public int getInt(String key) {
        return preferences.getInt(key, 0);
    }

    public boolean getBoolean(String key) {
        return preferences.getBoolean(key, false);
    }

    public boolean isFirst() {
        return preferences.getBoolean("IS_FIRST", true);
    }

    public void notFirst() {
        editor.putBoolean("IS_FIRST", false);
        editor.apply();
    }

    public long getLong(String key) {
        return preferences.getLong(key, 0);
    }

}