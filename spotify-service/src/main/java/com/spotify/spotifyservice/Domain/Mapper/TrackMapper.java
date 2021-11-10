package com.spotify.spotifyservice.Domain.Mapper;


import com.spotify.spotifyservice.Controller.Request.TrackRequest;
import com.spotify.spotifyservice.Domain.Model.Track;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TrackMapper implements Function<TrackRequest, Track> {

    @Override
    public Track apply(TrackRequest trackRequest) {
        return Track.builder()
                .idTrack(trackRequest.getId())
                .name(trackRequest.getName())
                .reproduction(trackRequest.getReproductions())
                .duration(trackRequest.getDuration())
                .build();
    }
}
