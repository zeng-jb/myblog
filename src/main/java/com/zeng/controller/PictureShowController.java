package com.zeng.controller;

import com.zeng.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 照片墙
 */
@Controller
public class PictureShowController {

    @Autowired
    private PictureService pictureService;
    @GetMapping("/pictures")
    public String pictureWall(Model model){
        model.addAttribute("pictures",pictureService.listPicture());
        return "picture";
    }
}
