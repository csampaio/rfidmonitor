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
public interface IRFIDReader {
    /**
     * Conecta ao leitor de rfid
     * @param ip
     * @return true - requisição de conexão enviada para o leitor
     */
    boolean connect(String ip);
    
    /**
     * Inicia o monitoramento do leitor
     * @return 
     */
    boolean startMonitor(IRFIDReaderListener listner);
    
    /**
     * Para o monitoramento do leitor
     * @return 
     */
    boolean stopMonitor();
    
    /**
     * Retorna o estado da conexão com o leitor
     * @return 
     */
    boolean isConnected();
    
}
