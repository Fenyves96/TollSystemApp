package hu.fenyvesvolgyimate.tollsystem.parser;

import hu.fenyvesvolgyimate.tollsystem.entity.Vehicle;
import hu.fenyvesvolgyimate.tollsystem.entity.Vignette;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

class VignetteResponseParserTest {
    VignetteResponseParser parser = new VignetteResponseParser();

    @Test
    public void testParse() {
        Vehicle vehicle = new Vehicle();
        vehicle.setMake("make");
        vehicle.setMaxTransportablePassengers(5);
        vehicle.setRegistrationNumber("abc-123");
        vehicle.setVehicleCategory("vehicleCategory");

        Vignette vignette = new Vignette();
        vignette.setType("type");
        vignette.setValidTo(new Date());
        vignette.setValidFrom(new Date());
        vignette.setRegistrationNumber("abc-123");
        vignette.setDateOfPurchase(new Date());
        vignette.setVehicleCategory("vehicleCategory");
        vignette.setPrice(123);

        try {
            parser.parseVehicleAndVignettesIntoJson(vehicle, List.of(vignette));
        } catch (Exception ex) {
            fail("Invalid json");
        }
    }
}