/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.MvnRecepcijaKlijent.forme;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaKlijent.component.table.model.RoomTableModel;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.konstante.Forme;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.*;
import java.awt.Dialog;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaKlijent.kontroler.Kontroler;

/**
 *
 * @author Win10
 */
public class SearchRoomForma extends javax.swing.JDialog {
    Window roditelj;

    /**
     * Creates new form SearchRoomForma
     */
    public SearchRoomForma(Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        prepareForm();
        popuniComboSobe();
        popuniTabelu();
    }
    
    public SearchRoomForma(Dialog parent, boolean modal, Window roditelj) {
        super(parent, modal);
        this.roditelj=roditelj;
        initComponents();
        //prepareForm
        //vrste = new ArrayList<>();
        popuniTabelu();
        popuniComboSobe();
        
    }

    public Window getRoditelj() {
        return roditelj;
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboRoomType = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jTxtRoomNumber = new javax.swing.JTextField();
        jBtnSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRooms = new javax.swing.JTable();
        jBtnAdd = new javax.swing.JButton();
        jBtnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Search criteria"));

        jLabel1.setText("Vrsta sobe:");

        jComboRoomType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Broj sobe:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboRoomType, 0, 99, Short.MAX_VALUE)
                    .addComponent(jTxtRoomNumber))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtRoomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jBtnSearch.setText("Search");
        jBtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSearchActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Result:"));

        jTableRooms.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableRooms);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
        );

        jBtnAdd.setText("Add");
        jBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddActionPerformed(evt);
            }
        });

        jBtnCancel.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jBtnCancel)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnAdd)
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jBtnSearch)
                                .addGap(8, 8, 8)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnSearch)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAdd)
                    .addComponent(jBtnCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSearchActionPerformed
        VrstaSobe vs = (VrstaSobe) jComboRoomType.getSelectedItem();
        String broj = jTxtRoomNumber.getText().trim();
        
        RoomTableModel rtm = (RoomTableModel) jTableRooms.getModel();
        
        List<String> columns = new ArrayList<>();
        List<String> values = new ArrayList<>();
        
        if(vs==null && broj.isEmpty()) {
            /*Request r = new Request();
            r.setOperation(Operacije.VRATI_SVE_SOBE);
            Komunikacija.getInstance().posaljiZahtev(r);*/
            Kontroler.getInstanca().vratiSveSobe();
            
            /*Response response = Komunikacija.getInstance().primiOdgovor();
            List<Soba> sobe = (List<Soba>) response.getResponse();
            rtm.setSobe(sobe);*/
            //PROVERI U KONTROLERU METODU POSTAVI
        }
        
        //prvi da bude null kao da nista nije izabrano
        if(vs!=null) {
            columns.add("vrstaSobeID");
            values.add(""+vs.getVrstaSobeID()+"");
        }
        if(!broj.isEmpty()) {
            columns.add("sobaID");
            values.add(""+broj+"");
        }
        
        /*Request r1 = new Request();
        r1.setOperation(Operacije.PRETRAZI_SOBE);
        r1.setParam(columns);
        r1.setParam2(values);
        Komunikacija.getInstance().posaljiZahtev(r1);*/
        Kontroler.getInstanca().pretraziSobe(columns,values);
        
        /*Response response1 = Komunikacija.getInstance().primiOdgovor();
        
        List<Soba> nadjeni = (List<Soba>) response1.getResponse();
        rtm.setSobe(nadjeni);*/
        
        //stavi kombo da bude prvi/null 
        VrstaSobe nista = null;
        jComboRoomType.setSelectedItem(nista);
        jTxtRoomNumber.setText("");
    }//GEN-LAST:event_jBtnSearchActionPerformed

    private void jBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddActionPerformed
        RoomTableModel rtm = (RoomTableModel) jTableRooms.getModel();
        List<Soba> sobe = rtm.getSobe();
        int red = jTableRooms.getSelectedRow();
        Soba s = sobe.get(red);
        ZakupForma rod =  (ZakupForma) getRoditelj();
        rod.setSoba(s);
        rod.stampajBrojSobe(s.getSobaID());
        //popuni combo sa uslugama
        //rod.stampajUsluge(s.getVrstaSobe().getUsluge());
        rod.stampajUsluge(s.getVrstaSobe());
    }//GEN-LAST:event_jBtnAddActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdd;
    private javax.swing.JButton jBtnCancel;
    private javax.swing.JButton jBtnSearch;
    private javax.swing.JComboBox jComboRoomType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRooms;
    private javax.swing.JTextField jTxtRoomNumber;
    // End of variables declaration//GEN-END:variables

    private void popuniComboSobe() {
        
        
        /*Request r = new Request();
        r.setOperation(Operacije.VRATI_SVE_VRSTE_SOBA);
        
        Komunikacija.getInstance().posaljiZahtev(r);*/
        
        Kontroler.getInstanca().vratiSveVrsteSoba(Forme.SEARCH_ROOM_FORMA);
        //ovo ide sve u kontroler
        /*Response response=Komunikacija.getInstance().primiOdgovor();
        List<VrstaSobe> vrste = (List<VrstaSobe>) response.getResponse();
        
        VrstaSobe nista = null;
        
        jComboRoomType.removeAllItems();
        jComboRoomType.addItem(nista);
        
        if(vrste==null) {
            System.out.println("NULL JEEE");
        }
        
        for (VrstaSobe vrstaSobe : vrste) {
            jComboRoomType.addItem(vrstaSobe);
        }*/
        
        //postaviVrste();
    }

    private void popuniTabelu() {
        /*Request r = new Request();
            r.setOperation(Operacije.VRATI_SVE_SOBE);
            Komunikacija.getInstance().posaljiZahtev(r);*/
        Kontroler.getInstanca().vratiSveSobe();
        
        /**    Response response = Komunikacija.getInstance().primiOdgovor();
            List<Soba> sobe = (List<Soba>) response.getResponse();
        RoomTableModel rtm = new RoomTableModel(sobe);
        jTableRooms.setModel(rtm);*/
        
    }

    public void postaviVrste(List<VrstaSobe> vrste) {
        VrstaSobe nista = null;
        
        jComboRoomType.removeAllItems();
        jComboRoomType.addItem(nista);
        
        
        
        for (VrstaSobe vrstaSobe : vrste) {
            jComboRoomType.addItem(vrstaSobe);
        }
    }

    public void postaviSobe(List<Soba> nadjeni) {
        RoomTableModel rtm = new RoomTableModel(nadjeni);
        
        jTableRooms.setModel(rtm);
    }

    public void prikaziPoruku(String poruka) {
        JOptionPane.showMessageDialog(this, poruka);
    }

    private void prepareForm() {
        setLocationRelativeTo(null);
    }
}