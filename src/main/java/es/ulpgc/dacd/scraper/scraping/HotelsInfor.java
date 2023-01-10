package es.ulpgc.dacd.scraper.scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HotelsInfor implements Information{

    private Document doc;

    public HotelsInfor(String href) throws IOException {
        this.doc = Jsoup.connect(href).get();
    }

    @Override
    public void getComments() {
        Elements id3 = doc.getElementsByClass("db29ecfbe2 c688f151a2");
        for (Element e : id3) {
            System.out.println(e.text());
        }
    }

    @Override
    public void getRatings() {
        Elements id4 = doc.getElementsByClass("a1b3f50dcd b2fe1a41c3 a1f3ecff04 e187349485 d19ba76520");
        for (Element e : id4) {
            System.out.println(e.getElementsByClass("b1e6dd8416 aacd9d0b0a").text());
            System.out.println(e.getElementsByClass("ee746850b6 b8eef6afe1").text());
        }
    }

    @Override
    public void getServices() {
        Elements id2 = doc.getElementsByClass("bui-list__item bui-spacer--medium hotel-facilities-group__list-item");
        for (Element e : id2) {
            System.out.println(e.text());
        }
    }

    @Override
    public void getUbi() {
        Elements id = doc.getElementsByClass("\nhp_address_subtitle\njs-hp_address_subtitle\njq_tooltip\n");
        System.out.println(id.text());
    }
}
