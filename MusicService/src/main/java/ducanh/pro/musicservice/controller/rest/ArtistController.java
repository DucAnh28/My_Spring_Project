package ducanh.pro.musicservice.controller.rest;

import ducanh.pro.musicservice.domain.artist.ArtistService;
import ducanh.pro.musicservice.domain.artist.dto.ArtistDTO;
import ducanh.pro.musicservice.domain.artist.request.ArtistCreateReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("artist")
@RequiredArgsConstructor
public class ArtistController {

    private final ArtistService artistService;

    @PostMapping()
    public ArtistDTO addArtist(@RequestBody ArtistCreateReq req) {
        return artistService.create(req);
    }
}
