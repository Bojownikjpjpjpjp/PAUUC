import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class FileWritter {
    public static PrintWriter writer;
    static {
        try {
            writer = new PrintWriter("lastGame.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    FileWritter() throws FileNotFoundException{    }
    public static void addToFile(String text){
        writer.println(text);
    }
    public static void shutUP(){
        writer.close();
    }
}
