package es.ulpgc.dacd.scraper.scraping;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BookingScrapperController {

    public Map<String, String> mapNames;
    public Map<String, String> mapInfor = new HashMap<>();
    Gson gson = new Gson();

    public BookingScrapperController(String html) throws IOException {
        HotelsName names = new HotelsName(html);
        this.mapNames = names.getHotelsName();

    }

    public String returnHotelsName() {
        String names = gson.toJson(mapNames.keySet());
        return names;
    }

    public String returnAllStats(String name) throws IOException {
        String url = mapNames.get(name);
        HotelsInfor hotelsInfor = new HotelsInfor(url);
        mapInfor.put("Ubi", hotelsInfor.getUbi());
        mapInfor.put("Comments", hotelsInfor.getComments());
        mapInfor.put("Ratings", hotelsInfor.getRatings());
        mapInfor.put("Services", hotelsInfor.getServices());
        return gson.toJson(mapInfor);
    }



}

