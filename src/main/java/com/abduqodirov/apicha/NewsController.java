package com.abduqodirov.apicha;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class NewsController {

    private static final String template = "Salom, %s!";
    private final AtomicLong counter = new AtomicLong();

    ArrayList<Article> articles = new ArrayList<>();


    @GetMapping("/news")
    public List<Article> getNews() {


        return articles;
    }

    @GetMapping("/upload")
    public String uploadNews(
            @RequestParam(value = "title", defaultValue = "") String title,
            @RequestParam(value = "url", defaultValue = "") String url
    ) {

        articles.add(new Article(title, url));

        return "successfully added";
    }

    @PostMapping("/add")
    public Resultcha addArticle(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "url", required = false) String url
    ) {

        articles.add(new Article(title, url));


        return new Resultcha(200, "hammasi joyida");
    }


}
