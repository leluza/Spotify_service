package com.spotify.spotifyservice.Service;

import com.spotify.spotifyservice.Controller.Request.ArtistRequest;
import com.spotify.spotifyservice.Domain.Model.Artist;
import com.spotify.spotifyservice.Domain.Model.Artist;

import java.util.List;

public interface IArtistService {

    Artist getArtist(Long id);

    Artist createArtist(ArtistRequest request);

    Artist deleteArtist(Long id);

    Artist updateArtist(Long id, ArtistRequest request);

    List<Artist> artistsRank();

   // List<Artist> songsByArtistRank();
}
