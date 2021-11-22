package com.spotify.spotifyservice.Service;

import com.spotify.spotifyservice.Controller.Request.TrackRequest;
import com.spotify.spotifyservice.Domain.Model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITrackService  { //} extends JpaRepository<Track, Long> {

    Track getTrack(Long id);

    Track createTrack(TrackRequest request);

    Track deleteTrack(Long id);

    Track updateTrack(Long id, TrackRequest request);

    List<Track> rank();

    Track increment(Long id);

    List<Track> songsByArtistRank( Long idArtist);

}
