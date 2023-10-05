package v_3;

import java.util.ArrayList;
import java.util.LinkedList;

public class Model {
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
        System.out.println(nextId);
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
/*
        for (Scene value : sceneList) {
            int id = value.getId();
            String title = value.getTitle();
            String text = value.getText();
            ArrayList<Integer> nextId = value.getNextId();

            System.out.println(id + "\n"
                    + title + "\n"
                    + text + "\n"
                    + nextId + "\n");
        }*/

    }
}
