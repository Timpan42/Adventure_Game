
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Iterator;

/*
 How to use Gson
 https://mkyong.com/java/how-to-parse-json-with-gson/
 https://howtodoinjava.com/gson/gson/
 */
public class Model {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        Object obj = gson.fromJson(new FileReader("src/name.json"), Object.class);

        System.out.println(obj);
    }
}
