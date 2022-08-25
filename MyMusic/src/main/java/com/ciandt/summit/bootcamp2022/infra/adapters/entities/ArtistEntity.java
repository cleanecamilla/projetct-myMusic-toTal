package com.ciandt.summit.bootcamp2022.infra.adapters.entities;
import com.ciandt.summit.bootcamp2022.domains.artists.Artist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Artistas")
public class ArtistEntity {
    @Id
    @Column(name = "Id")
    private String id = UUID.randomUUID().toString();

    @Column(name = "Nome")
    private String name;

    public ArtistEntity(Artist artist) {
        this.id = artist.getId();
        this.name = artist.getName();
    }

    public Artist toArtist() {
        return new Artist(this.id, this.name, new ArrayList<>());
    }
}
