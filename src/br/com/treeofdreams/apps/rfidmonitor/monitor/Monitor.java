/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treeofdreams.apps.rfidmonitor.monitor;

import br.com.treeofdreams.apps.rfidmonitor.reader.RFIDReader;
import br.com.treeofdreams.apps.rfidmonitor.reader.IRFIDReader;
import br.com.treeofdreams.apps.rfidmonitor.reader.IRFIDReaderListener;
import javafx.application.Platform;
import javafx.collections.ObservableList;

/**
 * Classe responsável pelo monitoramento do leitor RFID
 * @author csampaio
 */
public class Monitor implements IRFIDReaderListener {
    private IRFIDReader rfidReader;
    private static Monitor instance;
    private ObservableList<String> output;
        
    private Monitor() {
        rfidReader = null;
        rfidReader = new RFIDReader();
    }
    
    public static Monitor getInstance() {
        if (instance == null) {
            instance = new Monitor();
        }
        return instance;
    }
    
    public void startMonitor(String ip) {
        if (!rfidReader.isConnected()) {
            rfidReader.connect(ip);
            rfidReader.startMonitor(this);
        }
    }
    
    public void stopMonitor() {
        if (rfidReader.isConnected()) {
            rfidReader.stopMonitor();
        }
    }

    @Override
    public void OnChangeStatus() {
        //TODO: mudar estado
    }

    @Override
    public void OnTagWasRead(String tag) {
       Platform.runLater( new Runnable() {

            @Override
            public void run() {
                output.add(tag);
            }
        });
        
    }

    @Override
    public void OnTagWasWritten() {
        // TODO: Tag escrita
    }

    public void setOutput(ObservableList<String> output) {
        this.output = output;
    }
    
    
    
    
}
