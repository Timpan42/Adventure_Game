package v_3;

import javax.swing.*;
import java.util.ArrayList;

public class Model {
    SceneMaker sm;
    private void printScenes(SceneMaker sm){
        for (Scene value : sm.getSceneList()) {
            int id = value.getId();
            String title = value.getTitle();
            String text = value.getText();
            ArrayList<Integer> nId = value.getNextId();

            System.out.println(id + "\n"
                    + title + "\n"
                    + text + "\n"
                    + nId + "\n");
        }
    }

    public static void main(String[] args) {
        Model m = new Model();
        SceneMaker sm = new SceneMaker();

        int id = Integer.parseInt(JOptionPane.showInputDialog("Your Id?"));
        String Title = JOptionPane.showInputDialog("Your Title");
        String text = JOptionPane.showInputDialog("Your Text");
        int amountOfNextId = Integer.parseInt(JOptionPane.showInputDialog("Amount of next Id?"));


        sm.makeScene(id,Title,text, amountOfNextId);
        System.out.println(sm.getSceneList());
        m.printScenes(sm);
    }
}
