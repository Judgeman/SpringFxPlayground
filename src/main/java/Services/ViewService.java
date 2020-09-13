package Services;

import javafx.stage.Stage;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
public class ViewService {

    public static final String FILE_CSS = "/css/style.css";
    public static final String FILE_START = "/View/user.fxml";
    public static final String FILE_PRELOAD = "/View/Preload.fxml";

    public static final double START_WIDTH = 800;
    public static final double START_HEIGHT = 600;

    public static final double PRELOAD_WIDTH = 600;
    public static final double PRELOAD_HEIGHT = 400;

    public String filePath;

    public URL sendeUrl(String filePath){
        this.filePath = filePath;
        return getClass().getResource(filePath);
    }

    public void sendeCss(Stage stage){
        stage.getScene().getStylesheets().removeAll();
        stage.getScene().getStylesheets().add(getClass().getResource("css/style.css").toExternalForm());
    }

    public void ScenePosition(Stage stage){
        // Scene Position ???
    }
}
