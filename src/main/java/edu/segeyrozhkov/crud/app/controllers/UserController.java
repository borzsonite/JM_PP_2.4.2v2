package edu.segeyrozhkov.crud.app.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import edu.segeyrozhkov.crud.app.model.User;
import edu.segeyrozhkov.crud.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getHello() {
        return "hello";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("userList", userService.userList());
        model.addAttribute("title", "Add user");
        return "users";
    }

    @PostMapping("/user/add")
    public String addUser(@ModelAttribute("user") User user) {
        if(user.getId() == 0) {
            userService.addUser(user);
        } else {
            userService.updateUser(user);
        }
        return "redirect:/users";
    }

    @RequestMapping("/remove/{id}")
    String removeUser(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("userList", userService.userList());
        model.addAttribute("title", "Edit user");
        model.addAttribute("method", "PATCH");
        return "users";
    }

    @RequestMapping("/userdata/{id}")
    public String userData(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "userdata";
    }

}
