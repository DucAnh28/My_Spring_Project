package ducanh.pro.musicservice.domain.artist;

import ducanh.pro.commonconfig.service.CommonService;
import ducanh.pro.commonconfig.domain.PagingResp;
import ducanh.pro.commonconfig.domain.specification.SpecificationTemplate;
import ducanh.pro.musicservice.domain.artist.dto.ArtistDTO;
import ducanh.pro.musicservice.domain.artist.request.ArtistCreateReq;
import ducanh.pro.musicservice.domain.artist.request.ArtistSearchReq;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistService  {

    private final CommonService commonService;
    private final ArtistRepository artistRepository;

    public PagingResp<ArtistDTO> search(ArtistSearchReq req) {
        PageRequest pageRequest = req.getPageRequest();

        Specification<Artist> specification = SpecificationTemplate.like(Artist_.NAME, req.getKeyword());
        Page<Artist> page = artistRepository.findAll(specification, pageRequest);

        return commonService.getPageResp(page, ArtistDTO.class);
    }

    public ArtistDTO create(ArtistCreateReq req) {
        Artist artist = Artist.builder()
                .name(req.getArtistName())
                .age(req.getAge())
                .description(req.getDescription())
                .build();

        var saved = artistRepository.save(artist);
        return ArtistDTO.fromEntity(saved);
    }
}
