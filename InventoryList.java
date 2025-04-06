class ItemNode {
    String itemName;
    int itemId;
    int quantity;
    double price;
    ItemNode next;

    ItemNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryList {
    ItemNode head;

    void addBegin(String itemName, int itemId, int quantity, double price) {
        ItemNode node = new ItemNode(itemName, itemId, quantity, price);
        node.next = head;
        head = node;
    }

    void addEnd(String itemName, int itemId, int quantity, double price) {
        ItemNode node = new ItemNode(itemName, itemId, quantity, price);
        if (head == null) {
            head = node;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = node;
    }

    void addAtPos(int pos, String itemName, int itemId, int quantity, double price) {
        if (pos == 0) {
            addBegin(itemName, itemId, quantity, price);
            return;
        }
        ItemNode temp = head;
        for (int i = 0; i < pos - 1 && temp != null; i++) temp = temp.next;
        if (temp != null) {
            ItemNode node = new ItemNode(itemName, itemId, quantity, price);
            node.next = temp.next;
            temp.next = node;
        }
    }

    void remove(int itemId) {
        if (head != null && head.itemId == itemId) {
            head = head.next;
            return;
        }
        ItemNode temp = head, prev = null;
        while (temp != null && temp.itemId != itemId) {
            prev = temp;
            temp = temp.next;
        }
        if (temp != null) prev.next = temp.next;
    }

    void updateQuantity(int itemId, int quantity) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = quantity;
                return;
            }
            temp = temp.next;
        }
    }

    void searchById(int itemId) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println(temp.itemName + " " + temp.itemId + " " + temp.quantity + " " + temp.price);
                return;
            }
            temp = temp.next;
        }
    }

    void searchByName(String name) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemName.equals(name)) {
                System.out.println(temp.itemName + " " + temp.itemId + " " + temp.quantity + " " + temp.price);
            }
            temp = temp.next;
        }
    }

    void totalValue() {
        double total = 0;
        ItemNode temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + total);
    }

    void display() {
        ItemNode temp = head;
        while (temp != null) {
            System.out.println(temp.itemName + " " + temp.itemId + " " + temp.quantity + " " + temp.price);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        InventoryList inv = new InventoryList();
        inv.addEnd("Pen", 101, 100, 2.5);
        inv.addBegin("Notebook", 102, 50, 10);
        inv.addAtPos(1, "Pencil", 103, 200, 1);
        inv.display();
        inv.updateQuantity(101, 150);
        System.out.println("After quantity update:");
        inv.display();
        inv.remove(102);
        System.out.println("After removal:");
        inv.display();
        inv.totalValue();
    }
}
