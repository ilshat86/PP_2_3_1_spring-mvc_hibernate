package web.controller;

import hiber.model.User;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userServiceImp;

//    @Autowired
//    public UserController(UserServiceImp userServiceImp) {
//        this.userServiceImp = userServiceImp;
//    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userServiceImp.listUsers());
        return "user/index";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id") Long id) {
        User user = userServiceImp.getUser(id);
        model.addAttribute("user", user);
        return "user/show";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "user/new";
    }

    @PostMapping(value = "add")
    public String add(@ModelAttribute("user") User user) {
        userServiceImp.save(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}/edit")
    public String changeUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userServiceImp.getUser(id));
        return "user/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userServiceImp.update(id, user);
        return "redirect:/user";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userServiceImp.delete(id);
        return "redirect:/user";
    }
}
