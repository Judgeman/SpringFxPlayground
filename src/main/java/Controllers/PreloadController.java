package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import java.net.URL;
import java.util.ResourceBundle;


public class PreloadController implements Initializable {

    @FXML
    private Label PROZENT;
    public static Label label;
    @FXML
    private ProgressBar progressBar;
    public static ProgressBar startProgress;

    // Laden von methode: PreloadApp->handleApplicationNotification... und übergeben Label PROZENT
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label = PROZENT;
        startProgress = progressBar;
        //System.out.println(label);
    }
}
