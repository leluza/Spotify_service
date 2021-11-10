package com.spotify.spotifyservice.Controller;


import com.spotify.spotifyservice.Controller.Request.AlbumRequest;
import com.spotify.spotifyservice.Domain.Model.Album;
import com.spotify.spotifyservice.Service.Imp.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping(path = "/{id}")
    public Album retrieveArtist(@PathVariable Long id)
    {

        return this.albumService.getAlbum(id);
    }

    @PostMapping
    public  Album createAlbum(@RequestBody AlbumRequest request)
    {   return albumService.createAlbum(request);     }

    @DeleteMapping(path = "/{id}")
    public Album deleteAlbum(@PathVariable Long id)
    {

        return this.albumService.deleteAlbum(id);
    }

    @PutMapping (path = "/{id}")
    public Album updateAlbum(@PathVariable Long id, @RequestBody AlbumRequest request)
    {
        return albumService.updateAlbum( id, request);

    }


}
