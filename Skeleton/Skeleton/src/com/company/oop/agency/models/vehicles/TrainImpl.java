package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.vehicles.contracts.Train;

public class TrainImpl extends VehicleImpl implements Train {

    public static final int MIN_CAPACITY = 30;
    public static final int MAX_CAPACITY = 150;
    public static final int CARTS_MIN_VALUE = 1;
    public static final int CARTS_MAX_VALUE = 15;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;
    public static final String TRAIN_CAPACITY_ERROR =
            "A train cannot have less than %d passengers or more than %d passengers.";
    public static final String TRAIN_PRICE_PER_KILOMETER_ERROR =
            "A vehicle with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!";
    public static final String TRAIN_CARTS_ERROR =
            "A train cannot have less than %d cart or more than %d carts.";
    protected int id;
    private int carts;
    private VehicleType vehicleType;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(id, passengerCapacity, pricePerKilometer, VehicleType.LAND);
        setCarts(carts);
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
    }

    @Override
    void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < MIN_CAPACITY || passengerCapacity > MAX_CAPACITY) {
            throw new IllegalArgumentException(String.format(TRAIN_CAPACITY_ERROR, MIN_CAPACITY, MAX_CAPACITY));
        }
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    void setPricePerKilometer(double pricePerKilometer) {
        if (pricePerKilometer < PRICE_MIN_VALUE || pricePerKilometer > PRICE_MAX_VALUE) {
            throw new IllegalArgumentException(String.format(TRAIN_PRICE_PER_KILOMETER_ERROR, PRICE_MIN_VALUE, PRICE_MAX_VALUE));
        }
        this.pricePerKilometer = pricePerKilometer;
    }


    private void setCarts(int carts) {
        if (carts < CARTS_MIN_VALUE || carts > CARTS_MAX_VALUE) {
            throw new IllegalArgumentException(String.format(TRAIN_CARTS_ERROR, CARTS_MIN_VALUE, CARTS_MAX_VALUE));
        }
        this.carts = carts;
    }

    @Override
    public int getCarts() {
        return carts;
    }

    @Override
    public int getId() {
        return super.id;
    }

    @Override
    public String getAsString() {
        return String.format("Train ----\n" +
                        "%s" +
                        "Carts amount: %d\n"
                , super.getAsString(), getCarts());
    }
}