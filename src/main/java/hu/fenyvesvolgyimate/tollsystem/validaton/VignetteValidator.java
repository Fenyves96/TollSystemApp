package hu.fenyvesvolgyimate.tollsystem.validaton;

import hu.fenyvesvolgyimate.tollsystem.exception.InvalidRegistrationNumberException;
import hu.fenyvesvolgyimate.tollsystem.parser.VehicleJsonParser;
import hu.fenyvesvolgyimate.tollsystem.parser.exception.InvalidJsonException;
import org.json.JSONException;

public class VignetteValidator {
    VehicleJsonParser vehicleParser = new VehicleJsonParser();

    public void validateRegistrationNumberJsonString(String registrationNumberJsonString){
        String registartionNumber = null;
        try{
            registartionNumber = vehicleParser.parseRegistrationNumberFromJson(registrationNumberJsonString);
        } catch (InvalidJsonException ex){
            throw new InvalidRegistrationNumberException();
        }
        if(registartionNumber == null || registartionNumber.equals(""))
            throw new InvalidRegistrationNumberException();
    }
}
