package com.spotify.spotifyservice.Service.Imp;

import com.spotify.spotifyservice.Controller.Request.ArtistRequest;
import com.spotify.spotifyservice.Domain.Mapper.ArtistMapper;
import com.spotify.spotifyservice.Domain.Model.Artist;
import com.spotify.spotifyservice.Repository.ArtistRepository;
import com.spotify.spotifyservice.Service.IArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ArtistService implements IArtistService {


    @Autowired
    private ArtistMapper artistMapper;

    @Autowired
    private ArtistRepository artistRepository;

    @Qualifier("artists")
    @Autowired
    private List<Artist> artists;

    private Map<Long, Artist> artistMap = new HashMap<>();

    //@PostConstruct
    public void init() {
        //se ejecuta solo una vez cuando se crea el Bean
        artists.stream().forEach(artist -> {
            artistRepository.save(artist);
            System.out.println(artist);
        });

        System.out.println("COUNT --> " + artistRepository.count());
    }

    public Artist getArtist(Long id) {

        Optional<Artist> artistOp = artistRepository.findById(id);
        if (artistOp.isPresent()) {
            return artistOp.get();
        } else {
            return Artist.builder()
                    .idArtist(0L)
                    .gender("no se")
                    .name("pudo traer")
                    .image("el artista")
                    .build();
        }
    }

    public Artist createArtist(ArtistRequest request) {

        Artist artist = artistMapper.apply(request);
        if (request.getIdArtist() != null && artistRepository.findById(request.getIdArtist()) != null) {
            return Artist.builder()
                    .idArtist(0L)
                    .gender("el artista")
                    .name("ya EXISTE")
                    .build();

        } else {
            artistRepository.save(artist);
        }

        return artist;
        // return artistMapper.apply(request);
    }

    public Artist deleteArtist(Long id) {
        Optional<Artist> artistOp = artistRepository.findById(id);
        if (artistOp.isPresent()) {
            artistRepository.delete(artistOp.get());
            return artistOp.get();
        } else {
            return Artist.builder()
                    .idArtist(id)
                    .gender("no se")
                    .name("pudo eliminar")
                    .image("el artista")
                    .build();
        }
    }

    public Artist updateArtist(Long id, ArtistRequest request) {

        Optional<Artist> artistOp = artistRepository.findById(id);
        Artist artistDb = artistOp.get();
        Artist artistRqt = artistMapper.apply(request);
        if (artistOp.isPresent()) {
            artistDb.setName(artistRqt.getName());
            artistDb.setGender(artistRqt.getGender());
            artistDb.setImage(artistRqt.getImage());

            artistRepository.save(artistDb);
        } else {
            return Artist.builder()
                    .idArtist(id)
                    .gender("no se")
                    .name("pudo ACTUALIZAR")
                    .image("el artista")
                    .build();
        }
        return artistDb;
        // request.setIdArtist(id);
        // return artistMapper.apply(request);

    }
}
