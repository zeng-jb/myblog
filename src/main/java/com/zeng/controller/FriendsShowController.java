package com.zeng.controller;

import com.zeng.service.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 友链展示
 */
@Controller
public class FriendsShowController {

    @Autowired
    private FriendLinkService friendLinkService;

    @GetMapping("/friends")
    public String friendShow(Model model){
        model.addAttribute("friendLinks",friendLinkService.listFriendLink());
        return "friends";
    }
}
