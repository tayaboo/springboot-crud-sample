package com.yabubu.home.app.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TopControllerTest {

    private MockMvc mockMvc;

    @Autowired
    TopController topController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(topController).build();
    }

    /**
     * GETリクエストでリクエストすると200OKが返ってくる
     */
    @Test
    public void GETリクエストでリクエストすると200OKが返ってくる() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    /**
     * POSTリクエストでリクエストすると404が返ってくる
     */
    @Test
    public void POSTリクエストでリクエストすると404が返ってくる() throws Exception {
        mockMvc.perform(post("/"))
                .andExpect(status().isMethodNotAllowed());
    }

}