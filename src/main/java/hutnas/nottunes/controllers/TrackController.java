package hutnas.nottunes.controllers;

import hutnas.nottunes.data_access.NotTunesRepository;
import hutnas.nottunes.data_access.TrackRepository;
import hutnas.nottunes.models.Artist;
import hutnas.nottunes.models.Genre;
import hutnas.nottunes.models.Track;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins="*")
@RestController
public class TrackController {

    private TrackRepository trackRepository = new TrackRepository();
    private NotTunesRepository randomRepository = new NotTunesRepository();

    @RequestMapping (value="track", method = RequestMethod.GET )
    public ArrayList<Track> getTracksByName(@RequestParam(value = "name") String name){
        return trackRepository.getTracksByName(name);
    }

    @RequestMapping (value="track/random", method = RequestMethod.GET)
    public ArrayList<Track> getRandomTracks(){
        return randomRepository.getRandomTracks();
    }

    @RequestMapping (value="artist/random", method = RequestMethod.GET)
    public ArrayList<Artist> getRandomArtists(){
        return randomRepository.getRandomArtists();
    }

    @RequestMapping (value="genre/random", method = RequestMethod.GET)
    public ArrayList<Genre> getRandomGenres(){
        return randomRepository.getRandomGenres();
    }
}
