package ducanh.pro.musicservice.domain.song.request;

import ducanh.pro.commonconfig.domain.PagingReq;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SongReq extends PagingReq {
    private String name;


}
