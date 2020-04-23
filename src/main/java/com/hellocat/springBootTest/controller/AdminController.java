package com.hellocat.springBootTest.controller;

import com.hellocat.springBootTest.domen.Role;
import com.hellocat.springBootTest.domen.User;
import com.hellocat.springBootTest.service.RoleService;
import com.hellocat.springBootTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping
    public String showAdminPage(Model model) {
        List<User> users = userService.findAllUsers();
        List<Role> roles = roleService.findAllRoles();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByName(auth.getName());
        if (user == null) {
            return "redirect:/logout";
        }
        model.addAttribute("users", users)
                .addAttribute("roles", roles)
                .addAttribute("userNew", new User())
                .addAttribute("userAuth", user);
        return "admin/adminPage";
    }

    @PostMapping("/update")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") String id) {
        userService.deleteUser(Long.parseLong(id));
        return "redirect:/admin";
    }

    @PostMapping("/add")
    public String addUser(User user) {
        try {
            userService.saveUser(user);
        } catch (Exception e) {

        }
        return "redirect:";
    }
}
