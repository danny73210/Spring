package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    public UserService userService;

    //Model - its map data transfer between view and controller
    @GetMapping("/users")
    public String getAllUsers(Model model){
        //using this map we transfer user data from BD to template
        model.addAttribute("users", userService.findAll());
        return "usersList";
    }

    //for index.html
    @GetMapping("/")
    public String index(){
        return "index";
    }

    //serching with viewResolver for file hello and returning view file with name hello
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    //"/user/{id}" - url
    @GetMapping("/user/{id}")
    public String getById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "showUser";
    }

    @GetMapping("/addUser")
    public String createUserPage(){
        return "createUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/users";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user){
        userService.update(user);
        return "redirect:/user/" + user.getId();
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "editUser";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.delete(id);
        return "redirect:/users";
    }

}
