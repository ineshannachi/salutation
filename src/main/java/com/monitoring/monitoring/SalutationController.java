package com.monitoring.monitoring;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalutationController {
    @GetMapping("/Salutation")
    public String Salutation() {
        return "Bonjour Master DevOps II";
    }
}

