package ducanh.pro.musicservice.domain.song.reponse;

import ducanh.pro.musicservice.domain.album.Album;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SongResp {

    String title;

    LocalDate date;

    String genre;

    String picture;

    String link;

//    Artist artist;

    Album album;
}
