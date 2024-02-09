import DTO.GenerateTicketRequestDto;
import Repository.TicketRepository;
import controller.TicketController;
import services.TicketService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

//        GenerateTicketRequestDto generateTicketRequestDto = new GenerateTicketRequestDto();
//        TicketController ticketController = new TicketController();
//        ticketController.generateTicket(generateTicketRequestDto);

        ObjectContainer objectContainer = new ObjectContainer();

        TicketService ticketService = new TicketService();
        ObjectContainer.register("ticketService",ticketService);

        TicketController ticketController =
                new TicketController((TicketService) ObjectContainer.get("ticketRepository"));


    }

    // complete generate ticket and implement generate bill
}