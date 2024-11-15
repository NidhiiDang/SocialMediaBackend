package com.nidhi.social_media.Services;

import com.nidhi.social_media.Model.Story;
import com.nidhi.social_media.Model.Users;
import com.nidhi.social_media.Repository.StoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StoryServiceImpl implements StoryService {

    @Autowired
    private StoryRepo storyRepo;

    @Autowired
    private UserService userService;

    @Override
    public Story createStory(Story story, Users user) {
        Story createdStory = new Story();
        createdStory.setCaption(story.getCaption());
        createdStory.setImage(story.getImage());
        createdStory.setUser(user);
        createdStory.setTimeStamp(LocalDateTime.now());
     return storyRepo.save(createdStory);
    }

    @Override
    public List<Story> findStoryByUserId(Long userId) {
        Users user = userService.findUserById(userId);
        return storyRepo.findByUserId(userId);
    }
}
