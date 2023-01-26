package hu.fenyvesvolgyimate.tollsystem.parser;

import hu.fenyvesvolgyimate.tollsystem.parser.exception.InvalidJsonException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Locale;

public class JsonParser {
    public String parseStringValueFromJsonStringByKey(String jsonString, String key) {
        String result;
        JSONObject jsonObject = tryParse(jsonString);
        result = getStringValue(jsonObject, key);
        return result;
    }

    public JSONObject getJsonObjectByKey(String jsonString, String key){
        JSONObject jsonObject = tryParse(jsonString);
        try {
            return jsonObject.getJSONObject(key);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONArray getJsonArrayByKey(String jsonString, String key){
        JSONObject jsonObject = tryParse(jsonString);
        try {
            return jsonObject.getJSONArray(key);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private String getStringValue(JSONObject jsonString, String key) {
        String result = null;
        try {
            result = jsonString.getString(key);
        } catch (JSONException e) {
            System.out.println("invalid JsonKey");
        }
        return result;
    }

    private JSONObject tryParse(String jsonString) {
        JSONObject result;
        try {
            result = new JSONObject(jsonString);
        } catch (JSONException e) {
            throw new InvalidJsonException();
        }
        return result;
    }

    public Integer parseIntValueFromJsonStringByKey(String jsonString, String key) {
        JSONObject jsonObject = tryParse(jsonString);
        try {
            return jsonObject.getInt(key);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public Date parseDateByKey(JSONObject jsonObject, String key) {
        String dateStringValue = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
            dateStringValue = jsonObject.getString(key);
            return formatter.parse(dateStringValue);
        } catch (JSONException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String parseString(JSONObject jsonObject, String key) {
        try {
            return jsonObject.getString(key);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
