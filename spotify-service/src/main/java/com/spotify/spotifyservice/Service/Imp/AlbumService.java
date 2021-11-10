package com.spotify.spotifyservice.Service.Imp;

import com.spotify.spotifyservice.Controller.Request.AlbumRequest;
import com.spotify.spotifyservice.Controller.Request.AlbumRequest;
import com.spotify.spotifyservice.Domain.Mapper.AlbumMapper;
import com.spotify.spotifyservice.Domain.Model.Album;
import com.spotify.spotifyservice.Domain.Model.Album;
import com.spotify.spotifyservice.Domain.Model.Album;
import com.spotify.spotifyservice.Domain.Model.Track;
import com.spotify.spotifyservice.Repository.AlbumRepository;
import com.spotify.spotifyservice.Service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumService implements IAlbumService {

    @Autowired
    private AlbumMapper albumMapper;

    @Autowired
    private AlbumRepository albumRepository;

    @Qualifier("albums")
    @Autowired
    private List<Album> albums;

    //@PostConstruct
    public void init() {
        //se ejecuta solo una vez cuando se crea el Bean
        albums.stream().forEach(album -> {
            albumRepository.save(album);
            System.out.println( album);
        });

        System.out.println( "COUNT --> "+albumRepository.count()  );
    }

    public Album getAlbum(Long id) {

        Optional<Album> albumOp = albumRepository.findById(id);
        if( albumOp.isPresent() ) {
            return albumOp.get();}
        else
        {
            return Album.builder()
                    .idAlbum(id)
                    .name("no se pudo encontrar el album")
                    .build();
        }
    }


    public Album createAlbum(AlbumRequest request) {

        Album album = albumMapper.apply(request);
        album.setIdAlbum(null);
        albumRepository.save(album);
        return album;

       /**
        if (request.getIdAlbum() != null && albumRepository.findById(request.getIdAlbum()) != null) {
            return Album.builder()
                    .idAlbum(0L)
                    .idAlbum(0L)
                    .name("EL album ya EXISTE")
                    .build();

        } else {
            albumRepository.save(album);
        }

        return album;
        */
       // return this.albumMapper.apply( request);
    }

    public Album deleteAlbum(Long id) {

        Optional<Album> albumOp = albumRepository.findById(id);
        if( albumOp.isPresent() ) {
            albumRepository.delete(albumOp.get());
            return albumOp.get();}
        else
        {
            return Album.builder()
                    .idAlbum(id)
                    .name("no se pudo eliminar el album")
                    .build();
        }
        //return Album.builder().idalbum(id).name("n-n").build();
    }

    public Album updateAlbum(Long id, AlbumRequest request) {
        Optional<Album> albumOp = albumRepository.findById(id);
        Album albumDb = albumOp.get();
        Album albumRqt = albumMapper.apply(request);
        if ( albumOp.isPresent()) {
            if( albumRqt.getName() != null) {albumDb.setName(albumRqt.getName());};
            if( albumRqt.getIdArtist() != null) {albumDb.setIdArtist(albumRqt.getIdArtist());};
            albumRepository.save(albumDb);
        } else {
            return Album.builder()
                    .idAlbum(0L)
                    .name("NO pudo ACTUALIZAR")
                    .idArtist(0L)
                    .build();
        }
        return albumDb;
//        request.setIdAlbum(id);
//        return albumMapper.apply(request);
    }
}
