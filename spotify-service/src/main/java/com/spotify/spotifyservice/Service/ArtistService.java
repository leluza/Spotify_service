package com.spotify.spotifyservice.Service;

import com.spotify.spotifyservice.Domain.Model.Artist;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {


    public Artist getArtist(Long id) {
        return Artist.builder().idArtist(1L).gender("Jazz").name("Juana DArco").image("ribvirbierfiberiierbvirebivb").build();
    }
}
