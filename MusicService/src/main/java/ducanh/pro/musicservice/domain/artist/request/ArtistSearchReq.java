package ducanh.pro.musicservice.domain.artist.request;

import ducanh.pro.commonconfig.domain.PagingReq;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArtistSearchReq extends PagingReq {
    private String keyword;
}
