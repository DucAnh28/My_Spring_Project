package ducanh.pro.musicservice.domain.artist;

import ducanh.pro.commonconfig.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "artist")
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Artist extends BaseEntity {

    @Column(length = 50, name = "name")
    String name;

    @Column(name = "age")
    Integer age;

    @Column(name = "description")
    String description;
}
