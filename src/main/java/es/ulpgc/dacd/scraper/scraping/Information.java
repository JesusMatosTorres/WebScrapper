package es.ulpgc.dacd.scraper.scraping;

import java.io.IOException;

public interface Information {

    void getComments(String href) throws IOException;

    void getRatings(String href) throws IOException;

    void getServices(String href) throws IOException;

    void getUbi(String href) throws IOException;
}
