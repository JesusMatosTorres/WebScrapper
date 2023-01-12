package es.ulpgc.dacd.scraper;

import es.ulpgc.dacd.scraper.API.Api;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String html = "https://www.booking.com/searchresults.es.html?label=gog235jc-1DCAEoggI46AdIClgDaEaIAQGYAQq4ARfIAQzYAQPoAQH4AQKIAgGoAgO4Ase-7psGwAIB0gIkYzQ2NTNiOWItOWQxYi00NzNjLWFiZDAtNDM3NmFiYjk5NDRi2AIE4AIB&sid=3ad47ddc19a55ad679fee7ce9077eb3e&aid=397594&ss=Menorca&ssne=Menorca&ssne_untouched=Menorca&lang=es&sb=1&src_elem=sb&src=searchresults&dest_id=1409&dest_type=region&group_adults=2&no_rooms=1&group_children=0&sb_travel_purpose=leisure&offset=";
        Api api = new Api(html);
    }
}