package ducanh.pro.commonconfig.model.problem;

import ducanh.pro.commonconfig.model.error.ErrorCode;
import lombok.*;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotFoundException extends RuntimeException {
    private String title;
    private String detail;
    private Map<String, Object> parameters;

    public static NotFoundException of(String title, String detail) {
        return NotFoundException.builder()
                .title(title)
                .detail(detail)
                .build();
    }


    public static NotFoundException of(String title, String detail, Object... data) {
        return NotFoundException.builder()
                .title(title)
                .detail(String.format(detail, data))
                .build();
    }

    public static NotFoundException of(ErrorCode errorCode, Object... data) {
        return NotFoundException.builder()
                .title(errorCode.code())
                .detail(String.format(errorCode.message(), data))
                .build();
    }
}
