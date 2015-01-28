/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treeofdreams.apps.rfidmonitor;

import br.com.treeofdreams.apps.rfidmonitor.monitor.Monitor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author csampaio
 */
public class MainController implements Initializable {
    @FXML
    private Button connectBtn;
    @FXML
    private Button readBtn;
    private ResourceBundle rb;
    private Monitor rfidMonitor = Monitor.getInstance();
    @FXML
    private ListView<String> outputList;
    @FXML
    private TextField readerIP;
    private final ObservableList tagsList = FXCollections.observableArrayList();
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.rb = rb;
        readerIP.setText("10.0.0.25");
        outputList.setItems(tagsList);
        rfidMonitor.setOutput(tagsList);
    }

    @FXML
    private void OnConnectClick(ActionEvent event) {
        rfidMonitor.startMonitor(readerIP.getText());
    }

    @FXML
    private void OnReadClick(ActionEvent event) {
        String btnTxt = rb.getString("start_read");
        if (readBtn.getText().equals(btnTxt)) {
            btnTxt = rb.getString("stop_read");
            rfidMonitor.stopMonitor();
        } else {
            rfidMonitor.stopMonitor();
        }
        readBtn.setText(btnTxt);
    }
        
    
}
