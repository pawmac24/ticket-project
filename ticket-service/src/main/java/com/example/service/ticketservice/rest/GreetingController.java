package com.example.service.ticketservice.rest;

import com.example.service.ticketservice.model.Greeting;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/{name}")
    public Greeting greeting(@PathVariable("name") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping({"/", ""})
    public List<Greeting> greetingList() {
        List<String> names = Arrays.asList("Pawel", "Adam", "Krzysztof");
        return names.stream()
                .map(name -> new Greeting(counter.incrementAndGet(), String.format(template, name)) )
                .collect(Collectors.toList());
    }
}
