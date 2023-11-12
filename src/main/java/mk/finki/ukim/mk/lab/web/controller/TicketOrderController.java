package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ticketOrder2")
public class TicketOrderController {
    @PostMapping
    public String submitOrder(@RequestParam String selectedMovie,
                              @RequestParam int numTickets,
                              @RequestParam String customerName,
                              Model model){

        model.addAttribute("selectedMovie",selectedMovie);
        model.addAttribute("numTickets",numTickets);
        model.addAttribute("clientName",customerName);

        return "orderConfirmation2";
    }
}