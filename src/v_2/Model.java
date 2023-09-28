package v_2;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Model {
    String file;
    Gson gson = new Gson();
    JsonObject[] arrObj;
    JsonElement id;
    String title;
    String text;
    JsonArray options;
    JsonObject optionsChose;
    String optionsChoseText;
    int optionsChoseNextId;


    // set the file in use
    public void setFile(String file){
        this.file = file;
    }

    // get Json data
    public void setJson(){
        try {
            this.arrObj = gson.fromJson(new FileReader(file), JsonObject[].class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //other to get the json data
    public JsonObject[] getJson(){
        return arrObj;
    }
    // set the id (view don't need)
    public void setId(int index){
        JsonObject[] obj = getJson();
        this.id = obj[index].get("id");
    }
    //other to get id
    public int getId(){
        return id.getAsInt();
    }

    // Set and get the title
    public String getSetTitle(){
        JsonObject[] obj = getJson();
        int id = getId();

        this.title = obj[id].get("title").getAsString();

        return title;
    }

    // Set and get the text
    public String getSetText(){
        JsonObject[] obj = getJson();
        int id = getId();

        this.text = obj[id].get("text").getAsString();

        return text;
    }

    // Set and get the options
    public JsonArray getSetOptions(){
        JsonObject[] obj = getJson();
        int id = getId();
        this.options = obj[id].get("options").getAsJsonArray();

        return options;
    }


    // Set the chose (view don't need)
    public void setOptionsChose(int index){
        this.optionsChose  = options.get(index).getAsJsonObject();
    }


    // Set and get the chose text
    public String getSetChoseText(){
        this.optionsChoseText  = optionsChose.get("text").getAsString();

        return optionsChoseText;
    }

    public int getSetOptionsChoseNextId (){
        this.optionsChoseNextId = optionsChose.get("nextId").getAsInt();

        return optionsChoseNextId;
    }


    // Set and get chose next id
}
