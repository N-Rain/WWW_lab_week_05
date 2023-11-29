package vn.edu.iuh.fit.week5_lab_phamthibichngoc_20026291.backend.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/${app.rest.path}")
public class HealthyCheck {
    @GetMapping(path = "/heartbeat")
    public String beat(){
        return "OK";
    }
    @GetMapping(path = "")
    public String hello(){
        return "Hello";
    }
}
