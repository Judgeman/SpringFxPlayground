package Dao;

import Services.ViewService;
import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;


//@SpringBootApplication
public class StartApp  extends Application {

    private static final int countLimit = 40;
    private Exception exception;
    private Parent root;

    public URL viewURL;
    public URL cssURL;
    public Stage stage;
    public Scene scene;
    public StartApp() {
    }

    @Override
    public void init() throws Exception{

        try {
                viewURL = getClass().getResource(ViewService.FILE_START);
                cssURL = getClass().getResource(ViewService.FILE_CSS);
                FXMLLoader loader = new FXMLLoader(viewURL);
                root = loader.load();
        }catch (Exception ex){
                ex.printStackTrace();
                exception = ex;
                return;
        }

        // Prozent Zähler definieren(PreloadApp->ProgressNotification)
        for (int i = 1; i <= countLimit; i++){
                double progress = (double) i/40;
                //System.out.println("Progress: " +progress);
                LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(progress));
                Thread.sleep(100);
                //System.out.println(progress);
        }

    }

    @Override
    public void start(Stage primarySage) {
        if (exception != null){
            errorMessage(exception);
            return;
        }
        //  Parent parent = FXMLLoader.load(getClass().getResource("login.fxml"));
            this.stage = primarySage;
            stage.initStyle(StageStyle.UNDECORATED);
            scene = new Scene(root, ViewService.START_WIDTH, ViewService.START_HEIGHT);
            scene.getStylesheets().add(cssURL.toExternalForm());
            stage.setScene(scene);
            stage.show();

    }

    private void errorMessage(Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fehler bei startet");
            alert.setHeaderText("Error: bei Laden Application");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
    }

    @Override
    public void stop() throws Exception {
            super.stop();
    }
}
