package com.shequ.springboot.Controller;

import com.shequ.springboot.Dao.InsertUser;
import com.shequ.springboot.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class myController {

    @Autowired
    private InsertUser insertUser;

    @GetMapping("/")
    public String toPages01(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = insertUser.findByToken(token);

                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                }
            }
        }

        return "index";
    }


}
