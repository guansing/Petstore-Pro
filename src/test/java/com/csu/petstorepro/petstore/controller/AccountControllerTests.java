package com.csu.petstorepro.petstore.controller;

import com.csu.petstorepro.petstore.entity.Account;
import com.csu.petstorepro.petstore.entity.Cart;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountControllerTests {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;
    private MockHttpSession session;

    @Before
    public void setupMock()
    {
        //mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        mvc = MockMvcBuilders.webAppContextSetup(wac).addFilter(((request, response, chain) -> {
            response.setCharacterEncoding("UTF-8");
            chain.doFilter(request, response);
        })).build();
        session = new MockHttpSession();
        Account account=new Account();
        account.setUserid("2");
        session.setAttribute("account",account); //拦截器那边会判断用户是否登录，所以这里注入一个用户
    }

    @Test
    public void signIn() throws Exception
    {
        Map<String,String> map=new HashMap<>();
        map.put("userId","222");
        map.put("password","2223334");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);

        mvc.perform(MockMvcRequestBuilders.post("/signIn")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void signUp() throws Exception{
        Account account = new Account();

        account.setUserid("666");
        account.setEmail("666");
        account.setFirstname("777");
        account.setLastname("888");
        account.setStatus("OK");
        account.setAddr1("jjj");
        account.setAddr2("lll");
        account.setCity("Tokyo");
        account.setState("WWF");
        account.setZip("zero");
        account.setCountry("Japan");
        account.setPhone("1530080");

        account.setPassword("999");

        account.setLangpref("chinese");
        account.setFavcategory("fish");
        account.setMylistopt(2);
        account.setBanneropt(3);


        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(account);

        mvc.perform(MockMvcRequestBuilders.post("/signUp")
                .contentType(MediaType.APPLICATION_JSON)

                .content(json)
                .session(session))


                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void updateUserInfo() throws Exception{
        Account account = new Account();

        //账号不能更改
        account.setUserid("666");

        account.setEmail("666");
        account.setFirstname("777");
        account.setLastname("888");
        account.setStatus("OK");
        account.setAddr1("jjj2");
        account.setAddr2("lll2");
        account.setCity("Tokyo");
        account.setState("WWF");
        account.setZip("zero");
        account.setCountry("Japan");
        account.setPhone("1530080");

        //密码不能更改
        account.setPassword("999");

        account.setLangpref("chinese6");
        account.setFavcategory("fish");
        account.setMylistopt(2);
        account.setBanneropt(3);


        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(account);

        mvc.perform(MockMvcRequestBuilders.post("/updateUserInfo")
                .contentType(MediaType.APPLICATION_JSON)

                .content(json)
                .session(session))


                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getUserInfo() throws Exception
    {
        Account account = new Account();
        account.setUserid("222");
        account.setPassword("2223334");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(account);
        mvc.perform(MockMvcRequestBuilders.get("/getUserInfo")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json)
                .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void signOut() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.post("/signOut")
                .contentType(MediaType.APPLICATION_JSON)
                .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void checkUsername() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.get("/checkUsername?userId=22112")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
