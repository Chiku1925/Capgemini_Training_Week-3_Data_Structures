class ProcessNode {
    int processId;
    int burstTime;
    int priority;
    ProcessNode next;

    ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduling {
    ProcessNode head;
    int timeQuantum;

    RoundRobinScheduling(int timeQuantum) {
        this.timeQuantum = timeQuantum;
        this.head = null;
    }

    void addProcess(int processId, int burstTime, int priority) {
        ProcessNode node = new ProcessNode(processId, burstTime, priority);
        if (head == null) {
            head = node;
            node.next = head;
        } else {
            ProcessNode temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = node;
            node.next = head;
        }
    }

    void removeProcess(int processId) {
        if (head == null) return;
        ProcessNode temp = head, prev = null;
        while (temp != null) {
            if (temp.processId == processId) {
                if (prev != null) prev.next = temp.next;
                if (temp == head) head = temp.next;
                return;
            }
            prev = temp;
            temp = temp.next;
            if (temp == head) break;
        }
    }

    void schedule() {
        if (head == null) return;
        ProcessNode temp = head;
        while (temp != null) {
            System.out.println("Executing Process ID: " + temp.processId);
            temp.burstTime -= timeQuantum;
            if (temp.burstTime <= 0) removeProcess(temp.processId);
            temp = temp.next;
            if (temp == head) break;
        }
    }

    public static void main(String[] args) {
        RoundRobinScheduling rr = new RoundRobinScheduling(4);
        rr.addProcess(1, 10, 2);
        rr.addProcess(2, 5, 1);
        rr.addProcess(3, 7, 3);
        rr.schedule();
    }
}
