package com.company.controller;

import com.company.model.Archive;
import com.company.model.Article;
import com.company.repository.ArchiveRepository;
import com.company.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ArchiveController.class)
public class ArchiveControllerTests{
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    ServiceLayer serviceLayer;
//    ArchiveRepository archiveRepository;

    private ObjectMapper mapper = new ObjectMapper();
    private Archive inputArchive;
    private Archive outputArchive;
    private Article article;
    private Set<Article> articleSet;
    private List<Archive> archiveList;

    @Before
    public void setUp() throws Exception {
        inputArchive = new Archive();
        inputArchive.setArchiveId(1);
        inputArchive.setArchiveName("software");

        article = new Article();
        article.setArchiveId(1);
        article.setLink("link to article");
        article.setTitle("title of article");
        articleSet = new HashSet<>();
        articleSet.add(article);
        inputArchive.setArticles(articleSet);

        outputArchive = new Archive();
        outputArchive.setArchiveId(1);
        outputArchive.setArchiveName("software");
        outputArchive.setArticles(articleSet);

        archiveList = new ArrayList<>();
        archiveList.add(inputArchive);

    }

    @Test
    public void createArchiveTest() throws Exception{
        String inputString = mapper.writeValueAsString(inputArchive);
        String outputString = mapper.writeValueAsString(outputArchive);

        when(serviceLayer.saveArchive(inputArchive)).thenReturn(outputArchive);

        mockMvc.perform(post("/archive")
                .content(inputString)
                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputString));
    }

    @Test
    public void findAllArchivesTest() throws Exception{
        String outputString = mapper.writeValueAsString(archiveList);
        when(serviceLayer.findAllArchives()).thenReturn(archiveList);
        mockMvc.perform(get("/archive")
                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputString));
    }

    @Test
    public void findArchiveByIdTest() throws Exception{
        String inputString = mapper.writeValueAsString(inputArchive);
        String outputString = mapper.writeValueAsString(outputArchive);

        when(serviceLayer.findArchive(inputArchive.getArchiveId())).thenReturn(outputArchive);

        mockMvc.perform(get("/archive/1")
                .content(inputString)
                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputString));
    }

    @Test
    public void updateArchiveByIdTest() throws Exception{
        String inputString = mapper.writeValueAsString(inputArchive);
        outputArchive.setArchiveName("changed");
        outputArchive.setArchiveId(2);
        String outputString = mapper.writeValueAsString(outputArchive);

        when(serviceLayer.findArchive(inputArchive.getArchiveId())).thenReturn(outputArchive);
        when(serviceLayer.updateArchive(inputArchive)).thenReturn(outputArchive);

        mockMvc.perform(put("/archive/1")
                        .content(inputString)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputString));
    }

    @Test
    public void deleteArchiveTest() throws Exception {
        String inputString = mapper.writeValueAsString(inputArchive);

        doNothing().when(serviceLayer).deleteArchive(inputArchive.getArchiveId());

        mockMvc.perform(delete("/archive/1")
                        .content(inputString)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }


}
