package v_3;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class SceneMaker {
    boolean runSceneMaker;

    LinkedList<Scene> sceneList = new LinkedList<Scene>();

    public void makeScene(int id, String title, String text, int amountOfNextId){
        Scene scene = new Scene(id,title,text);

        for (int i = 0; i < amountOfNextId; i++) {
            String index = Integer.toString(i);
            String nextIdS = JOptionPane.showInputDialog("Next number id for position: " + index);
            int nextId = Integer.parseInt(nextIdS);
            addNextId(scene, nextId);
        }
        addToSceneList(scene);
    }
    public void addNextId(Scene scene,int nextId){
        scene.setNextId(nextId);
    }
    public void addToSceneList(Scene scene){
        sceneList.add(scene);
    }
    public LinkedList<Scene> getSceneList(){
        return sceneList;
    }

    public static void main(String[] args) {
        Scene scene = new Scene(0,"Hello","World");
        Scene scene2 = new Scene(1,"Hello","Tim");
        Scene scene3 = new Scene(3,"Hello","Lukas");

        scene.setNextId(1);
        scene.setNextId(3);
        LinkedList<Scene> sceneList = new LinkedList<Scene>();

        sceneList.add(scene);
        sceneList.add(scene3);
        sceneList.add(scene2);

        ArrayList<Integer> nextIdList = sceneList.get(0).getNextId();
        int nextId = nextIdList.get(1);
        System.out.println(nextId + "" + "\n");
        for (int i = 0; i < sceneList.size(); i++) {
            if(nextId == sceneList.get(i).getId()){
                int id = sceneList.get(i).getId();
                String title = sceneList.get(i).getTitle();
                String text = sceneList.get(i).getText();
                System.out.println(id + "\n"
                        + title + "\n"
                        + text);
            } else {

            }
        }

    }
}
