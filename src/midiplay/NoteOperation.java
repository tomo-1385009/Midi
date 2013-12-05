/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package midisearch;

/**
 *
 * @author tomo
 */
public class NoteOperation {
    String type ="";
    Integer value = 0;
    String note = "";
    String nt_switch = "on";
    
    public NoteOperation(String type, Integer value, String note, String on) {
        this.type = type;
        this.value = value;
        this.note = note;
        this.nt_switch = on;
    }
    
            
    String getType () {
        return this.type;
    }
    Integer getValue(){
        return this.value;
    }
    String getnote(){
        return this.note;
    }
    String GetN_switch(){
        return this.nt_switch;
    }
}
