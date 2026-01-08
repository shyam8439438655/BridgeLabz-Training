class TextState {
    String text;       
    TextState prev;     
    TextState next;    

    TextState(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    TextState head;    
    TextState tail;     
    TextState current;  
    int size = 0;
    int MAX_SIZE = 10; 

    // Add new text state
    void addState(String newText) {

        TextState newState = new TextState(newText);

        // If some redo history exists, remove it
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
        }

        if (head == null) {
            head = tail = current = newState;
            size = 1;
            return;
        }

        tail.next = newState;
        newState.prev = tail;
        tail = newState;
        current = newState;
        size++;

        // Limit history size
        if (size > MAX_SIZE) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo operation
    void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Nothing to undo");
            return;
        }
        current = current.prev;
        System.out.println("Undo done");
    }

    // Redo operation
    void redo() {
        if (current == null || current.next == null) {
            System.out.println("Nothing to redo");
            return;
        }
        current = current.next;
        System.out.println("Redo done");
    }

    // Display current text
    void displayCurrentText() {
        if (current == null) {
            System.out.println("Text editor is empty");
        } else {
            System.out.println("Current Text: " + current.text);
        }
    }

    // Display all history (optional – for understanding)
    void displayHistory() {
        TextState temp = head;
        System.out.println("Text History:");
        while (temp != null) {
            if (temp == current)
                System.out.println("-> " + temp.text + " (current)");
            else
                System.out.println("   " + temp.text);
            temp = temp.next;
        }
    }
}

public class RedoFunctionality {
    public static void main(String[] args) {

        TextEditor editor = new TextEditor();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.addState("Hello World!!");

        editor.displayCurrentText();

        editor.undo();
        editor.displayCurrentText();

        editor.undo();
        editor.displayCurrentText();

        editor.redo();
        editor.displayCurrentText();

        editor.addState("Hello Java");
        editor.displayCurrentText();

        editor.displayHistory();
    }
}
