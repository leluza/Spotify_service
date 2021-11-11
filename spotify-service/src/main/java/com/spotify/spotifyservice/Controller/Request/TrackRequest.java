package com.spotify.spotifyservice.Controller.Request;
import com.spotify.spotifyservice.Domain.Model.Artist;
import com.spotify.spotifyservice.Domain.Model.Album;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TrackRequest {

    private Long Id;
    private String name;
    private Long reproduction;
    private Double duration;
    private Album joinAlbum;
    private Artist joinArtist;

}
