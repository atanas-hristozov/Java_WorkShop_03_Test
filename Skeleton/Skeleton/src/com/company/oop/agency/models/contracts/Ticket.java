package com.company.oop.agency.models.contracts;

public interface Ticket extends Journey {

    Journey getJourney();

    double calculatePrice();

    double getAdministrativeCosts();

}