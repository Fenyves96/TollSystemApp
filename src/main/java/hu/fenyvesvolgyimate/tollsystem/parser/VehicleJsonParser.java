package hu.fenyvesvolgyimate.tollsystem.parser;

import hu.fenyvesvolgyimate.tollsystem.entity.Vehicle;

public class VehicleJsonParser {
    private JsonParser jsonParser = new JsonParser();

    public String parseRegistrationNumberFromJson(String json){
        return jsonParser.parseStringValueFromJsonStringByKey(json ,"registrationNumber");
    }

    public Vehicle parseJsonToVehicle(String vehicleJson) {
        Vehicle vehicle = new Vehicle();
        String registrationNumber = jsonParser.parseStringValueFromJsonStringByKey(vehicleJson, "registrationNumber");
        String make = jsonParser.parseStringValueFromJsonStringByKey(vehicleJson, "make");
        String vehicleCategory = jsonParser.parseStringValueFromJsonStringByKey(vehicleJson, "type");
        int maxTransportablePassengers  = jsonParser.parseIntValueFromJsonStringByKey(vehicleJson, "numberOfSeats");

        vehicle.setRegistrationNumber(registrationNumber);
        vehicle.setMake(make);
        vehicle.setCategory(vehicleCategory);
        vehicle.setMaxTransportablePassengers(maxTransportablePassengers);
        return vehicle;
    }
}
