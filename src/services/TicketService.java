package services;

import Repository.TicketRepository;
import exception.NoParkingSpotFoundException;
import models.*;
import strategy.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {
    private VehicleService vehicleService;
    private GateService gateService;
    private ParkingSpotService parkingSpotService;

    private TicketRepository ticketRepository;
    private ParkingLotService parkingLotService;

    public Ticket generateTicket(String vehicleNumber,
                                 VehicleType vehicleType, Long gateId) throws NoParkingSpotFoundException {
//        Flow:
//        1.Get vehicle object from DB using vehicleNumber
//        2.If vehicle is not found,register vehicle
        Vehicle vehicle = vehicleService.getVehicle(vehicleNumber);
        if(vehicle == null){
            vehicle = vehicleService.registerVehicle(vehicleNumber,vehicleType);
        }

        Gate gate = gateService.getGate(gateId);
        //3.Assign parking spot
        ParkingSpot parkingSpot = parkingLotService.getParkingSpot(vehicle,gate);

        if (parkingSpot == null){
            throw new NoParkingSpotFoundException("No parking spot found");
        }

        //TODO: Implement assign spot logic

//        4.Update parking spot as occupied
        ParkingSpot parkingSpot = parkingSpotService.assignParkingSpot(parkingSpot);

//        5.Generate ticket
        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.
        ticket.setParkingSpot(parkingSpot);
        ticket.setOperator(gate.getOperator());
        ticket.setEntryTime(new Date());

        ticketRepository.save(ticket);

        return null;
    }

}
