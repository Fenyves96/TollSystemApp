package hu.fenyvesvolgyimate.tollsystem.validaton;

import hu.fenyvesvolgyimate.tollsystem.dto.VignettesRequestDTO;
import hu.fenyvesvolgyimate.tollsystem.exception.InvalidRegistrationNumberException;
import hu.fenyvesvolgyimate.tollsystem.parser.VignetteJsonParser;
import hu.fenyvesvolgyimate.tollsystem.parser.exception.InvalidJsonException;

public class VignetteValidator {
    VignetteJsonParser parser = new VignetteJsonParser();

    public void validateRegistrationNumberJsonString(String registrationNumberJsonString){
        String registartionNumber = null;
        try{
            VignettesRequestDTO requestDTO = parser.parseRegistrationNumberFromJson(registrationNumberJsonString);
            registartionNumber = requestDTO.registrationNumber;
        } catch (InvalidJsonException ex){
            throw new InvalidRegistrationNumberException();
        }
        if(registartionNumber == null || registartionNumber.equals(""))
            throw new InvalidRegistrationNumberException();
    }
}
