class MovieNode {
    String title, director;
    int year;
    double rating;
    MovieNode next, prev;

    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}

class MovieList {
    MovieNode head, tail;

    void addBegin(String title, String director, int year, double rating) {
        MovieNode node = new MovieNode(title, director, year, rating);
        node.next = head;
        if (head != null) head.prev = node;
        else tail = node;
        head = node;
    }

    void addEnd(String title, String director, int year, double rating) {
        MovieNode node = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = node;
            return;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    void addAtPos(int pos, String title, String director, int year, double rating) {
        if (pos == 0) {
            addBegin(title, director, year, rating);
            return;
        }
        MovieNode temp = head;
        for (int i = 0; i < pos - 1 && temp != null; i++) temp = temp.next;
        if (temp != null) {
            MovieNode node = new MovieNode(title, director, year, rating);
            node.next = temp.next;
            node.prev = temp;
            if (temp.next != null) temp.next.prev = node;
            else tail = node;
            temp.next = node;
        }
    }

    void remove(String title) {
        MovieNode temp = head;
        while (temp != null && !temp.title.equals(title)) temp = temp.next;
        if (temp != null) {
            if (temp.prev != null) temp.prev.next = temp.next;
            else head = temp.next;
            if (temp.next != null) temp.next.prev = temp.prev;
            else tail = temp.prev;
        }
    }

    void searchByDirectorOrRating(String director, double rating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.director.equals(director) || temp.rating == rating) {
                System.out.println(temp.title + " " + temp.director + " " + temp.year + " " + temp.rating);
            }
            temp = temp.next;
        }
    }

    void updateRating(String title, double rating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = rating;
                return;
            }
            temp = temp.next;
        }
    }

    void displayForward() {
        MovieNode temp = head;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.director + " " + temp.year + " " + temp.rating);
            temp = temp.next;
        }
    }

    void displayReverse() {
        MovieNode temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.director + " " + temp.year + " " + temp.rating);
            temp = temp.prev;
        }
    }

    public static void main(String[] args) {
        MovieList ml = new MovieList();
        ml.addEnd("Inception", "Nolan", 2010, 9.0);
        ml.addBegin("Avatar", "Cameron", 2009, 8.5);
        ml.addAtPos(1, "Interstellar", "Nolan", 2014, 9.2);
        ml.displayForward();
        ml.updateRating("Interstellar", 9.5);
        System.out.println("After update:");
        ml.displayForward();
        ml.remove("Avatar");
        System.out.println("After deletion:");
        ml.displayReverse();
    }
}
