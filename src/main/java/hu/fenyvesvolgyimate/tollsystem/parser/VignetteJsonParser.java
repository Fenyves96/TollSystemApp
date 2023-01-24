package hu.fenyvesvolgyimate.tollsystem.parser;

import hu.fenyvesvolgyimate.tollsystem.dto.VignettesRequestDTO;
import hu.fenyvesvolgyimate.tollsystem.entity.Vehicle;

public class VignetteJsonParser {
    JsonParser jsonParser = new JsonParser();
    public VignettesRequestDTO parseRegistrationNumberFromJson(String json){
        VignettesRequestDTO requestDTO = new VignettesRequestDTO();
        requestDTO.registrationNumber = jsonParser.parseStringValueFromJsonStringByKey(json ,"registrationNumber");
        return requestDTO;
    }
}
