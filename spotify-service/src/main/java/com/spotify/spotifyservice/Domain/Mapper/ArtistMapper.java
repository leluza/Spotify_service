package com.spotify.spotifyservice.Domain.Mapper;

import com.spotify.spotifyservice.Controller.Request.ArtistRequest;
import com.spotify.spotifyservice.Domain.Model.Artist;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ArtistMapper implements Function<ArtistRequest, Artist> {

    @Override
    public Artist apply(ArtistRequest artistRequest)
    {
        return Artist.builder().idArtist(artistRequest.getIdArtist()).gender(artistRequest.getGender()).name(artistRequest.getGender()).image(artistRequest.getImage()).build();

    }
}
