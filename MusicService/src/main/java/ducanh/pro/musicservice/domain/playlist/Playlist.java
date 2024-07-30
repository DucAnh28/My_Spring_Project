//package ducanh.pro.musicservice.domain.playlist;
//
//import ducanh.pro.commonconfig.domain.BaseEntity;
//import ducanh.pro.musicservice.domain.song.Song;
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//
//import java.util.List;
//
//@EqualsAndHashCode(callSuper = true)
//@Data
//@Entity(name = "playlist")
//@Table(name = "tbl_playlist")
//public class Playlist extends BaseEntity {
//    @Column(name = "name")
//    private String name;
//
//    @OneToMany(mappedBy = "playlist", fetch = FetchType.LAZY)
//    private List<Song> songs;
//
////    @ManyToOne
////    @JoinColumn(name = "customer_id")
////    private Customer customer;
//}
