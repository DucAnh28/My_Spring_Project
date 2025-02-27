package ducanh.pro.musicservice.controller.admin;

import ducanh.pro.musicservice.domain.album.AlbumService;
import ducanh.pro.musicservice.domain.album.dto.AlbumDto;
import ducanh.pro.musicservice.domain.album.request.AlbumCreateReq;
import ducanh.pro.musicservice.domain.artist.ArtistService;
import ducanh.pro.musicservice.domain.artist.dto.ArtistDTO;
import ducanh.pro.musicservice.domain.artist.request.ArtistCreateReq;
import ducanh.pro.musicservice.domain.song.SongService;
import ducanh.pro.musicservice.domain.song.reponse.SongCreateResp;
import ducanh.pro.musicservice.domain.song.request.SongCreateReq;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class MusicController {

    private final SongService songService;
    private final AlbumService albumService;
    private final ArtistService artistService;

    @PostMapping("/song")
    public SongCreateResp createSong(@RequestBody @Valid SongCreateReq req) {
        return songService.create(req);
    }

    @PostMapping("/album")
    public AlbumDto createAlbum(@RequestBody @Valid AlbumCreateReq req) {
        return albumService.create(req);
    }

    @PostMapping("/artist")
    public ArtistDTO createArtist(@RequestBody @Valid ArtistCreateReq req) {
        return artistService.create(req);
    }
}
