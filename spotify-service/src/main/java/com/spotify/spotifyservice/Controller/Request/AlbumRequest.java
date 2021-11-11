package com.spotify.spotifyservice.Controller.Request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AlbumRequest {

    private Long idAlbum;
    private String name;
    private Long idArtist;

}
