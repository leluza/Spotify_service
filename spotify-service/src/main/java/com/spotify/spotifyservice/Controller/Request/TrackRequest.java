package com.spotify.spotifyservice.Controller.Request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrackRequest {

    private Long Id;
    private String name;
    private Long reproductions;
    private Double duration;

}
