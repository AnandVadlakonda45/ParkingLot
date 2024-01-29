package controller;

import DTO.GenerateTicketRequestDto;
import DTO.GenerateTicketResponseDto;
import models.Gate;
import models.Operator;
import models.Ticket;
import models.Vehicle;
import services.TicketService;

import java.util.Date;

public class TicketController {
    private TicketService ticketService;
    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto generateTicketRequestDto){

        Ticket ticket = ticketService.generateTicket(
                generateTicketRequestDto.getVehicleNumber(),
                generateTicketRequestDto.getVehicleType(),
                generateTicketRequestDto.getGateId());
    }
}
