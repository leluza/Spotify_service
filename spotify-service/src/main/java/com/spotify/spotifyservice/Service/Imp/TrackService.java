package com.spotify.spotifyservice.Service.Imp;

import com.spotify.spotifyservice.Controller.Request.TrackRequest;
import com.spotify.spotifyservice.Domain.Mapper.TrackMapper;
import com.spotify.spotifyservice.Domain.Model.Track;
import com.spotify.spotifyservice.Domain.Model.Track;
import com.spotify.spotifyservice.Domain.Model.Track;
import com.spotify.spotifyservice.Domain.Model.Track;
import com.spotify.spotifyservice.Repository.TrackRepository;
import com.spotify.spotifyservice.Service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class TrackService implements ITrackService { //}, JpaRepository<Track, Long> {

    @Autowired
    private TrackMapper trackMapper;

    @Autowired
    private TrackRepository trackRepository;

    @Qualifier("tracks")
    @Autowired
    private List<Track> tracks;

    //@PostConstruct
    public void init() {
        //se ejecuta solo una vez cuando se crea el Bean
        tracks.stream().forEach(track -> {
            trackRepository.save(track);
        });
    }

    @Override
    public Track getTrack(Long id) {
        Optional<Track> trackOp = trackRepository.findById(id);
        if (trackOp.isPresent()) {
            return trackOp.get();
        } else {
            return Track.builder()
                    .idTrack(id)
                    .name("no se pudo encontrar el track")
                    .build();
        }
    }

    @Override
    public Track createTrack(TrackRequest request) {
        Track track = trackMapper.apply(request);
        track.setIdTrack(null);
        trackRepository.save(track);
        return track;
    }

    @Override
    public Track deleteTrack(Long id) {
        Optional<Track> trackOptional = trackRepository.findById(id);
        if (trackOptional.isPresent()) {
            trackRepository.delete(trackOptional.get());
            return trackOptional.get();
        } else {
            return Track.builder()
                    .idTrack(0L)
                    .name("no se pudo eliminar el track")
                    .build();
        }
    }

    @Override
    public Track updateTrack(Long id, TrackRequest request) {
        Optional<Track> trackOp = trackRepository.findById(id);
        Track trackDb = trackOp.get();
        Track trackRqt = trackMapper.apply(request);
        if (trackOp.isPresent()) {
            if (trackRqt.getName() != null) {
                trackDb.setName(trackRqt.getName());
            }
            ;
            if (trackRqt.getReproduction() != null) {
                trackDb.setReproduction(trackRqt.getReproduction());
            }
            ;
            if (trackRqt.getDuration() != null) {
                trackDb.setDuration(trackRqt.getDuration());
            }

            if( trackRqt.getJoinAlbum() != null)
            {
                trackDb.setJoinAlbum( trackRqt.getJoinAlbum());
            }

            if( trackRqt.getJoinArtist() != null)
            {
                trackDb.setJoinArtist(trackRqt.getJoinArtist());
            }
            trackRepository.save(trackDb);
            return trackDb;

        } else {
            return Track.builder()
                    .idTrack(0L)
                    .name("NO pudo ACTUALIZAR")
                    .reproduction(0L)
                    .duration(0D)
                    .build();
        }
    }

    @Override
    public List<Track> rank() {
        List<Track> tracks = trackRepository.rank();
        return tracks;
    }

    @Override
    public Track increment(Long id)
    {
        Optional<Track> trackOp = trackRepository.findById(id);
        if (trackOp.isPresent()) {
            Track track = trackOp.get();
            track.setReproduction( track.getReproduction() +1);
            trackRepository.save(track);
            return track;

        } else {
            return Track.builder()
                    .idTrack(id)
                    .name("no se pudo encontrar el track")
                    .build();
        }

    }

    @Override
    public List<Track> songsByArtistRank( Long idArtist) {
        List<Track> allTracks = trackRepository.songsByArtistRank();
        List<Track> famousTracks = new ArrayList<>();
        /*tracks.stream().forEach(
                                    a -> {  System.out.println( a.getIdTrack());
                                                if( !famousTracks.contains(a) )
                                                     {  famousTracks.add(a); }
                                }); */
        Iterator<Track> it = allTracks.iterator();

        while (it.hasNext()) {
            Track a = it.next();
            if( !famousTracks.contains(a) )
            {  famousTracks.add(a); }
        }

        return famousTracks;
    }


}
