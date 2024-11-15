package com.nidhi.social_media.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String caption;
    private String image;
    private String video;

    @ManyToOne
    private Users user;

    @OneToMany
    private List<Users> likes = new ArrayList<>();

    private LocalDateTime createdAt;

    public Post(String caption, String image, String video) {
        this.caption = caption;
        this.image = image;
        this.video = video;
    }
}
