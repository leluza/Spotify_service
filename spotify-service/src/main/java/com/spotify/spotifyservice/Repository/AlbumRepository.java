package com.spotify.spotifyservice.Repository;

import com.spotify.spotifyservice.Domain.Model.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {

    Album findById(long id);
}


