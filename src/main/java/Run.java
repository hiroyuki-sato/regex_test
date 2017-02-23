import java.util.Locale;

class Run {
    public static void main(String[] args){
        String format = "^(?<host>[^ ]*) [^ ]* (?<user>[^ ]*) \\[(?<time>[^\\]]*)\\] \"(?<method>\\S+)(?: +(?<path>[^ ]*) +\\S*)?\" (?<code>[^ ]*) (?<size>[^ ]*)(?: \"(?<referer>[^\\\"]*)\" \"(?<agent>[^\\\"]*)\")?$";

        if( args.length < 2 ){
            System.out.println("Usage: $0 {joni|regex} file");
            System.exit(1);
        }


        long start = System.currentTimeMillis();

        String file = args[1];
        if( args[0].equals("joni") ){
            JoniTest joni = new JoniTest(file,format);
            joni.run();
        } else {
            RegexTest regex = new RegexTest(file,format);
            regex.run();
        }
        long est = System.currentTimeMillis() - start;

        System.out.println(String.format(Locale.ENGLISH,"Est: %d\n",est));
    }



}
