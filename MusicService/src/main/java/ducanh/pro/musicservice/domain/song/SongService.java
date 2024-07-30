package ducanh.pro.musicservice.domain.song;

import ducanh.pro.commonconfig.service.CommonService;
import ducanh.pro.commonconfig.domain.PagingResp;
import ducanh.pro.musicservice.domain.song.reponse.SongCreateResp;
import ducanh.pro.musicservice.domain.song.reponse.SongResp;
import ducanh.pro.musicservice.domain.song.request.SongCreateReq;
import ducanh.pro.musicservice.domain.song.request.SongReq;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SongService {
    private final SongRepository songRepository;
    private final CommonService commonService;
    private final ModelMapper modelMapper;

    public PagingResp<SongResp> search(SongReq req) {
        PageRequest pageRequest = req.getPageRequest();

        var specification = SongSpecification.getByName(req.getName());

        var page = songRepository.findAll(specification, pageRequest);

        return commonService.getPageResp(page, SongResp.class);
    }

    public SongCreateResp create(SongCreateReq req) {
        Song song = new Song();
        song.setTitle(req.getTitle());
        song.setGenre(req.getGenre());
        song.setLink(req.getLink());
        song.setPicture(req.getPicture());

        return modelMapper.map(songRepository.save(song), SongCreateResp.class);
    }
}
