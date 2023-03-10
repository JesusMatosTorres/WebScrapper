package es.ulpgc.dacd.scraper.scraping;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class HotelsInfor implements Information{

    private final Document doc;
    Gson gson;

    public HotelsInfor(String href) throws IOException {
        this.doc = Jsoup.connect(href).userAgent("Chrome/5.0").get();
        gson = new Gson();
    }

    @Override
    public ArrayList<String> getComments() {
        ArrayList<String> comments = new ArrayList<>();
        Elements id3 = doc.getElementsByClass("db29ecfbe2 c688f151a2");
        for (Element e : id3) {
            comments.add(e.text().substring(1, e.text().length()-1));
        }
        return comments;
    }

    @Override
    public ArrayList<String> getRatings() {
        ArrayList<String> ratings = new ArrayList<>();
        Elements id4 = doc.getElementsByClass("a1b3f50dcd b2fe1a41c3 a1f3ecff04 e187349485 d19ba76520");
        for (Element e : id4) {
            ratings.add(e.getElementsByClass("b1e6dd8416 aacd9d0b0a").text() +
                    ": " + e.getElementsByClass("ee746850b6 b8eef6afe1").text());
        }
        return ratings;
    }

    @Override
    public ArrayList<String> getServices() {
        ArrayList<String> services = new ArrayList<>();
        Elements id2 = doc.getElementsByClass("bui-list__item bui-spacer--medium hotel-facilities-group__list-item");
        for (Element e : id2) {
            services.add(e.text());
        }
        return services;
    }

    @Override
    public ArrayList<String> getUbi() {
        ArrayList<String> objects = new ArrayList<>();
        Elements id = doc.getElementsByClass("\nhp_address_subtitle\njs-hp_address_subtitle\njq_tooltip\n");
        objects.add(id.text());
        return objects;
    }
}
