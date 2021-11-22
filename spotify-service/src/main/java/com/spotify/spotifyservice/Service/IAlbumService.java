package com.spotify.spotifyservice.Service;

import com.spotify.spotifyservice.Controller.Request.AlbumRequest;
import com.spotify.spotifyservice.Domain.Model.Album;

public interface IAlbumService {

    Album getAlbum(Long id);

    Album createAlbum(AlbumRequest request);

    Album deleteAlbum(Long id);

    Album updateAlbum(Long id, AlbumRequest request);


}

