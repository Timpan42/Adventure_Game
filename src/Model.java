
import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 How to use Gson
 https://mkyong.com/java/how-to-parse-json-with-gson/
 https://howtodoinjava.com/gson/gson/
 */
public class Model {
    String file;
    Gson gson = new Gson();
    JsonElement id;
    String title;
    String text;
    JsonArray options;
    JsonObject chose;
    String choseText;
    int choseNextId;

    public void startGame(){
        choseNextId = 0;
    }
    public void setFile(String file){
        this.file = file;
    }

    public String getFile(){
        return file;
    }

    public JsonObject[] getJson(){
        JsonObject[] arrObj;
        try {
             arrObj = gson.fromJson(new FileReader(file), JsonObject[].class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return arrObj;
    }

    public void setId(JsonObject[] arrObj){
        this.id = arrObj[choseNextId].get("id");
    }
    public JsonElement getId(){
        return id;
    }

    public void setTitle(JsonObject[] arrObj){
        this.title = arrObj[choseNextId].get("title").getAsString();
    }
    public String getTitle(){
        return title;
    }

    public void setText(JsonObject[] arrObj){
        this.text = arrObj[choseNextId].get("text").getAsString();
    }
    public String getText(){
        return text;
    }

    public void setOptions (JsonObject[] arrObj){
        options = arrObj[choseNextId].get("options").getAsJsonArray();
    }
    public JsonArray getOptions(){
        return options;
    }

    public void setChose(int index){
        chose  = options.get(index).getAsJsonObject();
    }
    public JsonElement getChose(){
        return chose;
    }

    public void setChoseText(){
        choseText  = chose.get("text").getAsString();
    }
    public String getChoseText(){
        return choseText;
    }

    public void setChoseNextId(){
        choseNextId  = chose.get("nextId").getAsInt();
    }
    public int getChoseNextId(){
        return choseNextId;
    }

    public void setITO(){
        JsonObject[] arrObj = getJson();
        setId(arrObj);
        setTitle(arrObj);
        setText(arrObj);
        setOptions(arrObj);
    }

    public void printJson(){
        System.out.println("Id: " + id);
        System.out.println("Title: " + title);
        System.out.println("Options: " + options);
        System.out.println("Chose: " + chose);
        System.out.println("Chose text: " + choseText);
        System.out.println("Chose next id: " + choseNextId);

    }

/*    public static void main(String[] args) throws IOException {
        Model m = new Model();
        String testFile = "src/test.json";
        String storyFile = "src/story.json";
        m.setFile(testFile);
        m.setJson();
        m.printJson();


    }*/
}
