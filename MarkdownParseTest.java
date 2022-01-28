import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
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
        List<String> links = List.of("https://something.com","some-page.html");
        assertEquals("check results", links, MarkdownParse.getLinks(contents));

        Path fileName2 = Path.of("test-file2.md");
        String contents2 = Files.readString(fileName2);
        List<String> links2 = List.of();
        assertEquals("check results of file 2", links2, MarkdownParse.getLinks(contents2));

        Path fileName3 = Path.of("test-file3.md");
        String contents3 = Files.readString(fileName3);
        List<String> links3 = List.of("www.edwin.com");
        assertEquals("check results of file 3", links3, MarkdownParse.getLinks(contents3));

        Path fileName4 = Path.of("test-file4.md");
        String contents4 = Files.readString(fileName4);
        List<String> links4 = List.of("https://CSE15L.com");
        assertEquals("check results of file 4", links4, MarkdownParse.getLinks(contents4));

        /*---------------------- Tests for new test files------------------------------*/

        // Shouldn't show any links
        Path fileName5 = Path.of("test-file5.md");
        String contents5 = Files.readString(fileName5);
        List<String> links5 = List.of();
        assertEquals("check results for file 5", links5, MarkdownParse.getLinks(contents5));

        // Should only show [page.com]
        Path fileName6 = Path.of("test-file6.md");
        String contents6 = Files.readString(fileName6);
        List<String> links6 = List.of("page.com");
        assertEquals("check results of file 6", links6, MarkdownParse.getLinks(contents6));

        // Shouldn't show any links
        Path fileName7 = Path.of("test-file7.md");
        String contents7 = Files.readString(fileName7);
        List<String> links7 = List.of();
        assertEquals("check results of file 7", links7, MarkdownParse.getLinks(contents7));

        // Should show any links because the link doesn't
        // follow a URL format
        Path fileName8 = Path.of("test-file8.md");
        String contents8 = Files.readString(fileName8);
        List<String> links8 = List.of("a link on the first line");
        assertEquals("check results of file 8", links8, MarkdownParse.getLinks(contents8));
    }

}
