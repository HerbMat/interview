package exercises.stripper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class StripperTest {

    private Stripper stripper = new Stripper();

    @DisplayName("It should strip all html tags successfully.")
    @Test
    public void stripHtmlTags() {
        String expectedOutput = "Hello World! This is test";
        String htmlContent = "<div><p>Hello</p> <span>World!</span> <b>This is test</b></div>";

        String result = stripper.stripHtmlTags(htmlContent);

        assertThat(result, equalTo(expectedOutput));
    }
}