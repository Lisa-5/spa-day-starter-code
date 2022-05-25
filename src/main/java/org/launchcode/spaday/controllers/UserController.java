package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm(){
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify){
        model.addAttribute("user", user);
        if (!verify.equals(user.getPassword())) {
            model.addAttribute("error", "Passwords should match!");
            return "user/add";
        }
        UserData.addUser(user);
        model.addAttribute("users", UserData.getAll());
        return "user/index";

    }

    @GetMapping("detail/{userId}")
    public String displayEmailForm(Model model, @PathVariable Integer userId){
        model.addAttribute("user", UserData.getById(userId));
        return "user/detail";
    }

//    @PostMapping("email")
//    public String processEmailForm(Model model){
//        model.addAttribute("users", UserData.getAll());
//        return "user/detail";
//    }

}
