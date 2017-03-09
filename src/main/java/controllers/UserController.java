package controllers;

import models.dao.UserDao;
import models.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.UserService;
import sun.awt.ModalExclude;

/**
 * Created by tatar on 06.03.17.
 */
@Controller
public class UserController {
    private static final String REDIRECT_TO_LIST = "redirect:/users/list";
    private  static final String USER_LIST_VIEW = "userList";
    private static final String USER_EDIT_VIEW = "userEdit";
    public static final int DEFAULT_SPLITTERS_PER_PAGE = 25;


    @Autowired
    private UserService userService;
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute(userService);

        return "/registration";
    }

    @RequestMapping(value="/registration", method = RequestMethod.POST)
    public String registration(Model model,
                               @RequestParam("login") String login,
                               @RequestParam("password") String password,
                               @RequestParam("last_name") String lastName,
                               @RequestParam("first_name") String firstName,
                               @RequestParam("email") String email,
                               @RequestParam("phone") String phone) {
        model.addAttribute("login", login);
        model.addAttribute("password", password);
        model.addAttribute("last_name", lastName);
        model.addAttribute("first_name", firstName);
        model.addAttribute("email", email);
        model.addAttribute("phone", phone);
        return "redirect:pages/registration.jsp";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String autorize(){
        return "redirect:pages/login.jsp";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String autorize(Model model,
                           @RequestParam("login") String param,
                           @RequestParam("password") String param2) {
        model.addAttribute("login", param);
        model.addAttribute("password", param2);

        return "redirect:pages/index.jsp";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "/login.jsp";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.POST)
    public String welcome(Model model) {
        return "welcome";
    }

}
