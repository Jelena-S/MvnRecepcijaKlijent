/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.MvnRecepcijaKlijent.component.table.model;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.Gost;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jelena Sreckovic
 */
public class GuestTableModel extends AbstractTableModel{
    Gost gost;
    List<Gost> gosti;
    private String[] columnNames = new String[]{"ID","Ime","Prezime","BrojLicneKarte"};//dodaj jos ako treba

    public GuestTableModel(List<Gost> gosti) {
        this.gosti = gosti;
    }

    public GuestTableModel() {
        gosti=new ArrayList<>();
    }
    
    

    @Override
    public int getRowCount() {
        return gosti.size();
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
        Gost g = gosti.get(row);
        
        switch(column) {
            case 0: return g.getGostID();
            case 1: return g.getImeGosta();
            case 2: return g.getPrezimeGosta();
            case 3: return g.getBrojLicneKarte();
            case 4: return g.getBrojTelefona();
            case 5: return g.getEmail();
            case 6: return g.getRecepcioner();
            default: return "greskicaa";
        }
    }

    public List<Gost> getGosti() {
        return gosti;
    }

    public void setGosti(List<Gost> gosti) {
        this.gosti = gosti;
        fireTableDataChanged();
    }

    public void dodaj(Gost g) {
        gosti.add(g);
        fireTableDataChanged();
    }

    public void obrisi(Gost g) {
        gosti.remove(g);
        fireTableDataChanged();
    }
    
    public boolean sadrzi(Gost g) {
        if(gosti.contains(g)) return true;
        return false;
    }
    
    
}
