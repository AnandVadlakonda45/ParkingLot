package controller;

import DTO.GenerateTicketRequestDto;
import DTO.GenerateTicketResponseDto;
import DTO.ResponseStatus;
import exception.NoParkingSpotFoundException;
import models.Gate;
import models.Operator;
import models.Ticket;
import models.Vehicle;
import services.TicketService;

import java.util.Date;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto generateTicketRequestDto){

        try {
            Ticket ticket = ticketService.generateTicket(
                    generateTicketRequestDto.getVehicleNumber(),
                    generateTicketRequestDto.getVehicleType(),
                    generateTicketRequestDto.getGateId());

            GenerateTicketResponseDto generateTicketResponseDto
                    = new GenerateTicketResponseDto();
            generateTicketResponseDto.setTicket(ticket);
            generateTicketResponseDto.setStatus(ResponseStatus.SUCCESS);

            return generateTicketResponseDto;
        } catch (NoParkingSpotFoundException e){
            GenerateTicketResponseDto generateTicketResponseDto
                    = new GenerateTicketResponseDto();
            generateTicketResponseDto.setStatus(ResponseStatus.FAILURE);
            generateTicketResponseDto.setFailureMessage(e.getMessage());

            return generateTicketResponseDto;
        }catch (Exception e){
            GenerateTicketResponseDto generateTicketResponseDto
                    = new GenerateTicketResponseDto();
            generateTicketResponseDto.setStatus(ResponseStatus.FAILURE);
            generateTicketResponseDto.setFailureMessage(e.getMessage());
            return generateTicketResponseDto;
        }
    }
}
