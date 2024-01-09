package project.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

    @GetMapping("/home")
    public String getHomePage() {
        return "user-detail"; // Refers to src/main/resources/static/pages/home.html
    }
}
