/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treeofdreams.apps.rfidmonitor;

import br.com.treeofdreams.apps.rfidmonitor.monitor.Monitor;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author csampaio
 */
public class RFIDMonitor extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Locale loc = new Locale("pt","BR");
        ResourceBundle bundle = ResourceBundle.getBundle("res.lang",loc);
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"), bundle);
        
        Scene scene = new Scene(root);        
        stage.setScene(scene);
        stage.setTitle(bundle.getString("title"));
        stage.show();
        stage.setOnCloseRequest(null);
    }   

    @Override
    public void stop() throws Exception {
        Monitor.getInstance().stopMonitor();
        super.stop(); //To change body of generated methods, choose Tools | Templates.
    }
    
    


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
