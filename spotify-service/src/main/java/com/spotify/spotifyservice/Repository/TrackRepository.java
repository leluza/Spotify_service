package com.spotify.spotifyservice.Repository;

import com.spotify.spotifyservice.Domain.Model.Artist;
import com.spotify.spotifyservice.Domain.Model.Track;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends CrudRepository<Track, Long> {

    Track findById(long id);

    //List<Track> findAll();

    @Query (value = "SELECT * FROM TRACK order by REPRODUCTION desc limit 5", nativeQuery = true )
    List<Track> rank();

    @Query(value = " select * from TRACK T join ARTIST AR on T.ID_ARTIST = AR.IDARTIST where IDARTIST = 2  order by REPRODUCTION desc limit 5 ", nativeQuery = true)
    List<Track> songsByArtistRank();    // Long idArtist);

}
