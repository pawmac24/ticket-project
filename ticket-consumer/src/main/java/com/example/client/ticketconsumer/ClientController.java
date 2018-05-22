package com.example.client.ticketconsumer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @RequestMapping("")
    public String clientInfo(){
        return "ticket-consumer";
    }
}
