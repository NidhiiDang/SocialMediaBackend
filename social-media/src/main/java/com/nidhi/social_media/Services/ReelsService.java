package com.nidhi.social_media.Services;

import com.nidhi.social_media.Model.Reels;
import com.nidhi.social_media.Model.Users;

import java.util.List;

public interface ReelsService {
    public Reels createReel(Reels reel, Users user);
    public List<Reels> findAllReels();
    public List<Reels> findUsersReels(Long userId) throws Exception;
}
