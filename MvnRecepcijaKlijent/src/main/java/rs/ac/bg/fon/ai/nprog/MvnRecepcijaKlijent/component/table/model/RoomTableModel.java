/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.MvnRecepcijaKlijent.component.table.model;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.Soba;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Win10
 */
public class RoomTableModel extends AbstractTableModel{
    Soba soba;
    List<Soba> sobe;
    private String[] columnNames = new String[]{"ID","Status","Vrsta sobe"};

    public RoomTableModel() {
        sobe=new ArrayList<>();
    }

    public RoomTableModel(List<Soba> sobe) {
        this.sobe = sobe;
    }

    
    
    @Override
    public int getRowCount() {
        return sobe.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        Soba s = sobe.get(row);
        
        switch(column) {
            case 0: return s.getSobaID();
            case 1: return s.isStatus();
            case 2: return s.getVrstaSobe().getNazivVrsteSobe();
            default: return "greskicaaa";
        }
    }

    public List<Soba> getSobe() {
        return sobe;
    }

    public void setSobe(List<Soba> sobe) {
        this.sobe = sobe;
        fireTableDataChanged();
    }
    
    
}
