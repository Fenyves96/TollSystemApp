package hu.fenyvesvolgyimate.tollsystem;

import hu.fenyvesvolgyimate.tollsystem.entity.Vehicle;
import hu.fenyvesvolgyimate.tollsystem.parser.VehicleJsonParser;
import hu.fenyvesvolgyimate.tollsystem.validaton.VehicleValidator;
import hu.fenyvesvolgyimate.vehicleregisterapp.interactor.VehicleRegister;
import hu.fenyvesvolgyimate.vehicleregisterapp.presenter.VehiclePresenter;

public class VehicleRegisterClient implements VehiclePresenter {
    VehicleRegister vehicleRegister;
    VehicleValidator vehicleValidator = new VehicleValidator();
    VehicleJsonParser vehicleJsonParser = new VehicleJsonParser();

    Vehicle vehicleResult;

    public VehicleRegisterClient(VehicleRegister vehicleRegister){
        this.vehicleRegister = vehicleRegister;
    }

    public Vehicle getVehicleByRegistrationNumber(String registrationNumber){
        vehicleRegister.getVehicleByRegisterNumber(registrationNumber);
        return vehicleResult;
    }

    @Override
    public void displayVehicle(String vehicleJson) {
        vehicleValidator.validateVehicleJsonResponse(vehicleJson);
        vehicleResult = vehicleJsonParser.parseJsonToVehicle(vehicleJson);
    }

    @Override
    public void displayMessage(String s) {
        throw new IllegalStateException();
    }
}
