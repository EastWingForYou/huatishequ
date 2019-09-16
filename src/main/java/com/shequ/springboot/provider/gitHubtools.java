package com.shequ.springboot.provider;


import com.alibaba.fastjson.JSON;
import com.shequ.springboot.dto.AuccessDTO;
import com.shequ.springboot.dto.GitHubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class gitHubtools {

    public String getAccessToken(AuccessDTO auccessDTO){

        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        //            JSON的toJSONString 方法 是将对象直接转成JSON文字
        RequestBody body = RequestBody.create(JSON.toJSONString(auccessDTO),mediaType);
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
//            因为返回的是这种形式：access_token=e72e16c7e42f292c6912e7710c838347ae178b4a&token_type=bearer
//            所以要进行字符串拆分：
            String str =  response.body().string();
            String Bigtoken = str.split("&")[0];
            String token = Bigtoken.split("=")[1];
            return token;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public GitHubUser getUser(String auccessToken){

        OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.github.com/user?access_token="+ auccessToken)
                    .build();
        try {
            Response response = client.newCall(request).execute();
            String  str = response.body().string();
//            JSON的parseObject 方法 是用这个str字符串转换成 后者的对象
            GitHubUser gitHubUser = JSON.parseObject(str, GitHubUser.class);
            return gitHubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
}
