class BookNode {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    BookNode next, prev;

    BookNode(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = this.prev = null;
    }
}

class LibraryList {
    BookNode head, tail;

    void addBegin(String title, String author, String genre, int bookId, boolean isAvailable) {
        BookNode node = new BookNode(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    void addEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        BookNode node = new BookNode(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    void remove(int bookId) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                if (temp == head) head = temp.next;
                if (temp == tail) tail = temp.prev;
                if (temp.prev != null) temp.prev.next = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
                return;
            }
            temp = temp.next;
        }
    }

    void updateAvailability(int bookId, boolean isAvailable) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = isAvailable;
                return;
            }
            temp = temp.next;
        }
    }

    void displayForward() {
        BookNode temp = head;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.author + " " + temp.genre + " " + temp.bookId + " " + (temp.isAvailable ? "Available" : "Not Available"));
            temp = temp.next;
        }
    }

    void displayReverse() {
        BookNode temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.author + " " + temp.genre + " " + temp.bookId + " " + (temp.isAvailable ? "Available" : "Not Available"));
            temp = temp.prev;
        }
    }

    public static void main(String[] args) {
        LibraryList lib = new LibraryList();
        lib.addEnd("Harry Potter", "J.K. Rowling", "Fantasy", 101, true);
        lib.addBegin("To Kill a Mockingbird", "Harper Lee", "Fiction", 102, true);
        lib.displayForward();
        lib.updateAvailability(101, false);
        System.out.println("After updating availability:");
        lib.displayForward();
        lib.remove(102);
        System.out.println("After removing a book:");
        lib.displayForward();
    }
}
