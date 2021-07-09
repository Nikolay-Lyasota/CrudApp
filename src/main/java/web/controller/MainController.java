package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/users")
    public String allUsers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/user-add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-add";
    }

    @PostMapping("/user-add")
    public String addUser(User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user-delete/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

    @GetMapping("/user-edit/{id}")
    public String editUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user-edit";
    }

    @PostMapping("/user-edit")
    public String editUser(User user) {
        userService.editUser(user);
        return "redirect:/users";
    }

}



