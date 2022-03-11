package com.company.util.feign;


import com.company.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "java-gutenberg-app")
public interface BookClient {

    @GetMapping("/search/{query}")
    public List<Book> getAllBooks(@PathVariable String query);
}
