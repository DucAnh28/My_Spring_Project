package ducanh.pro.commonconfig.model.problem;

import lombok.*;

import java.util.Map;
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InternalServerException extends RuntimeException {
    private String title;
    private String detail;
    private Map<String, Object> parameters;

    public static InternalServerException of(String title, String detail) {
        return InternalServerException.builder()
                .title(title)
                .detail(detail)
                .build();
    }


    public static InternalServerException of(String title, String detail, Object... data) {
        return InternalServerException.builder()
                .title(title)
                .detail(String.format(detail, data))
                .build();
    }
}