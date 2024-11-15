package com.nidhi.social_media.Services;

import com.nidhi.social_media.Model.Reels;
import com.nidhi.social_media.Model.Users;
import com.nidhi.social_media.Repository.ReelsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReelsServiceImpl implements ReelsService{

    @Autowired
    private ReelsRepo reelsRepo;
    @Autowired
    private UserService userService;

    @Override
    public Reels createReel(Reels reel, Users user) {
        Reels createReel = new Reels();
        createReel.setTitle(reel.getTitle());
        createReel.setUser(user);
        createReel.setVideo(reel.getVideo());

        return reelsRepo.save(createReel);

    }

    @Override
    public List<Reels> findAllReels() {
        return reelsRepo.findAll();
    }

    @Override
    public List<Reels> findUsersReels(Long userId) throws Exception{
        userService.findUserById(userId);
        return reelsRepo.findByUserId(userId);
    }
}
