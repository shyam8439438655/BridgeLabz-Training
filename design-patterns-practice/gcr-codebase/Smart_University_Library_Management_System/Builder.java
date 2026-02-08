package Smart_University_Library_Management_System;

import java.util.*;

// Builder
public class Builder {

    String title;
    List<String> authors;
    String edition;
    String genre;
    String publisher;

    private Builder(BookBuilder builder) {
        this.title = builder.title;
        this.authors = builder.authors;
        this.edition = builder.edition;
        this.genre = builder.genre;
        this.publisher = builder.publisher;
    }

    public static class BookBuilder {
        private String title;
        private List<String> authors;
        private String edition;
        private String genre;
        private String publisher;

        public BookBuilder(String title) {
            this.title = title;
        }

        public BookBuilder authors(List<String> authors) {
            this.authors = authors;
            return this;
        }

        public BookBuilder edition(String edition) {
            this.edition = edition;
            return this;
        }

        public BookBuilder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public BookBuilder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Builder build() {
            return new Builder(this);
        }
    }
}

