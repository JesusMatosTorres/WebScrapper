package es.ulpgc.dacd.scraper.scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HotelsRating {
    public static void main(String[] args) throws IOException {
        String href="https://www.booking.com/hotel/es/nou-sant-antoni-sl.es.html?aid=397594&label=gog235jc-1FCAEoggI46AdIClgDaEaIAQGYAQq4ARfIAQzYAQHoAQH4AQKIAgGoAgO4ArqY45sGwAIB0gIkYzkxOWIxZGEtZDA3OC00MzEzLTkzYzUtNDk1YjJiMWFhMDNj2AIF4AIB&sid=3ad47ddc19a55ad679fee7ce9077eb3e&dest_id=1409;dest_type=region;dist=0;group_adults=2;group_children=0;hapos=2;hpos=2;no_rooms=1;req_adults=2;req_children=0;room1=A%2CA;sb_price_type=total;sr_order=popularity;srepoch=1669131651;srpvid=aaaa6e4121f4038e;type=total;ucfs=1&#tab-main";
        Document doc = Jsoup.connect(href).get();
        Elements id = doc.getElementsByClass("a1b3f50dcd b2fe1a41c3 a1f3ecff04 e187349485 d19ba76520");
        for (Element e : id) {
            System.out.println(e.getElementsByClass("b1e6dd8416 aacd9d0b0a").text());
            System.out.println(e.getElementsByClass("ee746850b6 b8eef6afe1").text());
        }
    }
}