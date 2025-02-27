package ducanh.pro.musicservice.domain.album.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumCreateReq {

    private String name;
    private Long artist;
}
