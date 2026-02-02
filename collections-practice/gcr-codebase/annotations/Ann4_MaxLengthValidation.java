import java.lang.annotation.*;
import java.lang.reflect.*;

public class Ann4_MaxLengthValidation {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface MaxLength {
        int value();
    }

    static class User {
        @MaxLength(8)
        private String username;

        User(String username) {
            validate(username);
            this.username = username;
        }

        private void validate(String value) {
            try {
                Field f = User.class.getDeclaredField("username");
                MaxLength ml = f.getAnnotation(MaxLength.class);

                if (ml != null && value != null && value.length() > ml.value()) {
                    throw new IllegalArgumentException("username max length is " + ml.value());
                }
            } catch (NoSuchFieldException e) {
                // ignore
            }
        }

        @Override
        public String toString() {
            return "User{username='" + username + "'}";
        }
    }

    public static void main(String[] args) {
        System.out.println(new User("rahul"));     // ok

        // This will throw exception
        System.out.println(new User("verylongname"));
    }
}
