import com.google.gson.JsonArray;

import java.util.Scanner;

public class Controller {
    Model model;
    boolean gameIsRun;

    public void choses(Model model){
        JsonArray options = model.getOptions();
        for (int i = 0; i < options.size(); i++) {
            model.setChose(i);
            model.setChoseText();
            System.out.println("[" + i + "]" + " " + model.getChoseText());
        }
    }

    public void sendNextId(Model model, int nextId){
        model.setChose(nextId);
        model.setChoseNextId();
    }

    public void gamePlaying(Model model){
        if(model.getChoseNextId() < 0) {
            System.out.println("Game Over");
            gameIsRun = false;
        } else {
            model.setITO();
            System.out.println("Title: " + model.getTitle());

            choses(model);
        }
    }

    public void gamePlay(boolean state){
        gameIsRun = state;
    }

    public Controller(Model model, String file) {
        this.model = model;
        model.setFile(file);
        model.startGame();
    }



    public static void main(String[] args) {
        String testFile = "src/story.json";
        Model m = new Model();
        Controller c = new Controller(m, testFile);
        while (true){
            c.gamePlaying(m);
            Scanner sc = new Scanner(System.in);
            int nextId = sc.nextInt();
            c.sendNextId(m,nextId);

        }
    }
}
