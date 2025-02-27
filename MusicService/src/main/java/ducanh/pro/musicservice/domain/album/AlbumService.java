package ducanh.pro.musicservice.domain.album;

import ducanh.pro.commonconfig.model.problem.BadRequestException;
import ducanh.pro.musicservice.domain.album.dto.AlbumDto;
import ducanh.pro.musicservice.domain.album.request.AlbumCreateReq;
import ducanh.pro.musicservice.domain.artist.Artist;
import ducanh.pro.musicservice.domain.artist.ArtistRepository;
import ducanh.pro.musicservice.domain.artist.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepo albumRepo;

    private final ArtistRepository artistRepository;

    public AlbumDto create(AlbumCreateReq req) {
        Artist artist = artistRepository.findById(req.getArtist())
                .orElseThrow(() -> BadRequestException.of("artist_not_found", "Artist not exist"));

        Album album = new Album();
        album.setName(req.getName());
        album.setArtist(artist);

        return AlbumDto.fromEntity(albumRepo.save(album));
    }
}