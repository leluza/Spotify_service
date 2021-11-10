package com.spotify.spotifyservice.Controller.Request;

import com.spotify.spotifyservice.Domain.Model.Track;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AlbumRequest {

    private Long idAlbum;
    private String name;
    private Long idArtist;

}
