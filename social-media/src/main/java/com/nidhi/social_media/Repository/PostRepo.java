package com.nidhi.social_media.Repository;

import com.nidhi.social_media.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {

    @Query("select p from Post p where p.user.id = :userID")
    List<Post> findPosts(@Param("userID") Long userID);
}
