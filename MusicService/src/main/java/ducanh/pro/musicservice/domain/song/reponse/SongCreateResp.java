package ducanh.pro.musicservice.domain.song.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SongCreateResp {
    String title;

    LocalDate date;

    String genre;

    String picture;

    String link;

//    Album album;
}
