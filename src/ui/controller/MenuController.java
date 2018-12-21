package ui.controller;

import javafx.scene.control.Button;
import main.Main;

public class MenuController {
    public static Button toogleContinueBtn(Button button){
        try {
            if(Main.session.getLastPlay() == null){
                button.setVisible(false);
                return button;
            };
        }catch ( Exception e){
            e.printStackTrace();
            System.out.println("Session/ Last play are not exist");
        }
        return  null;
    }
}
