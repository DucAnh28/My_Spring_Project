package ducanh.pro.commonconfig.service;

import ducanh.pro.commonconfig.domain.PagingResp;
import ducanh.pro.commonconfig.utils.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public abstract class CommonService {

    private final MapperUtil mapperUtil;

    public <P, R> PagingResp<R> getPageResp(Page<P> page, Class<R> classResp) {
        var pageable = page.getPageable();
        var pageNumber = pageable.getPageNumber() + 1;
        var pageSize = pageable.getPageSize();

        if (page.isEmpty()) {
            return new PagingResp<>(
                    page.getTotalElements(),
                    pageNumber,
                    pageSize,
                    new ArrayList<>()
            );
        }

        return new PagingResp<>(
                page.getTotalElements(),
                pageNumber,
                pageSize,
                mapperUtil.mapList(page.getContent(), classResp)
        );
    }
}
