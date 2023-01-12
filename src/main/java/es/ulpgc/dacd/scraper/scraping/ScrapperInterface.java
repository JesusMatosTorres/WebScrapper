package es.ulpgc.dacd.scraper.scraping;

import java.io.IOException;

public interface ScrapperInterface {

    String returnHotelsName();

    String returnUbi(String name) throws IOException;

    String returnComments(String name) throws IOException;

    String returnRatings(String name) throws IOException;

    String returnServices(String name) throws IOException;
}
