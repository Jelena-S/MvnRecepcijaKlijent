/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.MvnRecepcijaKlijent.forme;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaKlijent.component.table.model.GuestTableModel;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.Gost;
import java.util.ArrayList;
import java.util.List;
import java.awt.Frame;
import java.awt.Window;

import javax.swing.JOptionPane;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaKlijent.kontroler.Kontroler;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaKlijent.sesija.Mapa;

/**
 *
 * @author Win10
 */
public class SearchGuestForma extends javax.swing.JDialog {
    Window roditelj;
    
    /**
     * Creates new form SearchGuestForma
     */
    public SearchGuestForma(Frame parent, boolean modal, FormMode formMode) {
        super(parent, modal);
        
        initComponents();
        prepareForm(formMode);
        popuniTabelu(); 
    }

   
    public SearchGuestForma(Frame parent, boolean modal, FormMode formMode, Window roditelj) {
        super(parent, modal);
        this.roditelj=roditelj;
        
        initComponents();
        prepareForm(formMode);
        popuniTabelu(); 
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
        jTxtIDcardSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTxtNameSearch = new javax.swing.JTextField();
        jTxtLastNameSearch = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblGuests = new javax.swing.JTable();
        jBtnAdd = new javax.swing.JButton();
        jBtnCancel = new javax.swing.JButton();
        jBtnSearchGuest = new javax.swing.JButton();
        jBtnEnableChanges = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Search criteria"));

        jLabel1.setText("ID card:");

        jLabel2.setText("Name:");

        jLabel3.setText("Lastname:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(jTxtIDcardSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTxtLastNameSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jTxtNameSearch))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtIDcardSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtLastNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Result:"));

        jTblGuests.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTblGuests);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addContainerGap())
        );

        jBtnAdd.setText("Add");
        jBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddActionPerformed(evt);
            }
        });

        jBtnCancel.setText("Cancel");
        jBtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelActionPerformed(evt);
            }
        });

        jBtnSearchGuest.setText("Search");
        jBtnSearchGuest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSearchGuestActionPerformed(evt);
            }
        });

        jBtnEnableChanges.setText("Enable changes for selected guest");
        jBtnEnableChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEnableChangesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBtnSearchGuest)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBtnEnableChanges)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnAdd)
                        .addGap(35, 35, 35)
                        .addComponent(jBtnCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnSearchGuest)
                .addGap(24, 24, 24)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnCancel)
                    .addComponent(jBtnEnableChanges)
                    .addComponent(jBtnAdd))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnEnableChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEnableChangesActionPerformed
        GuestTableModel gtm = (GuestTableModel) jTblGuests.getModel();
        int red = jTblGuests.getSelectedRow();
        Gost g = gtm.getGosti().get(red);
        Mapa.getInstanca().setGuest(g);
        GuestForma gf = new GuestForma(null, true, FormMode.FORM_VIEW);
        Kontroler.getInstanca().postaviGostFormu(gf);
        gf.setVisible(true);
        //dispose();
    }//GEN-LAST:event_jBtnEnableChangesActionPerformed

    private void jBtnSearchGuestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSearchGuestActionPerformed
            String sidCard=jTxtIDcardSearch.getText().trim();
            String sname=jTxtNameSearch.getText().trim();
            String slastname=jTxtLastNameSearch.getText().trim();
            
            List<String> columns = new ArrayList<>();
            List<String> values = new ArrayList<>();
            
            GuestTableModel gtm = (GuestTableModel) jTblGuests.getModel();
            
            if(sidCard.isEmpty() && sname.isEmpty() && slastname.isEmpty()) {
                /*Request r = new Request();
                r.setOperation(Operacije.VRATI_SVE_GOSTE);
                Komunikacija.getInstance().posaljiZahtev(r);*/
                Kontroler.getInstanca().vratiSveGoste();
                //Response response = Komunikacija.getInstance().primiOdgovor();
                
                //ArrayList<Gost> gosti = (ArrayList<Gost>) response.getResponse();
                //gtm.setGosti(Mapa.getInstanca().getGuests());
                
            } else {
            
                if(!sidCard.isEmpty()) {
                    columns.add("brojLicneKarte");
                    values.add(sidCard);
                } 
                if(!sname.isEmpty()) {
                    columns.add("imeGosta");
                    values.add("'"+sname+"'");
                }
                if(!slastname.isEmpty()) {
                    columns.add("prezimeGosta");
                    values.add("'"+slastname+"'");
                }
            
            /*Request r1 = new Request();
            r1.setOperation(Operacije.PRETRAZI_GOSTE);
            r1.setParam(columns);
            r1.setParam2(values);
            Komunikacija.getInstance().posaljiZahtev(r1);*/
                Kontroler.getInstanca().pretraziGoste(columns, values);
            
            //Response response1 = Komunikacija.getInstance().primiOdgovor();
        
            //List<Gost> nadjeni = (List<Gost>) response1.getResponse();
            
            //gtm.setGosti(nadjeni);
            //gtm.setGosti(Mapa.getInstanca().getGuests());
            
                resetujPolja();
            }
            
            
    }//GEN-LAST:event_jBtnSearchGuestActionPerformed

    private void jBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddActionPerformed
        GuestTableModel gtm = (GuestTableModel) jTblGuests.getModel();
        List<Gost> gosti = gtm.getGosti();
        int red = jTblGuests.getSelectedRow();
        Gost g = gosti.get(red);
        ZakupForma rod =  (ZakupForma) getRoditelj();
        rod.dodajUTabelu(g);
        gtm.obrisi(g);//////////////////////////////////////////////
        
    }//GEN-LAST:event_jBtnAddActionPerformed

    private void jBtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdd;
    private javax.swing.JButton jBtnCancel;
    private javax.swing.JButton jBtnEnableChanges;
    private javax.swing.JButton jBtnSearchGuest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblGuests;
    private javax.swing.JTextField jTxtIDcardSearch;
    private javax.swing.JTextField jTxtLastNameSearch;
    private javax.swing.JTextField jTxtNameSearch;
    // End of variables declaration//GEN-END:variables

    private void popuniTabelu() {
        /*Request r = new Request();
        r.setOperation(Operacije.VRATI_SVE_GOSTE);
        Komunikacija.getInstance().posaljiZahtev(r);*/
        Kontroler.getInstanca().vratiSveGoste();
        
        //Response response = Komunikacija.getInstance().primiOdgovor();
                
        //ArrayList<Gost> gosti = (ArrayList<Gost>) response.getResponse();
        //GuestTableModel gtm = new GuestTableModel(gosti);
        /*GuestTableModel gtm = new GuestTableModel();
        gtm.setGosti(Mapa.getInstanca().getGuests());
        jTblGuests.setModel(gtm);*/
        //mora da se pristupi polju iz kontrolera
        
    }

    private void prepareForm(FormMode formMode) {
        setLocationRelativeTo(null);
        if(formMode.equals(FormMode.FORM_ADD)) {
            jBtnEnableChanges.setVisible(false);
        }
        
        if(formMode.equals(FormMode.FORM_UPDATE)) {
            jBtnAdd.setVisible(false);
        }
    }
    
    public void resetujPolja() {
        jTxtIDcardSearch.setText("");
        jTxtNameSearch.setText("");
        jTxtLastNameSearch.setText("");
    }

    public void prikaziPoruku(String poruka) {
        JOptionPane.showMessageDialog(this, poruka);
    }

    public void postaviGoste(List<Gost> gosti) {
        GuestTableModel gtm = new GuestTableModel(gosti);
        jTblGuests.setModel(gtm);
        System.out.println("postavio goste iz forme");
    }
}
