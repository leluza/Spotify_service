package com.spotify.spotifyservice.Service.Imp;

import com.spotify.spotifyservice.Controller.Request.TrackRequest;
import com.spotify.spotifyservice.Domain.Mapper.TrackMapper;
import com.spotify.spotifyservice.Domain.Model.Album;
import com.spotify.spotifyservice.Domain.Model.Track;
import com.spotify.spotifyservice.Repository.TrackRepository;
import com.spotify.spotifyservice.Service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class TrackService implements ITrackService {

    @Autowired
    private TrackMapper trackMapper;

    @Autowired
    private TrackRepository trackRepository;

    //@Qualifier("tracks")
    @Autowired
    private List<Track> tracks;

    //@PostConstruct
    public void init() {
        //se ejecuta solo una vez cuando se crea el Bean
        tracks.stream().forEach(track -> {
            trackRepository.save(track);
            System.out.println(track);
        });

        System.out.println("COUNT --> " + trackRepository.count());
    }

    @Override
    public Track getTrack(Long id) {
        Optional<Track> trackOptional = trackRepository.findById(id);
        if (trackOptional.isPresent()) {
            return trackOptional.get();
        } else {
            return Track.builder()
                    .idTrack(id)
                    .name("no se pudo encontrar el track")
                    .build();
        }
    }



    @Override
    public Track createTrack(TrackRequest request) {
        return trackMapper.apply(request);
    }

    @Override
    public Track deleteTrack(Long id) {
        Optional<Track> trackOptional = trackRepository.findById(id);
        if (trackOptional.isPresent()) {
            trackRepository.delete(trackOptional.get());
            return trackOptional.get();
        } else {
            return Track.builder()
                    .idTrack(id)
                    .name("no se pudo eliminar el track")
                    .build();
        }
    }

    @Override
    public Track updateTrack(Long id, TrackRequest request) {

        request.setId(id);
        return trackMapper.apply(request);
    }
}
