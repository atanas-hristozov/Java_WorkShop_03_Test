package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.contracts.Printable;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;

abstract class VehicleImpl implements Vehicle, Printable {

    protected int passengerCapacity;
    protected double pricePerKilometer;
    private VehicleType vehicleType;
    protected int id;

    public VehicleImpl(int id, int passengerCapacity, double pricePerKilometer, VehicleType vehicleType) {
        this.passengerCapacity = passengerCapacity;
        this.pricePerKilometer = pricePerKilometer;
        this.vehicleType = vehicleType;
        this.id = id;
    }

    abstract void setPassengerCapacity(int passengerCapacity);


    abstract void setPricePerKilometer(double pricePerKilometer);

    private void setType(VehicleType type){

    }


    @Override
    public VehicleType getType() {
        return vehicleType;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public double getPricePerKilometer() {
        return pricePerKilometer;
    }

    @Override
    public String getAsString() {
        return String.format("Passenger capacity: %d\n" +
                "Price per kilometer: %.2f\n" +
                "Vehicle type: %s\n", getPassengerCapacity(), getPricePerKilometer(), getType());
    }
}
