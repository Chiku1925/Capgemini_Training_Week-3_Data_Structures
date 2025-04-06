class StudentNode {
    int roll;
    String name;
    int age;
    String grade;
    StudentNode next;

    StudentNode(int roll, String name, int age, String grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentList {
    StudentNode head;

    void addBegin(int roll, String name, int age, String grade) {
        StudentNode node = new StudentNode(roll, name, age, grade);
        node.next = head;
        head = node;
    }

    void addEnd(int roll, String name, int age, String grade) {
        StudentNode node = new StudentNode(roll, name, age, grade);
        if (head == null) {
            head = node;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = node;
    }

    void addAtPos(int pos, int roll, String name, int age, String grade) {
        if (pos == 0) {
            addBegin(roll, name, age, grade);
            return;
        }
        StudentNode temp = head;
        for (int i = 0; i < pos - 1 && temp != null; i++) temp = temp.next;
        if (temp != null) {
            StudentNode node = new StudentNode(roll, name, age, grade);
            node.next = temp.next;
            temp.next = node;
        }
    }

    void delete(int roll) {
        if (head != null && head.roll == roll) {
            head = head.next;
            return;
        }
        StudentNode temp = head, prev = null;
        while (temp != null && temp.roll != roll) {
            prev = temp;
            temp = temp.next;
        }
        if (temp != null) prev.next = temp.next;
    }

    StudentNode search(int roll) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.roll == roll) return temp;
            temp = temp.next;
        }
        return null;
    }

    void updateGrade(int roll, String grade) {
        StudentNode node = search(roll);
        if (node != null) node.grade = grade;
    }

    void display() {
        StudentNode temp = head;
        while (temp != null) {
            System.out.println(temp.roll + " " + temp.name + " " + temp.age + " " + temp.grade);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        StudentList sl = new StudentList();
        sl.addEnd(1, "Ram", 20, "A");
        sl.addBegin(2, "Om", 21, "B");
        sl.addAtPos(1, 3, "Krishna", 22, "C");
        sl.display();
        sl.updateGrade(3, "A+");
        System.out.println("After grade update:");
        sl.display();
        sl.delete(2);
        System.out.println("After deletion:");
        sl.display();
    }
}
