package com.spotify.spotifyservice.Domain.Mapper;


import com.spotify.spotifyservice.Controller.Request.AlbumRequest;
import com.spotify.spotifyservice.Domain.Model.Album;
import com.spotify.spotifyservice.Domain.Model.Artist;
import com.spotify.spotifyservice.Domain.Model.Track;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
public class AlbumMapper implements Function<AlbumRequest, Album> {

    @Override
    public Album apply(AlbumRequest albumRequest)
    {
        return Album.builder()
                .idAlbum(albumRequest.getIdAlbum())
                .name(albumRequest.getName())
                //.tracks(new ArrayList<Track>() )
                .build();

    }
}

