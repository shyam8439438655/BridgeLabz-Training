import java.lang.reflect.*;

public class ModifyStaticField {

    static class Configuration {
        private static String API_KEY = "OLD_KEY_123";
        public static String getApiKey() { return API_KEY; }
    }

    public static void main(String[] args) throws Exception {

        System.out.println("Before: " + Configuration.getApiKey());

        Field f = Configuration.class.getDeclaredField("API_KEY");
        f.setAccessible(true);

        // for static fields, object is null
        f.set(null, "NEW_KEY_999");

        System.out.println("After: " + Configuration.getApiKey());
    }
}
