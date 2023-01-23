package hu.fenyvesvolgyimate.tollsystem.parser;

import hu.fenyvesvolgyimate.tollsystem.entity.Vehicle;
import hu.fenyvesvolgyimate.tollsystem.entity.Vignette;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class VignetteResponseParser {
    public String parseVehicleAndVignettesIntoJson(Vehicle vehicle, List<Vignette> vignettes){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("vignettes", vignettes);
            jsonObject.put("vehicle", vehicle);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return jsonObject.toString();
    }

    String generateStringFromVignette(Vignette vignette){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("validFrom", vignette.getValidFrom());
            jsonObject.put("validTo", vignette.getValidTo());
            jsonObject.put("vehicleCategory", vignette.getVehicleCategory());
            jsonObject.put("dateOfPurchase", vignette.getDateOfPurchase());
        }catch (JSONException exception){
            throw new RuntimeException();
        }
        return jsonObject.toString();
    }
}
