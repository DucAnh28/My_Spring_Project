package ducanh.pro.musicservice.controller.rest;

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
@RequestMapping("/song")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

}
