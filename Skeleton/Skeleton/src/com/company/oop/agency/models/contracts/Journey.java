package com.company.oop.agency.models.contracts;

import com.company.oop.agency.models.vehicles.contracts.Vehicle;

public interface Journey extends Vehicle{

    int getDistance();

    Vehicle getVehicle();

    String getStartLocation();

    String getDestination();

    double calculateTravelCosts();

}