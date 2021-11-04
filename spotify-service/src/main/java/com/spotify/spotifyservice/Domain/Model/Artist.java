package com.spotify.spotifyservice.Domain.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Artist {

    private Long idArtist;
    private String name;
    private String gender;
    private String image;
}
