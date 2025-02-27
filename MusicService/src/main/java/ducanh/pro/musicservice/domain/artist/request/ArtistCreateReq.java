package ducanh.pro.musicservice.domain.artist.request;

import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "name is required")
    private String name;
    private Integer age;
    @NotBlank(message = "description is required")
    private String description;
}
