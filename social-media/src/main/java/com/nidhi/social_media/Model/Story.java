package com.nidhi.social_media.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Users user;
    private String image;
    private String video;
    private String caption;
    private LocalDateTime timeStamp;

    public Story(String image,String video, String caption) {
        this.image = image;
        this.caption = caption;
        this.video = video;
    }
}
