/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.MvnRecepcijaKlijent.component.table.model;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.ZakupSobe;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Win10
 */
public class RentTableModel extends AbstractTableModel{
    ZakupSobe zakup;
    List<ZakupSobe> zakupi;
    private String[] columnNames = new String[]{"ID","BrojSobe","Gost","Datum od","Datum do"};

    public RentTableModel() {
        zakupi = new ArrayList<>();
    }

    public RentTableModel(List<ZakupSobe> zakupi) {
        this.zakupi = zakupi;
    }
    
    
    
    @Override
    public int getRowCount() {
        return zakupi.size();
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        ZakupSobe zakupSobe = zakupi.get(rowIndex);
        
        switch(columnIndex) {
            case 0: return zakupSobe.getZakupID();
            case 1: return zakupSobe.getZakupljenaSoba().getSobaID();
            case 2: return zakupSobe.getGostZakupljuje();
            case 3: return zakupSobe.getDatumOd();
            case 4: return zakupSobe.getDatumDo();
            default: return "greskicaa";
        }
    }

    public List<ZakupSobe> getZakupi() {
        return zakupi;
    }

    public void setZakupi(List<ZakupSobe> zakupi) {
        this.zakupi = zakupi;
        fireTableDataChanged();
    }
    
    
    
}
