package com.spotify.spotifyservice.Configuration;

import com.spotify.spotifyservice.Domain.Model.Album;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AlbumConfiguration {

    @Bean(name = "albums")
    public List<Album> getAlbum() {
        return Arrays.asList(
                Album.builder().name("ALBUM1").idArtist(1L).build(),
                Album.builder().name("ALBUM2").idArtist(1L).build(),
                Album.builder().name("ALBUM3").idArtist(1L).build()
        );
    }
}


