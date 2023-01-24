package hu.fenyvesvolgyimate.tollsystem.parser;

import hu.fenyvesvolgyimate.tollsystem.entity.Vehicle;
import hu.fenyvesvolgyimate.tollsystem.entity.Vignette;
import hu.fenyvesvolgyimate.tollsystem.exception.InvalidVehicleResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class VignetteResponseParser {
    public String parseVehicleAndVignettesIntoJson(Vehicle vehicle, List<Vignette> vignettes){
        JSONObject jsonObject = new JSONObject();
        JSONArray vignettesJSONArray = new JSONArray();
        try {
            vignettes.forEach(v -> vignettesJSONArray.put(generateJsonObjectFromVignette(v)));
            jsonObject.put("vignettes", vignettesJSONArray);
            jsonObject.put("vehicle", generateJSonObjectFromVehicle(vehicle));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return jsonObject.toString();
    }

    private JSONObject generateJSonObjectFromVehicle(Vehicle vehicle) {
        JSONObject vehicleJson = new JSONObject();
        try {
            vehicleJson.put("category", vehicle.getVehicleCategory());
            vehicleJson.put("make", vehicle.getMake());
            vehicleJson.put("registrationNumber", vehicle.getRegistrationNumber());
            vehicleJson.put("maxTransportablePassengers", vehicle.getMaxTransportablePassengers());
        } catch (JSONException jsonException) {
            throw new InvalidVehicleResponse();
        }
        return vehicleJson;
    }


    JSONObject generateJsonObjectFromVignette(Vignette vignette) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("vehicleCategory", vignette.getVehicleCategory());
            jsonObject.put("validFrom", vignette.getValidFrom());
            jsonObject.put("validTo", vignette.getValidTo());
            jsonObject.put("vehicleCategory", vignette.getVehicleCategory());
            jsonObject.put("dateOfPurchase", vignette.getDateOfPurchase());
        } catch (JSONException exception) {
            throw new RuntimeException();
        }
        return jsonObject;
    }
}
