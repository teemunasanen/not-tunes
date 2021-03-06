package hutnas.nottunes.controllers;

import hutnas.nottunes.data_access.NotTunesRepository;
import hutnas.nottunes.data_access.SearchRepository;
import hutnas.nottunes.models.Artist;
import hutnas.nottunes.models.Genre;
import hutnas.nottunes.models.Track;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins="*")
@RestController
public class TrackController {

    private SearchRepository trackRepository = new SearchRepository();
    private NotTunesRepository randomRepository = new NotTunesRepository();

    @RequestMapping (value="api/track", method = RequestMethod.GET )
    public ArrayList<Track> getTracksByName(@RequestParam(value = "name") String name){
        return trackRepository.getTracksByName(name);
    }

    @RequestMapping (value="api/random/track", method = RequestMethod.GET)
    public ArrayList<Track> getRandomTracks(){
        return randomRepository.getRandomTracks();
    }

    @RequestMapping (value="api/random/artist", method = RequestMethod.GET)
    public ArrayList<Artist> getRandomArtists(){
        return randomRepository.getRandomArtists();
    }

    @RequestMapping (value="api/random/genre", method = RequestMethod.GET)
    public ArrayList<Genre> getRandomGenres(){
        return randomRepository.getRandomGenres();
    }
}
