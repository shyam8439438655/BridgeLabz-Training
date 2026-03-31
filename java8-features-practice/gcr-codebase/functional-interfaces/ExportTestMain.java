interface ReportExporter {

    void export();

    default void exportToJSON() {
        System.out.println("Exporting report to JSON format");
    }
}

class CSVExporter implements ReportExporter {
    public void export() {
        System.out.println("Exporting report to CSV");
    }
}

class PDFExporter implements ReportExporter {
    public void export() {
        System.out.println("Exporting report to PDF");
    }
}

public class ExportTestMain {
    public static void main(String[] args) {

        ReportExporter r1 = new CSVExporter();
        ReportExporter r2 = new PDFExporter();

        r1.export();
        r1.exportToJSON();

        r2.export();
        r2.exportToJSON();
    }
}
