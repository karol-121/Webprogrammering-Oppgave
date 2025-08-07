package webprogrammering.oblig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {

    @Autowired
    TicketRepository ticketRepository;

    @PostMapping("/registerTicket")
    public boolean registerTicket(Ticket ticket){
        try {
            TicketValidation.validateTicket(ticket);
            return ticketRepository.addTicket(ticket);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @GetMapping("/getTickets")
    public List<Ticket> getTickets(){
        return ticketRepository.getAllTickets();
    }

    @GetMapping("/deleteTickets")
    public boolean deleteTickets(){
        return ticketRepository.deleteAllTickets();
    }
}