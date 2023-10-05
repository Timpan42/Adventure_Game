package v_3;

import java.util.ArrayList;

public class Scene {
    int id = 0;
    String title;
    String text;
    ArrayList<Integer> nextId = new ArrayList<Integer>();

    public Scene(int id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<Integer> getNextId() {
        return nextId;
    }

    public void setNextId(Integer nextId) {
        this.nextId.add(nextId);
    }
}
