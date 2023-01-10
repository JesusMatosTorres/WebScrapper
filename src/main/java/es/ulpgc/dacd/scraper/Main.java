package es.ulpgc.dacd.scraper;


import es.ulpgc.dacd.scraper.scraping.HotelsInfor;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        HotelsInfor hotelsInfor = new HotelsInfor("https://www.booking.com/hotel/es/nou-sant-antoni-sl.es.html?aid=397594&label=gog235jc-1FCAEoggI46AdIClgDaEaIAQGYAQq4ARfIAQzYAQHoAQH4AQKIAgGoAgO4ArqY45sGwAIB0gIkYzkxOWIxZGEtZDA3OC00MzEzLTkzYzUtNDk1YjJiMWFhMDNj2AIF4AIB&sid=3ad47ddc19a55ad679fee7ce9077eb3e&dest_id=1409;dest_type=region;dist=0;group_adults=2;group_children=0;hapos=2;hpos=2;no_rooms=1;req_adults=2;req_children=0;room1=A%2CA;sb_price_type=total;sr_order=popularity;srepoch=1669131651;srpvid=aaaa6e4121f4038e;type=total;ucfs=1&#tab-main");
        hotelsInfor.getUbi();
    }
}