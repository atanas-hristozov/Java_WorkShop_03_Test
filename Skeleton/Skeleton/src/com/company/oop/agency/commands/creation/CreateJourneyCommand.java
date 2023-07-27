package com.company.oop.agency.commands.creation;

import com.company.oop.agency.commands.contracts.Command;
import com.company.oop.agency.core.contracts.AgencyRepository;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.utils.ParsingHelpers;
import com.company.oop.agency.utils.ValidationHelper;

import java.util.List;

public class CreateJourneyCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 4;
    private static final String JOURNEY_CREATED_MESSAGE = "Journey with ID %d was created.";

    private final AgencyRepository agencyRepository;

    private int distance;
    private int vehicleId;
    private String destination;
    private String startLocation;


    public CreateJourneyCommand(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    public String execute(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);

        parseParameters(parameters);

        Vehicle vehicle = agencyRepository.findVehicleById(vehicleId);
        Journey createdJourney = agencyRepository.createJourney(startLocation, destination, distance, vehicle);

        return String.format(JOURNEY_CREATED_MESSAGE, createdJourney.getId());
    }

    private void parseParameters(List<String> parameters) {
        startLocation = parameters.get(0);
        destination = parameters.get(1);
        distance = ParsingHelpers.tryParseInteger(parameters.get(2), "distance");
        vehicleId = ParsingHelpers.tryParseInteger(parameters.get(3), "vehicle id");
    }

}