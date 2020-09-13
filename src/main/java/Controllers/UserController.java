package Controllers;

import Services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class UserController {

    UserService userService;
    @FXML private Label LOGINTEXTLABEL;
    @FXML private TextField USERFIELD;
    @FXML private TextField PASSFIELD;
    @FXML private Button EINLOGGENBUTTON;
    @FXML private Button REGISTBUTTON;
    @FXML private Hyperlink LOGINABBRECHEN;
    @FXML private Hyperlink PASSVERGESSEN;


    public void einloggen(ActionEvent event) {
        System.out.println("Einloggen");
        String logname = USERFIELD.getText();
        String logpass = PASSFIELD.getText();
       // LOGINTEXTLABEL.setText("Name: " +logname+ "Pass: " +logpass);
    }

    public void registrieren() {
        LOGINTEXTLABEL.setText("Registrieren");
        if (!USERFIELD.getText().isBlank() && !PASSFIELD.getText().isBlank()){
                userService.userPrufen();
            LOGINTEXTLABEL.setText("Erfolgreich Registriert");
        }else{
            LOGINTEXTLABEL.setText("else");
        }
        //LOGINTEXTLABEL.setText("Unten");
    }

    public void abbrechen(ActionEvent event) {
        Stage stage = (Stage) LOGINABBRECHEN.getScene().getWindow();
        stage.close();
    }

    public void passrecovery(ActionEvent event) {
        System.out.println("Password Recovery");
    }

    public void userFehler(String text){
        LOGINTEXTLABEL.setText(text);
    }

}
