/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package midisearch;

import javax.swing.table.*;

/**
 *
 * @author takano
 */
public class SimpleResultsTableModel extends DefaultTableModel {
    private static final ColumnContext[] columnArray = {
        new ColumnContext("Rank",      Integer.class,  false),
        new ColumnContext("MIDI",      String.class,  false),
        new ColumnContext("Score",      String.class,  false)
//        new ColumnContext("Style",      String.class, false)
    };

    private int number = 0;
    public void addRow(SimpleResultsTableRow r) {
        // [add]
        Object[] obj = {r.getRank(), r.getName(), r.getMidiPath(),r.getStyle()};
        super.addRow(obj);
        number++;
    }
    public void removeAll() {
        int rownum = this.getRowCount();

        System.out.println(rownum);

        for (int i=rownum-1; i>-1; i--) {
            this.removeRow(i);
        }
        this.number = 0;

    }
    public boolean isCellEditable(int row, int col) {
        return columnArray[col].isEditable;
    }
    public Class getColumnClass(int modelIndex) {
        return columnArray[modelIndex].columnClass;
    }
    public int getColumnCount() {
        return columnArray.length;
    }
    public String getColumnName(int modelIndex) {
        return columnArray[modelIndex].columnName;
    }
    private static class ColumnContext {
        public final String  columnName;
        public final Class   columnClass;
        public final boolean isEditable;
        public ColumnContext(String columnName, Class columnClass, boolean isEditable) {
            this.columnName = columnName;
            this.columnClass = columnClass;
            this.isEditable = isEditable;
        }
    }
}
class SimpleResultsTableRow{
    private String name;
    private String midiPath;
    private Integer rank;
    private String style;
        public SimpleResultsTableRow(Integer rank, String name, String midiPath) {
//    public SimpleResultsTableRow(Integer rank, String name, String midiPath,String style) { // [add]
        this.name = name;
        this.midiPath = midiPath;
        this.rank = rank;
        this.style = style;
    }
    public void setRank() {
        this.rank = rank;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setMidiPath(String midiPath) {
        this.midiPath = midiPath;
    }
    
    public void setStyle(String style){
        this.style = style;
    }

    public Integer getRank() {
        return rank;
    }
    
    public String getName() {
        return name;
    }

    public String getMidiPath() {
        return midiPath;
    }
    
    public String getStyle(){
        return style;
    }
}
