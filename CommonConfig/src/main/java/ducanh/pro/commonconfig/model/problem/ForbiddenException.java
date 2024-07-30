package ducanh.pro.commonconfig.model.problem;

import lombok.*;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ForbiddenException extends RuntimeException {
    private String title;
    private String detail;
    private Map<String, Object> parameters;

    public static ForbiddenException of(String title, String detail) {
        return ForbiddenException.builder()
                .title(title)
                .detail(detail)
                .build();
    }


    public static ForbiddenException of(String title, String detail, Object... data) {
        return ForbiddenException.builder()
                .title(title)
                .detail(String.format(detail, data))
                .build();
    }
}