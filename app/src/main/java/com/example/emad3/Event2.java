package com.example.emad3;

public class Event2 {

    String eventId;
    String name;
    String start;
    String end;
    String venue;

    public Event2(){

    }

    public Event2(String eventId, String name, String startdate, String enddate, String venue) {

        this.eventId = eventId;
        this.name = name;
        this.start = startdate;
        this.end = enddate;
        this.venue = venue;
    }

    public String getEventId() {
        return eventId;
    }

    public String getName() {
        return name;
    }

    public String getStartdate() {
        return start;
    }

    public String getEnddate() {
        return end;
    }

    public String getVenue() {
        return venue;
    }
}
