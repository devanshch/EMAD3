public class Event {

    String eventId;
    String name;
    String startdate;
    String enddate;
    String venue;
    public Event(){

    }

    public Event(String eventId, String name, String startdate, String enddate, String venue) {
        this.eventId = eventId;
        this.name = name;
        this.startdate = startdate;
        this.enddate = enddate;
        this.venue = venue;
    }

    public String getEventId() {
        return eventId;
    }

    public String getName() {
        return name;
    }

    public String getStartdate() {
        return startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public String getVenue() {
        return venue;
    }
}
