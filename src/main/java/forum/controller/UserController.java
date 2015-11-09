/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.controller;

import forum.entity.Utilisateur;
import forum.service.UtilisateurService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author kk
 */
@Controller
public class UserController {

    @Autowired
    private UtilisateurService userService; // c'est un exemple! en regle generale, pas de controller dans un dao, plutot des services.

    @RequestMapping(value = "/lister", method = RequestMethod.GET)// la route
    public String list(Model model) {
        model.addAttribute("users", userService.findAll());

        return "user/user_list";//la vue à afficher;
    }

    @RequestMapping(value = "/ajouter", method = RequestMethod.GET)
    public String ajout(Model model) {
        Utilisateur utilisateur = userService.findOne(1L);
        model.addAttribute("util", utilisateur);

        return "user/user_ajout";
    }

    @RequestMapping(value = "/ajouterPost", method = RequestMethod.POST)
    public String ajout(@ModelAttribute("util") Utilisateur u, Model model) {
        model.addAttribute("NOM", u.getLogin());
        model.addAttribute("PRENOM", u.getMdp());

        return "user/user_ajout";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet(Model model, HttpServletRequest req) {
        String estLogge = req.getParameter("estLogge");
        Boolean logg = false;
        if (estLogge != null) {
            logg = new Boolean(req.getParameter("estLogge"));
        }
        model.addAttribute("estLogge", logg);
        return "user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(Model model, HttpServletRequest req) {
        Utilisateur u = userService.findOneByLogin(req.getParameter("login"));
        boolean estLogge = (u!=null && u.getMdp().equals(req.getParameter("mdp")));
        if(estLogge) {             
            req.getSession().setAttribute("estLogge", estLogge);            
            req.getSession().setAttribute("role", "admin");
            req.getSession().setAttribute("user", "admin");
            return "redirect:/";
        }
             
        req.getSession().invalidate();
        model.addAttribute("failLog", estLogge);
        return "user/login";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutGet(Model model, HttpServletRequest req) {
        req.getSession().invalidate();
        return "user/login";
    }

//    @RequestMapping(value = "/ajouterGet", method = RequestMethod.GET)
//    public String ajout
}
