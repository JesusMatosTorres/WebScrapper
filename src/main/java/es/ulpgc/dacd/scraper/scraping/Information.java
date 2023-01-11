package es.ulpgc.dacd.scraper.scraping;

import java.util.ArrayList;

public interface Information {

    ArrayList<String> getComments();

    ArrayList<String> getRatings();

    ArrayList<String> getServices();

    ArrayList<String> getUbi();
}
