package ducanh.pro.musicservice.domain.album;

import ducanh.pro.commonconfig.domain.BaseEntity;
import ducanh.pro.musicservice.domain.artist.Artist;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@Entity(name = "album")
@Table(name = "m_album")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Album extends BaseEntity {

    @Column(name = "name")
    String name;

    @ManyToOne()
    @JoinColumn(name = "artist_id")
    Artist artist;
}
