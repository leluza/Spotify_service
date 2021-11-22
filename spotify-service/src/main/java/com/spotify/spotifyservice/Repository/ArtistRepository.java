package com.spotify.spotifyservice.Repository;

import com.spotify.spotifyservice.Domain.Model.Artist;
import com.spotify.spotifyservice.Domain.Model.Track;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long> {

    Artist findById(long id);

   // @Query(value = "select namee from ( select AR.IDARTIST as id , AR.NAME as namee   from TRACK T left join ARTIST AR on T.ID_ARTIST = AR.IDARTIST order by REPRODUCTION desc  ) group by id limit 5", nativeQuery = true)
   @Query(value = " select * from TRACK T left join ARTIST AR on T.ID_ARTIST = AR.IDARTIST order by REPRODUCTION desc ", nativeQuery = true)
    List<Artist> artistsRank();



}
