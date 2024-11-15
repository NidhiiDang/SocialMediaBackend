package com.nidhi.social_media.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Reels {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String video;
    @ManyToOne
    private Users user;

    public Reels(String title, String video) {
        this.title = title;
        this.video = video;
    }
}
