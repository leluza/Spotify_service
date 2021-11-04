package com.spotify.spotifyservice.Domain.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Track {    //extends Album {

    private Long Id;
    private String name;
    private Long reproductions;
    private String duration;
    private Long idArtist;
    private Long idAlbum;


}
