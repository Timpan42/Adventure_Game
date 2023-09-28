package v_2;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Scanner;

public class Controller {


    boolean gameIsRunning;



    public Controller(Model m, String file){
        m.setFile(file);
        m.setJson();
        startGame(m);
    }

    public void startGame(Model m){
        m.setId(0);
        gameIsRunning = true;
    }

    public void printText(Model m, Controller c) {
            System.out.println("Title: " + m.getSetTitle());
            System.out.println("Text: " + m.getSetText());
            printOptionCoses(m);
    }

    public void printOptionCoses(Model m){
        JsonArray options = m.getSetOptions();
        for (int i = 0; i < options.size(); i++) {
            m.setOptionsChose(i);
            m.getSetChoseText();
            System.out.println("[" + i + "]" + " " + m.getSetChoseText());
        }
    }

    public void sendNextId(Model m, int nextId){
        if (nextId < 0 || nextId > m.getSetOptions().size()){
            System.out.println("Wrong");
            m.setId(m.getId());
        } else {
            m.setOptionsChose(nextId);

            if (m.getSetOptionsChoseNextId() < 0) {
                System.out.println("Game Over");
                gameIsRunning = false;
            } else {
            m.setId(m.getSetOptionsChoseNextId());
                }
            }
    }


    public static void main(String[] args) {
        String file = "src/story.json";
        Model m = new Model();
        Controller c = new Controller(m, file);
        while (c.gameIsRunning){
            c.printText(m, c);
            Scanner sc = new Scanner(System.in);
            int nextId = sc.nextInt();
            c.sendNextId(m,nextId);
        }
    }
}
