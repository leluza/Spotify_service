package com.spotify.spotifyservice.Domain.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

@Entity
@Table(name="track")

public class Track {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idTrack;

   // @NotEmpty(message = "The 'name' field can not be empty")
   // @NotNull (message = "The 'name' field can not be empty")
    //@Size(min=3, max=30, message="The number of characters is not allowed")
    private String name;

    //private Long idArtist;
    //private Long idAlbum;

    private Long reproduction;
   // @NotNull (message = "The 'duration' field can not be empty")
    private Double duration;

    @ManyToOne
    @JoinColumn(name ="idAlbum")
    private Album joinAlbum;

    @ManyToOne
    @JoinColumn(name ="idArtist")
    private Artist joinArtist;

}




/*******
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idtrack")
    private Long idtrack;

    private String name;
    private Long reproductions;
    private String duration;

    private Long idArtist;
    private Long idAlbum;


   // @ManyToOne
   // @JoinColumn( name = "idalbum")
   // private Album album;


}
 ****/
