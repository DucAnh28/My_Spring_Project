package ducanh.pro.musicservice.domain.playlist;

import ducanh.pro.commonconfig.domain.BaseEntity;
import ducanh.pro.musicservice.domain.song.Song;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "playlist")
@Table(name = "playlist")
public class Playlist extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "customer")
    private String customer;

    @JoinColumn(name = "song_id")
    @OneToMany(fetch = FetchType.EAGER)
    private List<Song> songs;


}
