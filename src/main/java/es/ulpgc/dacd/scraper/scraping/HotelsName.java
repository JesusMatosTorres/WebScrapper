package es.ulpgc.dacd.scraper.scraping;

import es.ulpgc.dacd.scraper.DataBase.DataBase;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.SQLException;

import static java.lang.Thread.sleep;

public class HotelsName implements Names{
    public HotelsName() throws IOException, InterruptedException, SQLException {
        String html = "https://www.booking.com/searchresults.es.html?label=gog235jc-1DCAEoggI46AdIClgDaEaIAQGYAQq4ARfIAQzYAQPoAQH4AQKIAgGoAgO4Ase-7psGwAIB0gIkYzQ2NTNiOWItOWQxYi00NzNjLWFiZDAtNDM3NmFiYjk5NDRi2AIE4AIB&sid=3ad47ddc19a55ad679fee7ce9077eb3e&aid=397594&ss=Menorca&ssne=Menorca&ssne_untouched=Menorca&lang=es&sb=1&src_elem=sb&src=searchresults&dest_id=1409&dest_type=region&group_adults=2&no_rooms=1&group_children=0&sb_travel_purpose=leisure&offset=";
        int page = 25;
        String url;
        DataBase db = new DataBase();
        db.createTable();
        for (int i = 0; i < 2; i++) {
            sleep(1000);
            page += 25;
            url = html + page;
            Document doc = Jsoup.connect(url).get();
            Elements id = doc.getElementsByClass("a4225678b2");
            for(Element e:id){
                db.insert_hotels(e.getElementsByClass("fcab3ed991 a23c043802").text(),
                        e.getElementsByTag("a").attr("href"));
            }
            sleep(1000);
        }
        //System.out.println(db.getUrl().toString());
    }

    @Override
    public void getHotelsName() {

    }
}
