package com.spotify.spotifyservice.Configuration;

import com.spotify.spotifyservice.Domain.Model.Album;
import com.spotify.spotifyservice.Domain.Model.Artist;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class ArtistConfiguration {

    @Bean(name = "artists")
    public List<Artist> getArtist() {
        return Arrays.asList(
                Artist.builder()
                        .name("ART1")
                        .gender("Malambo")
                        .image("cibrfriebvreivbi")
                        .build(),
                Artist.builder()
                        .name("ART2")
                        .gender("Jerez")
                        .image("cibrfCRVFVFvbi")
                        .build(),
                Artist.builder()
                        .name("ART3")
                        .gender("Eucaliptus")
                        .image("cibtbvtvbrggivbi")
                        .build()
        );
    }


}
