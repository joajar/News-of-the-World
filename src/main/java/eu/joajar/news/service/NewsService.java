package eu.joajar.news.service;

import eu.joajar.news.model.newsapi.Article;
import eu.joajar.news.model.newsapi.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class NewsService {

    private static final String URL = "https://newsapi.org/v2/top-headlines?country=pl&category=business&apiKey=becd10196e954f0fa7a306aa502670d6";
    private static final Logger LOG = LoggerFactory.getLogger(NewsService.class);

    public News getNews() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(URL, News.class);
    }

    public static void writeNewsToFileWithGivenPath(Path path, News news) throws IOException {
        if (Files.exists(path)) {
            LOG.info("The following path is previously taken: " + path);
            throw new IOException();
        }

        try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            List<String> list = NewsService.convertNewsToStrings(news);
            for (String string : list) {
                writer.write(string);
            }
        }
    }

    public static Path generatePath() {
        return Paths.get("suggestedTxtFile.txt").toAbsolutePath();
    }

    public static List<String> convertNewsToStrings(News news) {
        List<String> list = new ArrayList<>();

        for (Article article : news.getArticles()) {
            StringBuilder sb = new StringBuilder();
            String auxiliaryString;

            if ((auxiliaryString = article.getTitle()) != null) {
                sb.append(auxiliaryString);
            }

            sb.append(":");

            if ((auxiliaryString = article.getDescription()) != null) {
                sb.append(auxiliaryString);
            }

            sb.append(":");

            if ((auxiliaryString = article.getAuthor()) != null) {
                sb.append(auxiliaryString);
            }

            sb.append("\n");
            list.add(sb.toString());
        }

        return list;
    }
}