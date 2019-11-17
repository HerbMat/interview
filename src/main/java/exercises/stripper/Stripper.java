package exercises.stripper;

import java.util.regex.Pattern;

public class Stripper {

    private static final String HTML_TAG_REGEX = "<[^>]*>";

    private final Pattern htmlTagPattern;

    public Stripper() {
        htmlTagPattern = Pattern.compile(HTML_TAG_REGEX);
    }

    public String stripHtmlTags(String input) {
        if (input == null) {
            throw new IllegalArgumentException("html content cannot be null");
        }
        return htmlTagPattern
                .matcher(input)
                .replaceAll("");
    }
}
