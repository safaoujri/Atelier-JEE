package ma.xproce.inventoryservice.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Createur")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Creator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String email;
    @OneToMany(mappedBy = "creator", fetch = FetchType.EAGER)
    private Collection<Video> video;

    public void addVideo(Video newVideo) {
        if (this.video == null) {
            this.video = new ArrayList<>();
        }
        this.video.add(newVideo);
    }

    @Override
    public String toString() {
        return "Creator{" +
                "id=" + id +
                ", nom=" + nom +
                ", email=" + email +
                ", video=" + video +
                '}';
    }
}