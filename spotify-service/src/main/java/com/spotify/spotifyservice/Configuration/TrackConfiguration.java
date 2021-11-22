package com.spotify.spotifyservice.Configuration;

import com.spotify.spotifyservice.Domain.Model.Album;
import com.spotify.spotifyservice.Domain.Model.Artist;
import com.spotify.spotifyservice.Domain.Model.Track;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class TrackConfiguration {

    @Bean(name = "tracks")
    public List<Track> getTrack() {
        return Arrays.asList(
                Track.builder()
                        .name("TRACK1")
                        .duration(1.54)
                        .reproduction(1L)
                        .joinAlbum(Album.builder().idAlbum(1L).build())
                        .joinArtist(Artist.builder().idArtist(1L).build())
                        .build(),
                Track.builder()
                        .name("TRACK2")
                        .duration(2.54)
                        .reproduction(2L)
                        .joinAlbum(Album.builder().idAlbum(2L).build())
                        .joinArtist(Artist.builder().idArtist(2L).build())
                        .build(),
                Track.builder()
                        .name("TRACK3")
                        .duration(4.35)
                        .reproduction(3L)
                        .joinAlbum(Album.builder().idAlbum(3L).build())
                        .joinArtist(Artist.builder().idArtist(3L).build())
                        .build()
        );
    }
}
