package com.spotify.spotifyservice.Controller;


import com.spotify.spotifyservice.Domain.Model.Artist;
import com.spotify.spotifyservice.Service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping(path = "/{id}")
    public Artist retrieveArtist(@PathVariable Long id)
    {
        //log.info("id {}, id");
        return this.artistService.getArtist(id);
    }

}
