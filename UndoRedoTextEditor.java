class TextStateNode {
    String state;
    TextStateNode next, prev;

    TextStateNode(String state) {
        this.state = state;
        this.next = this.prev = null;
    }
}

class UndoRedoTextEditor {
    TextStateNode currentState, head, tail;
    int maxHistorySize;

    UndoRedoTextEditor(int maxHistorySize) {
        this.maxHistorySize = maxHistorySize;
        this.currentState = this.head = this.tail = null;
    }

    void addState(String state) {
        TextStateNode newState = new TextStateNode(state);
        if (currentState != null) {
            currentState.next = newState;
            newState.prev = currentState;
            currentState = newState;
        } else {
            currentState = head = tail = newState;
        }
        if (getHistorySize() > maxHistorySize) {
            removeOldestState();
        }
    }

    int getHistorySize() {
        int size = 0;
        TextStateNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    void removeOldestState() {
        if (head != null) {
            head = head.next;
            if (head != null) head.prev = null;
        }
    }

    void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            System.out.println("Undo: " + currentState.state);
        }
    }

    void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            System.out.println("Redo: " + currentState.state);
        }
    }

    void displayCurrentState() {
        if (currentState != null) {
            System.out.println("Current State: " + currentState.state);
        }
    }

    public static void main(String[] args) {
        UndoRedoTextEditor editor = new UndoRedoTextEditor(5);
        editor.addState("State 1");
        editor.addState("State 2");
        editor.addState("State 3");
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.redo();
        editor.displayCurrentState();
    }
}
