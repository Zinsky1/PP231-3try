package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImp;

@Controller
@RequestMapping("/users")
public class MainController {

    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/list")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.listUsers());

        return "users.html";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new.html";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);

        return "redirect:/users/list";
    }

    @GetMapping("/{id}")
    public String getUSer(@PathVariable("id") int id, Model model) {
        model.addAttribute("user" ,userService.getUser(id));
        return "get.html";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "update.html";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(user);
        return "redirect:/users/list";
    }




}
