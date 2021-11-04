package com.spotify.spotifyservice.Domain.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Album {    //extends Artist {

    private Long idArtist;
    private Long idAlbum;
    private String name;
}
