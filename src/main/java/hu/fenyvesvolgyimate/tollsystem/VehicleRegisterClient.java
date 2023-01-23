package hu.fenyvesvolgyimate.tollsystem;

import hu.fenyvesvolgyimate.tollsystem.entity.Vehicle;
import hu.fenyvesvolgyimate.tollsystem.parser.VehicleJsonParser;
import hu.fenyvesvolgyimate.tollsystem.validaton.VehicleValidator;
import hu.fenyvesvolgyimate.vehicleregisterapp.interactor.VehicleReader;
import hu.fenyvesvolgyimate.vehicleregisterapp.interactor.VehicleRegister;
import hu.fenyvesvolgyimate.vehicleregisterapp.presenter.VehiclePresenter;

public class VehicleRegisterClient implements VehiclePresenter {
    VehicleReader vehicleReader;
    VehicleValidator vehicleValidator = new VehicleValidator();
    VehicleJsonParser vehicleJsonParser = new VehicleJsonParser();

    Vehicle vehicleResult;

    public VehicleRegisterClient(VehicleRegister vehicleReader) {
        this.vehicleReader = vehicleReader;
    }

    public Vehicle getVehicleByRegistrationNumber(String registrationNumber) {
        vehicleReader.getVehicleByRegisterNumber(registrationNumber);
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
