package com.nidhi.social_media.Repository;

import com.nidhi.social_media.Model.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepo extends JpaRepository<Story,Long> {
    public List<Story> findByUserId(Long id);
}
