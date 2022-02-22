package hutnas.nottunes.controllers;

import hutnas.nottunes.data_access.TrackRepository;
import hutnas.nottunes.models.Track;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")
@RestController
public class TrackController {

    private TrackRepository trackRepository = new TrackRepository();

    @RequestMapping (value="track", method = RequestMethod.GET )
    public Track getTrackByName(@RequestParam(value = "name") String name){
        return trackRepository.getTrackByName(name);
    }
}
