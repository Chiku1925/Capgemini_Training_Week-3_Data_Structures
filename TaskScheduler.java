class TaskNode {
    int id;
    String name;
    int priority;
    String dueDate;
    TaskNode next;

    TaskNode(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
    }
}

class TaskScheduler {
    TaskNode head = null, tail = null, current = null;

    void addBegin(int id, String name, int priority, String dueDate) {
        TaskNode node = new TaskNode(id, name, priority, dueDate);
        if (head == null) {
            head = tail = node;
            node.next = head;
        } else {
            node.next = head;
            head = node;
            tail.next = head;
        }
    }

    void addEnd(int id, String name, int priority, String dueDate) {
        TaskNode node = new TaskNode(id, name, priority, dueDate);
        if (tail == null) {
            head = tail = node;
            node.next = head;
        } else {
            tail.next = node;
            node.next = head;
            tail = node;
        }
    }

    void addAtPos(int pos, int id, String name, int priority, String dueDate) {
        if (pos == 0) {
            addBegin(id, name, priority, dueDate);
            return;
        }
        TaskNode temp = head;
        for (int i = 0; i < pos - 1 && temp.next != head; i++) temp = temp.next;
        TaskNode node = new TaskNode(id, name, priority, dueDate);
        node.next = temp.next;
        temp.next = node;
        if (temp == tail) tail = node;
    }

    void remove(int id) {
        if (head == null) return;
        if (head.id == id) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            return;
        }
        TaskNode temp = head;
        while (temp.next != head && temp.next.id != id) temp = temp.next;
        if (temp.next.id == id) {
            if (temp.next == tail) tail = temp;
            temp.next = temp.next.next;
        }
    }

    void displayTasks() {
        if (head == null) return;
        TaskNode temp = head;
        do {
            System.out.println(temp.id + " " + temp.name + " " + temp.priority + " " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    void searchByPriority(int priority) {
        if (head == null) return;
        TaskNode temp = head;
        do {
            if (temp.priority == priority)
                System.out.println(temp.id + " " + temp.name + " " + temp.priority + " " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    void viewCurrentAndNext() {
        if (current == null) current = head;
        if (current != null) {
            System.out.println("Current Task: " + current.name);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();
        ts.addEnd(1, "Task1", 2, "2025-04-16");
        ts.addEnd(2, "Task2", 1, "2025-04-17");
        ts.addBegin(3, "Task3", 3, "2025-04-15");
        ts.displayTasks();
        ts.searchByPriority(1);
        ts.viewCurrentAndNext();
        ts.viewCurrentAndNext();
        ts.remove(2);
        System.out.println("After deletion:");
        ts.displayTasks();
    }
}
