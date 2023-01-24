package hu.fenyvesvolgyimate.tollsystem.client;

import hu.fenyvesvolgyimate.tollsystem.entity.Vehicle;

public interface VehicleRegisterClient {
    Vehicle getVehicleByRegistrationNumber(String registrationNumber);
}
