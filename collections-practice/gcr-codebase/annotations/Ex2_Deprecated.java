public class Ex2_Deprecated {

    static class LegacyAPI {

        @Deprecated
        void oldFeature() {
            System.out.println("Old feature (deprecated) is running...");
        }

        void newFeature() {
            System.out.println("New feature is running...");
        }
    }

    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();

        // You will see a warning in IDE/compiler for oldFeature()
        api.oldFeature();
        api.newFeature();
    }
}
