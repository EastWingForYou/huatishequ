package com.shequ.springboot.Controller;

import com.shequ.springboot.dto.AuccessDTO;
import com.shequ.springboot.dto.GitHubUser;
import com.shequ.springboot.provider.gitHubtools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name="state")String state){
        AuccessDTO auccessDTO = new AuccessDTO();
        auccessDTO.setCode(code);
        auccessDTO.setState(state);
        auccessDTO.setClient_id(Client_id);
        auccessDTO.setClient_secret(Client_secret);
        auccessDTO.setRedirect_uri(Redirect_uri);
        String accessToken = githubtools.getAccessToken(auccessDTO);
        GitHubUser user = githubtools.getUser(accessToken);
        System.out.println(user.getName());

        return "index";
    }

}
