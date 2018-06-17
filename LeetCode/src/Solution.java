
import java.util.*;

/*
 [Input]

 5            // World size
 2            // Number of events
 1 1 1 40 60  // Event1, located at 1 1 with two tickets 40 and 60
 2 1 4 50     // Event2, located at 1 4 with 1 ticket at 50
 3            // 3 buyers
 3 3          // 1st buyer at 3 3
 3 2          // 2nd buyer at 3 2
 4 3          // 3rd buyer at 4 3


 [Output]
 2 50         // 1st buyer purchases a ticket for 50 from event2
 1 40
 1 60

 */

class Event implements Comparable<Event> {
    int eventId;
    int x;
    int y;
    List<Ticket> tickets;

    public Event(int eventId, int x, int y, List<Ticket> tickets) {
        this.tickets = new ArrayList<>();
        this.eventId = eventId;
        this.x = x;
        this.y = y;
        for(Ticket ticket : tickets) this.tickets.add(ticket);
    }

    public int compareTo(Event e) {
        Collections.sort(e.tickets);
        Collections.sort(this.tickets);
        if(this.tickets.get(0).price < e.tickets.get(0).price) return -1;
        if(this.tickets.get(0).price > e.tickets.get(0).price) return 1;
        else {
            if(this.eventId < e.eventId) return -1;
            if(this.eventId > e.eventId) return 1;
            return 0;
        }
    }

    public String toString() {
        return tickets.toString();
    }
}

class Ticket implements Comparable<Ticket>{
    int eventId;
    int price;

    public Ticket(int eventId, int price) {
        this.eventId = eventId;
        this.price = price;
    }

    public int compareTo(Ticket t) {
        if(this.price < t.price) return -1;
        if(this.price > t.price) return 1;
        return 0;
    }

    public String toString() {
        return Integer.toString(price);
    }
}


class Buyer {
    int x;
    int y;
    int id;
    int cost;
    public Buyer(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {

    static List<Event> eventList = new ArrayList<>();

    public int getDistance(Buyer b, Event e) {
        int x1 = b.x, y1 = b.y;
        int x2 = e.x, y2 = e.y;
        return Math.abs((x2 - x1) + (y2 - y1));
    }


    public List<Event> getClosestEvents(Buyer b) {
        TreeMap<Integer, List<Event>> map = new TreeMap<>();
        for(Event event : eventList) {
            int distance = getDistance(b, event);
            if(!map.containsKey(distance))
                map.put(distance, new ArrayList<>());
            map.get(distance).add(event);
        }
        return map.pollFirstEntry().getValue();
    }

    public void chooseEvent(Buyer b) {
        List<Event> closestEvents = getClosestEvents(b);
        Collections.sort(closestEvents);
        int id = closestEvents.get(0).eventId;
        int price = closestEvents.get(0).tickets.remove(0).price;
        if(closestEvents.get(0).tickets.size() == 0) {
            eventList.remove(closestEvents.get(0));
        }
        b.id = id;
        b.cost = price;
    }



    public static void main(String[] args) {
        String[] inputs = {"1 1 1 20 60", "2 3 1 20", "3 3 1 20 60 100"};
        List<Buyer> buyers = new ArrayList<>();
        for(String line : inputs) {
            StringTokenizer st = new StringTokenizer(line);
            int id = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            List<Ticket> tickets = new ArrayList<>();
            while(st.hasMoreTokens()) {
                Ticket ticket =
                        new Ticket(id, Integer.parseInt(st.nextToken()));
                tickets.add(ticket);
            }
            eventList.add(new Event(id, x, y, tickets));
        }

        String buyerInput[] = {"3 3", "3 2", "4 3"};
        for(String buyer : buyerInput) {
            StringTokenizer st = new StringTokenizer(buyer);
            buyers.add(
                    new Buyer(
                            Integer.parseInt(
                                    st.nextToken()),
                            Integer.parseInt(st.nextToken())));
        }

        Buyer b = buyers.get(0);
        Solution obj = new Solution();
        obj.chooseEvent(b);
        System.out.println(b.id + " " + b.cost);
        System.out.println(eventList);
        obj.chooseEvent(b);
        System.out.println(b.id + " " + b.cost);
        obj.chooseEvent(b);
        System.out.println(b.id + " " + b.cost);
    }
}
