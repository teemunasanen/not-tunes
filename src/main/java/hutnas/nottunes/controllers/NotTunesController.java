package hutnas.nottunes.controllers;


import hutnas.nottunes.data_access.NotTunesRepository;
import hutnas.nottunes.data_access.SearchRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NotTunesController {
    NotTunesRepository random = new NotTunesRepository();
    SearchRepository find = new SearchRepository();

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("artists", random.getRandomArtists());
        model.addAttribute("tracks", random.getRandomTracks());
        model.addAttribute("genres", random.getRandomGenres());

        return "home";
    }

    @RequestMapping("/results")
    public String results(Model model, @RequestParam(value = "query") String name) {
        model.addAttribute("name", name);
        model.addAttribute("results", find.getTracksByName(name));

        return "results";
    }
}
