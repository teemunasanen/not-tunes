package hutnas.nottunes.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotTunesController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/results")
    public String results() {
        return "results";
    }

}
