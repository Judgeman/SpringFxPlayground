package Dao;

import Controllers.PreloadController;
import Services.ViewService;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;

public class PreloadApp extends Preloader {

    private Stage stage;
    private Parent root;

    public URL cssURL;
    public URL viewURL;
    public Scene scene;

    @Override
    public void init() throws Exception {
        viewURL = getClass().getResource(ViewService.FILE_PRELOAD);
        cssURL = getClass().getResource(ViewService.FILE_CSS);
        FXMLLoader loader = new FXMLLoader(viewURL);
        root = loader.load();
    }

    @Override
    public void start(Stage primaryStage) {
            this.stage = primaryStage;
            stage.initStyle(StageStyle.UNDECORATED);
            scene = new Scene(root, ViewService.PRELOAD_WIDTH, ViewService.PRELOAD_HEIGHT);
            scene.getStylesheets().add(cssURL.toExternalForm());
            stage.setScene(scene);
            stage.show();
    }

    // Loading + Prozente anzeige definieren (ausgegeben in PreloadController)
    @Override
    public void handleApplicationNotification(Preloader.PreloaderNotification info) {
        if (info instanceof ProgressNotification){
            PreloadController.label.setText( /*"Loading: "+*/ ((ProgressNotification) info).getProgress()*100 + "%");
            // ProgressBar (Load verlauf anzeigen)
           // System.out.println("@Value: " + ((ProgressNotification) info).getProgress());
            PreloadController.startProgress.setProgress(((ProgressNotification)info).getProgress());
        }
    }

    // Preload Fenster Schließen
    @Override
    public void handleStateChangeNotification(StateChangeNotification stateChangeNotification) {
        if(stateChangeNotification.getType() == StateChangeNotification.Type.BEFORE_START){
            stage.hide();
        }
    }


}
