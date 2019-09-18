package com.shequ.springboot.Controller;

import com.shequ.springboot.Dao.InsertUser;
import com.shequ.springboot.dto.AuccessDTO;
import com.shequ.springboot.dto.GitHubUser;
import com.shequ.springboot.Model.User;
import com.shequ.springboot.provider.gitHubtools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class oAuthController {

    @Autowired
    private gitHubtools githubtools;

    //从配置文件取值
    @Value("${github.Client_id}")
    private String Client_id;
    @Value("${github.Client_secret}")
    private String Client_secret;
    @Value("${github.Redirect_uri}")
    private String Redirect_uri;

    @Autowired
    private InsertUser insertUser;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name="state")String state,
                           HttpServletRequest request,
                           HttpServletResponse response){
        AuccessDTO auccessDTO = new AuccessDTO();
        auccessDTO.setCode(code);
        auccessDTO.setState(state);
        auccessDTO.setClient_id(Client_id);
        auccessDTO.setClient_secret(Client_secret);
        auccessDTO.setRedirect_uri(Redirect_uri);
        String accessToken = githubtools.getAccessToken(auccessDTO);
        GitHubUser gitHubUser = githubtools.getUser(accessToken);

//        HttpSession session = request.getSession();
//        session.setAttribute("user",gitHubUser);

        if(gitHubUser!=null){
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(gitHubUser.getName());
            user.setUserid(String.valueOf(gitHubUser.getId()));
            user.setCreattime(System.currentTimeMillis());
            user.setUpdatetime(System.currentTimeMillis());

            response.addCookie(new Cookie("token",token));
            //判断如果数据库中的的ID和要传入User的ID一致 就不能再次写入数据库
//            if( String.valueOf(gitHubUser.getId())!=(insertUser.findByUserName(user.getName()))) {
                insertUser.insertAccount(user);

            return "redirect:/";
        }else{
            return "redirect:/";
        }


    }

}
