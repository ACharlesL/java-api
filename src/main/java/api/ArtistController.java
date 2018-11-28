package api;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@RestController
public class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;

    @RequestMapping(value = "/artists", method=RequestMethod.GET)
    public @ResponseBody Iterable<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @RequestMapping(value = "/artists/{id}", method=RequestMethod.GET)
    public @ResponseBody Optional<Artist> getArtist(@PathVariable Long id) {
    	return artistRepository.findById(id);
    }

    @RequestMapping(value = "/artists", method=RequestMethod.POST)
    public ResponseEntity<Artist> createArtist(@RequestBody Artist artist) {
    	artistRepository.save(artist);

    	return new ResponseEntity<Artist>(artist, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/artists/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> updateArtist(@PathVariable Long id, @RequestBody Artist updatedArtist) {
    	Optional<Artist> found = artistRepository.findById(id);

    	// https://www.baeldung.com/java-optional
    	found.ifPresent(artist -> {
    		artist.setName(updatedArtist.getName());
    		artistRepository.save(artist);
    	});

    	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/artists/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> updateArtist(@PathVariable Long id) {
    	artistRepository.deleteById(id);

    	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
