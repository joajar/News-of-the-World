package eu.joajar.news.controllers;

import eu.joajar.news.model.newsapi.News;
import eu.joajar.news.model.view.Data;
import eu.joajar.news.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static eu.joajar.news.service.NewsService.writeNewsToFileWithGivenPath;

@Controller
public class NewsController {

    private static final Logger LOG = LoggerFactory.getLogger(NewsController.class);

    @GetMapping("/data")
    public String getPath(Model model) {
        Data data = new Data();
        model.addAttribute("data", data);
        return "data";
    }

    @PostMapping("/data")
    public String downloadNews(@ModelAttribute Data data, Model model) {
        model.addAttribute("data", data);
        LOG.info("The following path is given: " + data.getContent());

        Path path = Paths.get(data.getContent());
        News news = new NewsService().getNews();
        try {
            writeNewsToFileWithGivenPath(path, news);
        } catch (IOException e) {
            return "erroroccurred";
        }
        return "final";
    }
}