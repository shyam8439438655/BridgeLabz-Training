import java.util.Stack;

// Node for Doubly Linked List
class Page {
    String url;
    Page prev;
    Page next;

    Page(String url) {
        this.url = url;
    }
}

// Browser Tab History
class BrowserTab {
    Page current;
    
    void visit(String url) {
        Page newPage = new Page(url);

        if (current != null) {
            current.next = newPage;
            newPage.prev = current;
        }

        current = newPage;
        System.out.println("Visited: " + url);
    }

    void back() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Back to: " + current.url);
        } else {
            System.out.println("No previous page");
        }
    }

    void forward() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Forward to: " + current.url);
        } else {
            System.out.println("No next page");
        }
    }

    String getCurrentPage() {
        return current != null ? current.url : "Empty Tab";
    }
}

public class BrowserBuddy {
    static Stack<BrowserTab> closedTabs = new Stack<>();

    public static void main(String[] args) {

        BrowserTab tab1 = new BrowserTab();

        tab1.visit("google.com");
        tab1.visit("youtube.com");
        tab1.visit("github.com");

        tab1.back();
        tab1.forward();

        closeTab(tab1);

        // restore tab
        BrowserTab restoredTab = reopenTab();
        System.out.println("Restored Tab Current Page: " +
                restoredTab.getCurrentPage());
    }

    // close tab
    static void closeTab(BrowserTab tab) {
        closedTabs.push(tab);
        System.out.println("Tab Closed");
    }

    // reopen tab
    static BrowserTab reopenTab() {
        if (!closedTabs.isEmpty()) {
            System.out.println("Tab Reopened");
            return closedTabs.pop();
        }
        System.out.println("No Closed Tabs");
        return new BrowserTab();
    }
}
