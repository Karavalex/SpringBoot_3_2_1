package net.springkata.springboot.controller;

import net.springkata.springboot.model.User;
import net.springkata.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping()
@EnableTransactionManagement
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String users(Model model) {
        model.addAttribute("getAllUsers" , userService.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String addUser(Model model) {
        model.addAttribute("user" , new User());
        return "new";
    }

    @DeleteMapping("/{id}")
    public String removeUser(@PathVariable("id") Integer id) {
        userService.removeUser(id);
        return "redirect:/";
    }

    @PatchMapping("/users/{id}")
    public String updateUser(@ModelAttribute("user") User user , @PathVariable("id") int id) {
        userService.updateUser(id , user);
        return "redirect:/";

    }

    @GetMapping("/edit/{id}")
    public String edit(Model model , @PathVariable("id") Integer id) {
        model.addAttribute("user" , userService.getUserById(id));
        return "/edit";
    }

  @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }


}
