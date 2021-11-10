package com.spotify.spotifyservice.Controller.Request;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Builder
@Data
public class ArtistRequest {

    @NotNull(message = "El campo id no puede ser null.")
    private Long idArtist;
    private String name;
    private String gender;
    private String image;
  //  private List<Album> albums;
}
