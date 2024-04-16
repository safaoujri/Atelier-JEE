package ma.xproce.inventoryservice.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String url;
    private String description;
    private Date datePublication;
    @ManyToOne
    private Creator creator;
    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", name=" + name +
                ", url=" + url +
                ", description=" + description +
                ", datePub "+datePublication+
                '}';
    }

}
