package es.ulpgc.dacd.scraper.scraping;

import org.jsoup.nodes.Element;

import java.io.IOException;

public interface Comments {

    void getComments(String href) throws IOException;
}
