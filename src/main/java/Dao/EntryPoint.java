package Dao;

import Services.UserService;
import com.sun.javafx.application.LauncherImpl;

/*
 * Created by Paul Richter on Wed 02/09/2020
 */
public class EntryPoint{

    private UserService userService;

    public static void main(String[] args) {

        LauncherImpl.launchApplication(StartApp.class, PreloadApp.class, args);

       //MysqlApp data = new MysqlApp();
        //data.H2Connect();
        //data.createTable();
    }

}
