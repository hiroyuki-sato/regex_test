import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import org.jcodings.specific.UTF8Encoding;
import org.joni.Matcher;
import org.joni.NameEntry;
import org.joni.Option;
import org.joni.Regex;
import org.joni.Region;
class JoniTest
{
    private String file;
    private String format;
    public JoniTest(String file,String format){
        this.format = format;
        this.file = file;
    }

    public void run()
    {
        byte[] pattern = format.getBytes(StandardCharsets.UTF_8);
        Regex regexp = new Regex(pattern, 0, pattern.length, Option.NONE, UTF8Encoding.INSTANCE);

        int match = 0;

        try (BufferedReader br = Files.newBufferedReader(Paths.get(file), StandardCharsets.UTF_8)) {
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                byte[] line_bytes = line.getBytes(StandardCharsets.UTF_8);
                Matcher matcher = regexp.matcher(line_bytes);
                int result = matcher.search(0, line_bytes.length, Option.DEFAULT);
                if (result!=1) {
                    match++;
                }
            }
            System.out.println(String.format(Locale.ENGLISH,"match = %d\n",match));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}