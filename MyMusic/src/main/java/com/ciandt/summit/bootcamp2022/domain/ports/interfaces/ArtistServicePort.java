package com.ciandt.summit.bootcamp2022.domain.ports.interfaces;
import com.ciandt.summit.bootcamp2022.domain.dtos.ArtistDTO;
import java.util.Set;

public interface ArtistServicePort {
    Set<ArtistDTO> searchArtist();
}
