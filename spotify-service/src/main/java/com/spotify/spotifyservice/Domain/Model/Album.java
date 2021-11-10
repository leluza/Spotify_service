package com.spotify.spotifyservice.Domain.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

@Entity
@Table(name="album")

public class Album {    //extends Artist {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_album")
    private Long idAlbum;

    private String name;

    @Column(name = "id_artist")
    private Long idArtist;

    //@ManyToOne
    //@JoinColumn(name="idartist")
    //private Artist idArtist;    //artist;

   // @OneToMany ( mappedBy = "album")
   // private List<Track> tracks ;

}
