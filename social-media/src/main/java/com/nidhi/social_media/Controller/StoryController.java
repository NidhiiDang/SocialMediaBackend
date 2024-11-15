package com.nidhi.social_media.Controller;

import com.nidhi.social_media.Jwt.JwtService;
import com.nidhi.social_media.Model.Story;
import com.nidhi.social_media.Model.Users;
import com.nidhi.social_media.Services.StoryService;
import com.nidhi.social_media.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoryController {

    @Autowired
    private StoryService storyService;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/api/createStory")
    public Story createStory(@Valid @RequestBody Story story, @RequestHeader("Authorization") String jwt){

        Users reqUser = userService.findUserByUsername(jwtService.extractUserName(jwt));
        return storyService.createStory(story, reqUser);

    }

    @GetMapping("/api/story/{userId}")
    public List<Story> getAllUsersStories(@PathVariable Long userId, @RequestHeader("Authorization") String jwt){
        Users reqUser = userService.findUserByUsername(jwtService.extractUserName(jwt));
        return storyService.findStoryByUserId(userId);
    }

}
