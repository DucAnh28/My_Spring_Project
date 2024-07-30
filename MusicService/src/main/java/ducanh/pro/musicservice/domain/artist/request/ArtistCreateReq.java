package ducanh.pro.musicservice.domain.artist.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArtistCreateReq implements Serializable {

    private String artistName;
    private Integer age;
    private String description;
}
