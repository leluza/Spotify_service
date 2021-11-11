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
@Table(name = "artist")

public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idartist")
    private Long idArtist;

    private String name;
    private String gender;
    private String image;

    //@OneToMany ( mappedBy = "artist")
    //private List<Album> albums ;

}
