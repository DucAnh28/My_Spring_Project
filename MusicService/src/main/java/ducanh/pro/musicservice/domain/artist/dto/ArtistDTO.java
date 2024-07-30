package ducanh.pro.musicservice.domain.artist.dto;

import ducanh.pro.musicservice.domain.artist.Artist;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PUBLIC)
public class ArtistDTO implements Serializable {
    Long id;
    UUID code;
    String name;
    Integer age;
    String description;

    public static ArtistDTO fromEntity(Artist artist) {
        ArtistDTO artistDTO = new ArtistDTO();
        BeanUtils.copyProperties(artist, artistDTO);
        return artistDTO;
    }
}
