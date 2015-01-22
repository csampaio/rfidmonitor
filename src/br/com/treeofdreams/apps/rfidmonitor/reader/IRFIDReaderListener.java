/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treeofdreams.apps.rfidmonitor.reader;

/**
 *
 * @author csampaio
 */
public interface IRFIDReaderListener {
    
    /**
     * Método disparado quado o estado do Leitor é alterado
     */
    void OnChangeStatus();
    /**
     * Método disparado quando uma Tag RFID é Lida
     * @param tag
     */
    void OnTagWasRead(String tag);
    /**
     * Método disparado quando uma Tag RFID é escrita
     */
    void OnTagWasWritten();
    
}
