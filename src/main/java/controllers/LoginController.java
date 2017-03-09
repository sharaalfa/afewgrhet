package controllers;

import models.dao.UserDao;
import models.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.UserService;
import services.impl.UserServiceImpl;

/**
 * Created by tatar on 06.03.17.
 */
@Controller
public class LoginController {/*



    @Autowired
    private UserService userService;



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("Пожалуйста, авторизуйтесь!");
        return "login";
    }
    String login = req.getParameter("login");
    String password = req.getParameter("password");

    @RequestMapping(method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("userService") UserService userService) {
        if (userService != null && userService.authorize(login, password)!= null) {
            if (userService.authorize(login, password).equals("artur", "12345") {
                model.addAttribute("msg", "" + userService.authorize(login, password));
                return "success";
            } else {
                model.addAttribute("error", "Invalid Details");
                return "login";
            }
        } else {
            model.addAttribute("error", "Please enter Details");
            return "login";
        }
    }*/
}
