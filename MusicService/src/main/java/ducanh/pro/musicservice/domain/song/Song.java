package ducanh.pro.musicservice.domain.song;

import ducanh.pro.commonconfig.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

    @Column(name = "album_id")
    Long albumId;

    @Column(name = "artist_id")
    Long artistId;
}
