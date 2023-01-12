package es.ulpgc.dacd.scraper.scraping;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class BookingScrapperController implements ScrapperInterface{

    public Map<String, String> mapNames;
    public ArrayList<String> arrayInformation;
    Gson gson = new Gson();

    public BookingScrapperController(String html) throws IOException {
        HotelsName names = new HotelsName(html);
        this.mapNames = names.getHotelsName();
    }

    public String returnHotelsName() {
        return gson.toJson(mapNames.keySet());
    }

    public String returnUbi(String name) throws IOException {
        HotelsInfor hotelsInfor = new HotelsInfor(mapNames.get(name));
        ArrayList<String> strings = hotelsInfor.getUbi();
        return gson.toJson(strings);
    }

    public String returnComments(String name) throws IOException {
        HotelsInfor hotelsInfor = new HotelsInfor(mapNames.get(name));
        ArrayList<String> strings = hotelsInfor.getComments();
        return gson.toJson(strings);
    }

    public String returnRatings(String name) throws IOException {
        HotelsInfor hotelsInfor = new HotelsInfor(mapNames.get(name));
        ArrayList<String> strings = hotelsInfor.getRatings();
        return gson.toJson(strings);
    }

    public String returnServices(String name) throws IOException {
        HotelsInfor hotelsInfor = new HotelsInfor(mapNames.get(name));
        ArrayList<String> strings = hotelsInfor.getServices();
        return gson.toJson(strings);
    }

}

