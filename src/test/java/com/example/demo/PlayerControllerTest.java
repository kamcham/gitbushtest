package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.service.PlayerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.domain.Player;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class PlayerControllerTest{
    @Autowired
    private MockMvc mvc;

    @MockBean
    private PlayerService playerService;

    @Test
    public void testOK() throws Exception {
        when(this.playerService.findOne((long) 1)).thenReturn("Hello, PePeSe !");
        mvc.perform(get("/")).andExpect(status().isOk()).andExpect(content().string(containsString("Hello, PePeSe !")));
    }


        }