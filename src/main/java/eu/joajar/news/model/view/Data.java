package eu.joajar.news.model.view;

import eu.joajar.news.service.NewsService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {

    private String content = NewsService.generatePath().toString();

}
