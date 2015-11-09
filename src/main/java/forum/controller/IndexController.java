/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.controller;

import forum.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author kk
 */
@Controller
public class IndexController {
    
    @Autowired
    private ForumService forumService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToIndex(Model model){
        model.addAttribute("forums", forumService.findAll());
        
        return "forum/list_forum";
    }
}
