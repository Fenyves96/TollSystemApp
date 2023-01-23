import dao.VignetteStorage;
import hu.fenyvesvolgyimate.tollsystem.VehicleRegisterClient;
import hu.fenyvesvolgyimate.tollsystem.VignetteListerAPI;
import hu.fenyvesvolgyimate.tollsystem.entity.Vehicle;
import hu.fenyvesvolgyimate.tollsystem.entity.Vignette;
import hu.fenyvesvolgyimate.tollsystem.parser.VehicleJsonParser;
import hu.fenyvesvolgyimate.tollsystem.parser.VignetteResponseParser;
import hu.fenyvesvolgyimate.vehicleregisterapp.interactor.VehicleRegister;
import hu.fenyvesvolgyimate.vehicleregisterapp.presenter.VehiclePresenter;
import hu.fenyvesvolgyimate.tollsystem.validaton.VignetteValidator;

import java.util.List;

public class VignetteLister implements VignetteListerAPI, VehiclePresenter {
    VignetteValidator validator = new VignetteValidator();
    VehicleJsonParser parser = new VehicleJsonParser();
    VignetteResponseParser vignetteResponseParser = new VignetteResponseParser();

    VehicleRegisterClient vehicleRegisterClient;

    VignetteStorage vignetteStorage;

    public VignetteLister(VignetteStorage vignetteStorage, VehicleRegisterClient vehicleRegisterClient){
        this.vignetteStorage = vignetteStorage;
        this.vehicleRegisterClient = vehicleRegisterClient;
    }

    @Override
    public void listVignettesByRegistrationNumber(String registrationNumberJson) {
        validator.validateRegistrationNumberJsonString(registrationNumberJson);
        String registrationNumber = parser.parseRegistrationNumberFromJson(registrationNumberJson);
        Vehicle vehicle = vehicleRegisterClient.getVehicleByRegistrationNumber(registrationNumber);
        List<Vignette> vignettes = vignetteStorage.findVignettesByRegistrationNumber(registrationNumber);

    }

    @Override
    public void displayVehicle(String s) {
    }

    @Override
    public void displayMessage(String s) {
    }
}
