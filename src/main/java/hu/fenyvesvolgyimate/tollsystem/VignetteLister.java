package hu.fenyvesvolgyimate.tollsystem;
import hu.fenyvesvolgyimate.tollsystem.client.VehicleRegisterClient;
import hu.fenyvesvolgyimate.tollsystem.dao.VignetteStorage;
import hu.fenyvesvolgyimate.tollsystem.dto.VignettesRequestDTO;
import hu.fenyvesvolgyimate.tollsystem.entity.Vehicle;
import hu.fenyvesvolgyimate.tollsystem.entity.Vignette;
import hu.fenyvesvolgyimate.tollsystem.parser.VignetteJsonParser;
import hu.fenyvesvolgyimate.tollsystem.parser.VignetteResponseParser;
import hu.fenyvesvolgyimate.tollsystem.presenter.VignettePresenter;
import hu.fenyvesvolgyimate.tollsystem.validaton.VignetteValidator;

import java.util.List;

public class VignetteLister implements VignetteListerAPI {
    VignetteValidator validator = new VignetteValidator();
    VignetteJsonParser parser = new VignetteJsonParser();
    VehicleRegisterClient vehicleRegisterClient;
    VignetteStorage vignetteStorage;
    VignetteResponseParser responseParser = new VignetteResponseParser();
    VignettePresenter presenter;

    public VignetteLister(VignetteStorage vignetteStorage, VehicleRegisterClient vehicleRegisterClient, VignettePresenter presenter) {
        this.vignetteStorage = vignetteStorage;
        this.vehicleRegisterClient = vehicleRegisterClient;
        this.presenter = presenter;
    }

    @Override
    public void listVignettesByRegistrationNumber(String registrationNumberJson) {
        validator.validateRegistrationNumberJsonString(registrationNumberJson);
        VignettesRequestDTO requestDTO = parser.parseRegistrationNumberFromJson(registrationNumberJson);
        Vehicle vehicle = vehicleRegisterClient.getVehicleByRegistrationNumber(requestDTO.registrationNumber);
        List<Vignette> vignettes = vignetteStorage.findVignettesByRegistrationNumber(requestDTO.registrationNumber);
        String jsonResponse = responseParser.parseVehicleAndVignettesIntoJson(vehicle, vignettes);
        presenter.displayVehicleVignettes(jsonResponse);
    }
}
