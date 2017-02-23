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
    public static void main(String[] args)
    {
        String regex = "^(?<host>[^ ]*) [^ ]* (?<user>[^ ]*) \\[(?<time>[^\\]]*)\\] \"(?<method>\\S+)(?: +(?<path>[^ ]*) +\\S*)?\" (?<code>[^ ]*) (?<size>[^ ]*)(?: \"(?<referer>[^\\\"]*)\" \"(?<agent>[^\\\"]*)\")?$";
        Pattern pattern = Pattern.compile(regex);
        int match = 0;

        try (BufferedReader br = Files.newBufferedReader(Paths.get(args[0]), StandardCharsets.UTF_8)) {
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