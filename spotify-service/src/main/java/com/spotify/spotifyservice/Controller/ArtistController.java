package com.spotify.spotifyservice.Controller;


import com.spotify.spotifyservice.Controller.Request.ArtistRequest;
import com.spotify.spotifyservice.Domain.Model.Artist;
import com.spotify.spotifyservice.Service.Imp.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping(path = "/{id}")
    public Artist retrieveArtist(@PathVariable Long id) {
        return this.artistService.getArtist(id);
    }

    @PostMapping(path = "")
    public Artist createArtist(@RequestBody ArtistRequest request) {
        return artistService.createArtist(request);
    }

    @DeleteMapping(path = "/{id}")
    public Artist deleteArtist(@PathVariable Long id) {

        return this.artistService.deleteArtist(id);
    }

    @PutMapping(path = "/{id}")
    public Artist updateArtist(@PathVariable Long id, @RequestBody ArtistRequest request) {
        return artistService.updateArtist(id, request);

    }


}
