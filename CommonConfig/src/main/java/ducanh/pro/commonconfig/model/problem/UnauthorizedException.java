package ducanh.pro.commonconfig.model.problem;

import lombok.*;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UnauthorizedException extends RuntimeException {
    private String title;
    private String detail;
    private Map<String, Object> parameters;

    public static UnauthorizedException of(String title, String detail) {
        return UnauthorizedException.builder()
                .title(title)
                .detail(detail)
                .build();
    }


    public static UnauthorizedException of(String title, String detail, Object... data) {
        return UnauthorizedException.builder()
                .title(title)
                .detail(String.format(detail, data))
                .build();
    }
}


