package com.spotify.spotifyservice.Service;

import com.spotify.spotifyservice.Controller.Request.ArtistRequest;
import com.spotify.spotifyservice.Domain.Mapper.ArtistMapper;
import com.spotify.spotifyservice.Domain.Model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {


    @Autowired
    private ArtistMapper artistMapper;

    public Artist getArtist(Long id) {
        return Artist.builder().idArtist(1L).gender("Jazz").name("Juana DArco").image("ribvirbierfiberiierbvirebivb").build();
    }

    public Artist createArtist(ArtistRequest request) {
        return artistMapper.apply(request);
    }
}
