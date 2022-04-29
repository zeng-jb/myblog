package com.zeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 音乐盒
 */
@Controller
public class MusicShowController {

    @GetMapping("/music")
    public String music(){
        return "music";
    }
}
