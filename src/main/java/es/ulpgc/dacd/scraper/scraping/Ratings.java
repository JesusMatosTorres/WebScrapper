package es.ulpgc.dacd.scraper.scraping;

import java.io.IOException;

public interface Ratings {

    void getRatings(String href) throws IOException;
}
