package com.spotify.spotifyservice.Controller.Request;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ArtistRequest {

    private Long idArtist;
    private String name;
    private String gender;
    private String image;
}
