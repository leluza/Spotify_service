package com.spotify.spotifyservice.Controller.Request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ArtistRequest {

    @NotNull(message = "El campo id no puede ser null.")
    private Long idArtist;
    private String name;
    private String gender;
    private String image;
}
