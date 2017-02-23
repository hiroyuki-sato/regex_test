import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegexTest
{
    private String file;
    private String format;
    public RegexTest(String file,String format){
        this.format = format;
        this.file = file;
    }

    public  void run()
    {
        Pattern pattern = Pattern.compile(format);
        int match = 0;

        try (BufferedReader br = Files.newBufferedReader(Paths.get(file), StandardCharsets.UTF_8)) {
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
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