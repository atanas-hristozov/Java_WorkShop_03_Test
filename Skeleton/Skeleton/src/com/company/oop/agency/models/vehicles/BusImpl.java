package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.vehicles.contracts.Bus;

public class BusImpl extends VehicleImpl implements Bus {

    public static final int PASSENGER_MIN_VALUE = 10;
    public static final int PASSENGER_MAX_VALUE = 50;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;
    public static final String BUS_CAPACITY_ERROR =
            "A bus cannot have less than %d passengers or more than %d passengers.";
    public static final String BUS_PRICE_PER_KILOMETER_ERROR =
            "A vehicle with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!";
    private VehicleType vehicleType = VehicleType.LAND;
    protected int id;

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(id, passengerCapacity, pricePerKilometer, VehicleType.LAND);
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
    }

    @Override
    void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(String.format(BUS_CAPACITY_ERROR, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE));
        }
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    void setPricePerKilometer(double pricePerKilometer) {
        if (pricePerKilometer < PRICE_MIN_VALUE || pricePerKilometer > PRICE_MAX_VALUE) {
            throw new IllegalArgumentException(String.format(BUS_PRICE_PER_KILOMETER_ERROR, PRICE_MIN_VALUE, PRICE_MAX_VALUE));
        }
        this.pricePerKilometer = pricePerKilometer;
    }

    @Override
    public int getId() {
        return super.id;
    }

    @Override
    public String getAsString() {
        return String.format("Bus ----\n" +
                        "%s"
                , super.getAsString());
    }
}