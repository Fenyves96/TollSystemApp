package hu.fenyvesvolgyimate.tollsystem.validaton;

import hu.fenyvesvolgyimate.tollsystem.dto.VignettesRequestDTO;
import hu.fenyvesvolgyimate.tollsystem.exception.InvalidRegistrationNumberException;
import hu.fenyvesvolgyimate.tollsystem.parser.VehicleJsonParser;
import hu.fenyvesvolgyimate.tollsystem.parser.exception.InvalidJsonException;

public class VignetteValidator {
    VehicleJsonParser vehicleParser = new VehicleJsonParser();

    public void validateRegistrationNumberJsonString(String registrationNumberJsonString){
        String registartionNumber = null;
        try{
            VignettesRequestDTO requestDTO = vehicleParser.parseRegistrationNumberFromJson(registrationNumberJsonString);
            registartionNumber = requestDTO.registrationNumber;
        } catch (InvalidJsonException ex){
            throw new InvalidRegistrationNumberException();
        }
        if(registartionNumber == null || registartionNumber.equals(""))
            throw new InvalidRegistrationNumberException();
    }
}
