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
@Table(name = "track")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrack;
    private String name;
    private Long reproduction;
    private Double duration;
    @ManyToOne
    @JoinColumn(name = "idAlbum")
    private Album joinAlbum;
    @ManyToOne
    @JoinColumn(name = "idArtist")
    private Artist joinArtist;
}


