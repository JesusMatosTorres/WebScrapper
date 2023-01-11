package es.ulpgc.dacd.scraper.scraping;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BookingScrapperController {

    public Map<String, String> mapNames;
    public Map<String, String> mapInfor = new HashMap<>();
    Gson gson = new Gson();

    public BookingScrapperController(String html) throws IOException {
        HotelsName names = new HotelsName(html);
        this.mapNames = names.getHotelsName();

    }

    public Set<String> returnHotelsName() {
        String names = gson.toJson(mapNames.keySet());
        return mapNames.keySet();
    }

    public String returnAllStats(String name) throws IOException {
        String url = mapNames.get(name);
        HotelsInfor hotelsInfor = new HotelsInfor(url);
        mapInfor.put("Ubi", gson.toJson(hotelsInfor.getUbi()));
        mapInfor.put("Comments", gson.toJson(hotelsInfor.getComments()));
        mapInfor.put("Ratings", gson.toJson(hotelsInfor.getRatings()));
        mapInfor.put("Services", gson.toJson(hotelsInfor.getServices()));
        return gson.toJson(mapInfor);
    }



}

