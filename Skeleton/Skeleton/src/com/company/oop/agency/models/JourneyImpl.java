package com.company.oop.agency.models;

import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.vehicles.VehicleType;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;

public class JourneyImpl implements Journey {

    public static final int START_LOCATION_MIN_LENGTH = 5;
    public static final int START_LOCATION_MAX_LENGTH = 25;
    public static final int DESTINATION_MIN_LENGTH = 5;
    public static final int DESTINATION_MAX_LENGTH = 25;
    public static final int DISTANCE_MIN_VALUE = 5;
    public static final int DISTANCE_MAX_VALUE = 5000;
    public static final String START_LOCATION_LENGTH_ERROR = "The StartingLocation's length cannot be less than %d or more than %d symbols long.";
    public static final String DESTINATION_LENGTH_ERROR = "The Destination's length cannot be less than %d or more than %d symbols long.";
    public static final String JOURNEY_DISTANCE_ERROR = "The Distance cannot be less than %d or more than %d kilometers.";
    private String startLocation;
    private String destination;
    private int distance;
    private Vehicle vehicle;
    private int id;


    public JourneyImpl(int id, String startLocation, String destination, int distance, Vehicle vehicle) {
        setStartLocation(startLocation);
        setDestination(destination);
        setDistance(distance);
        this.id=id;
        this.vehicle=vehicle;

    }

    public void setStartLocation(String startLocation) {
        if(startLocation.length()<START_LOCATION_MIN_LENGTH || startLocation.length()>START_LOCATION_MAX_LENGTH){
            throw new IllegalArgumentException(String.format(START_LOCATION_LENGTH_ERROR,START_LOCATION_MIN_LENGTH,START_LOCATION_MAX_LENGTH));
        }
        this.startLocation = startLocation;
    }

    public void setDestination(String destination) {
        if(destination.length()<DISTANCE_MIN_VALUE || destination.length()>DESTINATION_MAX_LENGTH){
            throw new IllegalArgumentException(String.format(DESTINATION_LENGTH_ERROR,DESTINATION_MIN_LENGTH,DESTINATION_MAX_LENGTH));
        }
        this.destination = destination;
    }

    public void setDistance(int distance) {
        if(distance<DISTANCE_MIN_VALUE || distance>DISTANCE_MAX_VALUE){
            throw new IllegalArgumentException(String.format(JOURNEY_DISTANCE_ERROR,DISTANCE_MIN_VALUE,DISTANCE_MAX_VALUE));
        }
        this.distance = distance;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String getStartLocation() {
        return startLocation;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public double calculateTravelCosts() {

        return distance*vehicle.getPricePerKilometer();
    }

    @Override
    public VehicleType getType() {
        return vehicle.getType();
    }

    @Override
    public int getPassengerCapacity() {
        return vehicle.getPassengerCapacity();
    }

    @Override
    public double getPricePerKilometer() {
        return vehicle.getPricePerKilometer();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getAsString() {
        return String.format("Journey ----\n" +
                "Start location: %s\n" +
                "Destination: %s\n" +
                "Distance: %d\n" +
                "Vehicle type: %s\n" +
                "Travel costs: %.2f\n",startLocation,destination,distance,vehicle.getType(),calculateTravelCosts());
    }
}