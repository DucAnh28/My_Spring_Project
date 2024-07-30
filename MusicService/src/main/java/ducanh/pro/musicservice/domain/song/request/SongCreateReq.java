package ducanh.pro.musicservice.domain.song.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongCreateReq {
    private String title;

    private String genre;

    private String picture;

    private String link;

    private Long artistId;
}
