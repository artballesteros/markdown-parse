import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void readFiles() throws IOException {
        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName);
        List links = List.of("https://something.com","some-page.html");
        assertEquals("check results", links, MarkdownParse.getLinks(contents));
    }

}
