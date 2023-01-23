package hu.fenyvesvolgyimate.tollsystem.entity;

public class Vehicle {
    String registrationNumber;
    String vehicleCategory;
    String make;
    int maxTransportablePassengers;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getMaxTransportablePassengers() {
        return maxTransportablePassengers;
    }

    public void setMaxTransportablePassengers(int maxTransportablePassengers) {
        this.maxTransportablePassengers = maxTransportablePassengers;
    }
}
