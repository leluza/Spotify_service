package com.spotify.spotifyservice.Controller;


import com.spotify.spotifyservice.Controller.Request.TrackRequest;
import com.spotify.spotifyservice.Domain.Model.Artist;
import com.spotify.spotifyservice.Domain.Model.Track;
import com.spotify.spotifyservice.Service.Imp.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/track")
public class TrackController {

    @Autowired
    private TrackService trackService;

    @GetMapping(path = "/{id}")
    public Track retrieveTrack(@PathVariable Long id) {
        return this.trackService.getTrack(id);
    }

    @PostMapping
    public Track createTrack(@RequestBody TrackRequest request) {
        return trackService.createTrack(request);
    }

    @DeleteMapping(path = "/{id}")
    public Track deleteTrack(@PathVariable Long id) {
        return this.trackService.deleteTrack(id);
    }

    @PutMapping(path = "/{id}")
    public Track updateTrack(@PathVariable Long id, @RequestBody TrackRequest request) {
        return trackService.updateTrack(id, request);
    }

    @GetMapping(path = "/rank")
    public List<Track> rank() {
        return trackService.rank();
    }


    @GetMapping(path = "/spotify/play/track/{id}")
    public Track incrementTrack(@PathVariable Long id) {

        return this.trackService.increment(id);
    }

    //  5 canciones mas populares del artista
    @GetMapping(path = "/{idArtist}/songs/rank")
    public List<Track> songsByArtistRank(@PathVariable Long idArtist) {
        return trackService.songsByArtistRank(idArtist);
    }

}
