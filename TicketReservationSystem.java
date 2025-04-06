class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    TicketNode head;

    TicketReservationSystem() {
        head = null;
    }

    void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newTicket = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            newTicket.next = head;
        } else {
            TicketNode temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newTicket;
            newTicket.next = head;
        }
    }

    void removeTicket(int ticketId) {
        if (head == null) return;
        TicketNode temp = head, prev = null;
        while (temp != null) {
            if (temp.ticketId == ticketId) {
                if (prev != null) prev.next = temp.next;
                if (temp == head) head = temp.next;
                return;
            }
            prev = temp;
            temp = temp.next;
            if (temp == head) break;
        }
    }

    void displayTickets() {
        if (head == null) return;
        TicketNode temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        TicketReservationSystem ts = new TicketReservationSystem();
        ts.addTicket(1, "John Doe", "Avengers", "A1", "10:00 AM");
        ts.addTicket(2, "Jane Smith", "Titanic", "B2", "12:00 PM");
        ts.displayTickets();
        ts.removeTicket(1);
        ts.displayTickets();
    }
}
