package hu.fenyvesvolgyimate.tollsystem.client;

import hu.fenyvesvolgyimate.tollsystem.entity.Vehicle;

public interface VehicleRegisterClient {
    public Vehicle getVehicleByRegistrationNumber(String registrationNumber);
}
