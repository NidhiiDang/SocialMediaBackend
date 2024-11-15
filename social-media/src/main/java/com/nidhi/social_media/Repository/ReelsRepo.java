package com.nidhi.social_media.Repository;

import com.nidhi.social_media.Model.Reels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReelsRepo extends JpaRepository<Reels,Long> {
       public List<Reels> findByUserId(Long userId);
}
