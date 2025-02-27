package ducanh.pro.musicservice.domain.album.dto;

import ducanh.pro.musicservice.domain.album.Album;
import ducanh.pro.musicservice.domain.artist.Artist;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AlbumDto {

    String name;
    Artist artist;

    public static AlbumDto fromEntity(Album album) {
        return AlbumDto.builder()
                .name(album.getName())
                .artist(album.getArtist())
                .build();
    }
}
