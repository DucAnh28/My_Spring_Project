package ducanh.pro.musicservice.domain.song;

import ducanh.pro.commonconfig.domain.BaseEntity;
import ducanh.pro.musicservice.domain.album.Album;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "song")
@Data
@Table(name = "song")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Song extends BaseEntity {
    @Column(name = "title")
    String title;

    @Column(name = "date_release")
    Instant date;

    @Column(name = "genre")
    String genre;

    @Column(name = "picture")
    String picture;

    @Column(name = "link")
    String link;

    @ManyToOne
    @JoinColumn(name = "album_id")
    Album album;
}
