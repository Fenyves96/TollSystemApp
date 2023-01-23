package hu.fenyvesvolgyimate.tollsystem.dao;

import hu.fenyvesvolgyimate.tollsystem.entity.Vignette;

import java.util.List;

public interface VignetteStorage {
    List<Vignette> findVignettesByRegistrationNumber(String registrationNumber);
}
