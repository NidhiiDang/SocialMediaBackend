package com.nidhi.social_media.Services;

import com.nidhi.social_media.Model.Story;
import com.nidhi.social_media.Model.Users;

import java.util.List;

public interface StoryService {
    public Story createStory(Story story, Users user);
    public List<Story> findStoryByUserId(Long userId);
}
