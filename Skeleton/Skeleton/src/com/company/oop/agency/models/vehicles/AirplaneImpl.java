package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.vehicles.contracts.Airplane;

public class AirplaneImpl extends VehicleImpl implements Airplane {

    public static final int MIN_CAPACITY = 1;
    public static final int MAX_CAPACITY = 800;
    public static final double MIN_PRICE = 0.10;
    public static final double MAX_PRICE = 2.50;
    public static final String AIRPLANE_CAPACITY_ERROR =
            "An airplane cannot have less than %d passengers or more than %d passengers.";
    public static final String AIRPLANE_PRICE_PER_KILOMETER_ERROR =
            "A vehicle with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!";
    private final boolean hasFreeFood;

    protected int id;


    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(id, passengerCapacity, pricePerKilometer, VehicleType.AIR);
        this.hasFreeFood = hasFreeFood;
        setPricePerKilometer(pricePerKilometer);
        setPassengerCapacity(passengerCapacity);

    }

    @Override
    public boolean hasFreeFood() {
        return hasFreeFood;
    }

    @Override
    void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < MIN_CAPACITY || passengerCapacity > MAX_CAPACITY) {
            throw new IllegalArgumentException(String.format(AIRPLANE_CAPACITY_ERROR, MIN_CAPACITY, MAX_CAPACITY));
        }
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    void setPricePerKilometer(double pricePerKilometer) {
        if (pricePerKilometer < MIN_PRICE || pricePerKilometer > MAX_PRICE) {
            throw new IllegalArgumentException(String.format(AIRPLANE_PRICE_PER_KILOMETER_ERROR, MIN_PRICE, MAX_PRICE));
        }
        this.pricePerKilometer = pricePerKilometer;
    }


    @Override
    public int getId() {
        return super.id;
    }

    @Override
    public String getAsString() {
        return String.format("Airplane ----\n" +
                        "%s" +
                        "Has free food: %b\n"
                , super.getAsString(), hasFreeFood());
    }
}