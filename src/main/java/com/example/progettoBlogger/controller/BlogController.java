package com.example.progettoBlogger.controller;


import com.example.progettoBlogger.model.Post;
import com.example.progettoBlogger.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPost(){
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = blogService.findAll();
        mv.addObject("posts", posts);
        return mv;
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("postDetails");
       Post post = blogService.findById(id);
        mv.addObject("post", post);
        return mv;
}

    @RequestMapping(value = "/newpost", method = RequestMethod.GET)
    public String getPostForm(){
        return "postForm";
    }

    @RequestMapping(value = "/newpost", method = RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()){
            attributes.addFlashAttribute("mensagem","Assicurati che i campi richiesti siano compilati!");
            return "redirect:/newpost";

        }
        post.setData(LocalDate.now());
        blogService.save(post);
            return "redirect:/posts";
        }

}
