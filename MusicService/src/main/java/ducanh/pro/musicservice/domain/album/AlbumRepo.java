package ducanh.pro.musicservice.domain.album;

import ducanh.pro.commonconfig.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepo extends BaseRepository<Album, Long> {
}
