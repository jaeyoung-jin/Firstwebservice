package com.example.springboot.web;


import com.example.springboot.service.PostsService;
import com.example.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";

    }

    @GetMapping("/posts/list")
    public String postsList(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "postlist";
    }

    @GetMapping("/whatisBloodDonation")
    public String BloodDonation(){return "WhatIsBloodDonation";}

    @GetMapping("/jijeong")
    public String Jijeong(){return "JijeongBloodDonation";}

    @GetMapping("/references")
    public String References(){return "references";}

}
