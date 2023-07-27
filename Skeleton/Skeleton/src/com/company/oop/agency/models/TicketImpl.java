package com.company.oop.agency.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;
import com.company.oop.agency.models.vehicles.VehicleType;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.utils.ParsingHelpers;
import com.company.oop.agency.utils.ValidationHelper;

public class TicketImpl implements Ticket {
    public static final String NEGATIVE_COST_ERROR = "Value of 'costs' must be a positive number. Actual value: %.2f.";
    private double costs;
    private int id;
    private Journey journey;

    public TicketImpl(int id, Journey journey, double costs) {
        setAdministrativeCosts(costs);
        this.id=id;
        this.journey=journey;
    }

    public void setAdministrativeCosts(double costs) {
            if (costs < 0) {
            throw new InvalidUserInputException(String.format(NEGATIVE_COST_ERROR,costs));
        }
        this.costs = costs;
    }

    @Override
    public Journey getJourney() {

        return journey;
    }

    @Override
    public double calculatePrice() {
        return costs* journey.calculateTravelCosts();
    }

    @Override
    public double getAdministrativeCosts() {
        return costs;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public int getDistance() {
        return journey.getDistance();
    }

    @Override
    public Vehicle getVehicle() {
        return journey.getVehicle();
    }

    @Override
    public String getStartLocation() {
        return journey.getStartLocation();
    }

    @Override
    public String getDestination() {
        return journey.getDestination();
    }

    @Override
    public double calculateTravelCosts() {
        return journey.calculateTravelCosts();
    }

    @Override
    public VehicleType getType() {
        return journey.getType();
    }

    @Override
    public int getPassengerCapacity() {
        return journey.getPassengerCapacity();
    }

    @Override
    public double getPricePerKilometer() {
        return journey.getPricePerKilometer();
    }

    @Override
    public String getAsString() {
        return String.format("Ticket ----\n" +
                "Destination: %s\n" +
                "Price: %.2f\n",getDestination(),calculatePrice());
    }
}
