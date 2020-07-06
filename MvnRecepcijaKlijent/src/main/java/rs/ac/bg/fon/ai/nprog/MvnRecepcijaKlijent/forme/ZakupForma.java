/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.MvnRecepcijaKlijent.forme;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaKlijent.component.table.model.GuestTableModel;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaKlijent.kontroler.Kontroler;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaKlijent.sesija.Mapa;

/**
 *
 * @author Win10
 */
public class ZakupForma extends javax.swing.JDialog {

    private Soba soba;
    private long id;
    
    
    
    
    /**
     * Creates new form ZakupForma
     */
    public ZakupForma(java.awt.Frame parent, boolean modal, FormMode formMode) {
        super(parent, modal);
        initComponents();
        prepareForm(formMode);
        popuniTabelu();
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
        jLabel2 = new javax.swing.JLabel();
        jTxtGuest = new javax.swing.JTextField();
        jTxtRoom = new javax.swing.JTextField();
        jBtnSelectGuest = new javax.swing.JButton();
        jBtnSelectRoom = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTxtPrice = new javax.swing.JTextField();
        jTxtDatumOD = new javax.swing.JTextField();
        jTxtDatumDo = new javax.swing.JTextField();
        jCmbUsluge = new javax.swing.JComboBox();
        jBtnIzracunaj = new javax.swing.JButton();
        jBtnSave = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBtnAddGuest = new javax.swing.JButton();
        jBtnDeleteGuest = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTxtErrors = new javax.swing.JTextArea();
        jBtnDelete = new javax.swing.JButton();
        jBtnEnableChanges = new javax.swing.JButton();
        jBtnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Please enter information for booking..");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Information for booking"));

        jLabel1.setText("Guest:");

        jLabel2.setText("Room:");

        jBtnSelectGuest.setText("Select guest");
        jBtnSelectGuest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSelectGuestActionPerformed(evt);
            }
        });

        jBtnSelectRoom.setText("Select room");
        jBtnSelectRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSelectRoomActionPerformed(evt);
            }
        });

        jLabel3.setText("First day:");

        jLabel4.setText("Last day:");

        jLabel5.setText("Price:");

        jTxtPrice.setEditable(false);

        jBtnIzracunaj.setText("Izracunaj cenu");
        jBtnIzracunaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIzracunajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTxtGuest)
                    .addComponent(jTxtRoom)
                    .addComponent(jTxtPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(jTxtDatumOD)
                    .addComponent(jTxtDatumDo))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jBtnSelectGuest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnSelectRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnIzracunaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jCmbUsluge, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtGuest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSelectGuest))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSelectRoom))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtDatumOD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCmbUsluge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtDatumDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnIzracunaj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTxtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jBtnSave.setText("Save");
        jBtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSaveActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Guest list"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        jBtnAddGuest.setText("Add");
        jBtnAddGuest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddGuestActionPerformed(evt);
            }
        });

        jBtnDeleteGuest.setText("Delete");
        jBtnDeleteGuest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeleteGuestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnDeleteGuest)
                .addGap(18, 18, 18)
                .addComponent(jBtnAddGuest)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAddGuest)
                    .addComponent(jBtnDeleteGuest))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        JTxtErrors.setColumns(20);
        JTxtErrors.setRows(5);
        jScrollPane1.setViewportView(JTxtErrors);

        jBtnDelete.setText("Delete");

        jBtnEnableChanges.setText("Enable changes");

        jBtnUpdate.setText("Update");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(98, 98, 98)
                            .addComponent(jBtnDelete)
                            .addGap(18, 18, 18)
                            .addComponent(jBtnUpdate))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtnEnableChanges)
                            .addGap(18, 18, 18)
                            .addComponent(jBtnSave)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnUpdate)
                            .addComponent(jBtnDelete))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnSave)
                            .addComponent(jBtnEnableChanges)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSelectGuestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSelectGuestActionPerformed
        SearchGuestForma sgf =  new SearchGuestForma(null, true,FormMode.FORM_ADD,this);
        Kontroler.getInstanca().postaviPretraziGostaFormu(sgf);
        sgf.setVisible(true);
        
    }//GEN-LAST:event_jBtnSelectGuestActionPerformed

    private void jBtnSelectRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSelectRoomActionPerformed
        SearchRoomForma srf = new SearchRoomForma(null, true,this);
        Kontroler.getInstanca().postaviPretraziSobuFormu(srf);
        srf.setVisible(true);
        
    }//GEN-LAST:event_jBtnSelectRoomActionPerformed

    private void jBtnAddGuestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddGuestActionPerformed
        SearchGuestForma sgf =  new SearchGuestForma(null, true,FormMode.FORM_ADD,this);
        Kontroler.getInstanca().postaviPretraziGostaFormu(sgf);
        sgf.setVisible(true);
    }//GEN-LAST:event_jBtnAddGuestActionPerformed

    private void jBtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSaveActionPerformed
        GuestTableModel gtm = (GuestTableModel) jTable1.getModel();
        List<Gost> gosti = gtm.getGosti();
        
        String broj = jTxtRoom.getText().trim();
        String datOD = jTxtDatumOD.getText().trim();
        String datDO = jTxtDatumDo.getText().trim();
        String cena = jTxtPrice.getText().trim();
        
        if(broj.isEmpty() || datOD.isEmpty() || datDO.isEmpty() || cena.isEmpty() || gosti.isEmpty()) {
            JTxtErrors.setText("Sva polja su obavezna");
            JOptionPane.showMessageDialog(this, "Potrebno je uneti sva polja");
            return;
        }
        
        JTxtErrors.setText("");
        
        if(gosti.size() > soba.getVrstaSobe().getBrojKreveta()) {
            JOptionPane.showMessageDialog(this, "Broj gostiju koji se moze dodati za ovu vrstu usluge je: " + soba.getVrstaSobe().getBrojKreveta());
            return;
        }
        
        int brojSobe = Integer.parseInt(broj);
        
        List<String> columns = new ArrayList<>();
        List<String> values = new ArrayList<>();
        
        columns.add("sobaID");
        values.add(broj); //brojSobe bi trebalo, ali radi i ovako VALJDA
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date datumOd = new Date();
        Date datumDo = new Date();
        try {
            datumOd = sdf.parse(datOD);
            datumDo = sdf.parse(datDO);
        } catch (ParseException ex) {
            Logger.getLogger(ZakupForma.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("GRESKA SA DATUMIMA");
        }
        
        double cenaZakupa = Double.parseDouble(cena);
        
        Recepcioner recepcioner = Mapa.getInstanca().getReceptionist();
        
        //soba po broju
        /*Request r = new Request();
        r.setOperation(Operacije.PRETRAZI_SOBE);
        
        r.setParam(columns);
        r.setParam2(values);
        
        komunikacijasaserverom.Komunikacija.getInstance().posaljiZahtev(r);
        
        Response response = komunikacijasaserverom.Komunikacija.getInstance().primiOdgovor();
        Soba soba = ((ArrayList<Soba>) response.getResponse()).get(0);*/ //POSTAVLJENA SET METODOM
        
        /*Request r1 = new Request();
        r1.setOperation(Operacije.VRATI_ID);
        komunikacijasaserverom.Komunikacija.getInstance().posaljiZahtev(r1);
        Response response1 = komunikacijasaserverom.Komunikacija.getInstance().primiOdgovor();
        long ID =(long) response1.getResponse();*/
        
        Kontroler.getInstanca().vratiID();
        
        ZakupSobe zs = new ZakupSobe(null, soba, id, datumOd, datumDo, cenaZakupa, true, recepcioner);
        //nadjem ID preko max(zakupID)
        //radio je bez dvojke
        for (Gost gost : gosti) {
            /*Request r2 = new Request();
            zs.setGostZakupljuje(gost);
            r2.setOperation(Operacije.KREIRAJ_ZAKUP);
            r2.setParam(zs);
            komunikacijasaserverom.Komunikacija.getInstance().posaljiZahtev(r2);
            Response response2 = komunikacijasaserverom.Komunikacija.getInstance().primiOdgovor();*/
            //stavi na current, sta znam
            
            Kontroler.getInstanca().kreirajZakup(zs,gost);
        }
        
    }//GEN-LAST:event_jBtnSaveActionPerformed

    private void jBtnIzracunajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIzracunajActionPerformed
        //kontroler da sracuna
        //AKO NISU UNETI DATUMI ILI IZABRANA USLUGA
        
        String datOD = jTxtDatumOD.getText().trim();
        String datDO = jTxtDatumDo.getText().trim();
        UslugaNajma usluga = (UslugaNajma) jCmbUsluge.getSelectedItem();
        
        
        if(datOD.isEmpty() || datDO.isEmpty()) { //kako za uslugu
            JOptionPane.showMessageDialog(this, "Morate popuniti polja za oba datuma i izabrani uslugu");
            return;
        }
        
        double cena = Kontroler.getInstanca().izracunajCenu(datOD,datDO,usluga);
        
        jTxtPrice.setText(""+cena);
    }//GEN-LAST:event_jBtnIzracunajActionPerformed

    private void jBtnDeleteGuestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteGuestActionPerformed
        GuestTableModel gtm = (GuestTableModel) jTable1.getModel();
        List<Gost> gosti = gtm.getGosti();
        int red = jTable1.getSelectedRow();
        Gost g = gosti.get(red);
        gtm.obrisi(g);
    }//GEN-LAST:event_jBtnDeleteGuestActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea JTxtErrors;
    private javax.swing.JButton jBtnAddGuest;
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnDeleteGuest;
    private javax.swing.JButton jBtnEnableChanges;
    private javax.swing.JButton jBtnIzracunaj;
    private javax.swing.JButton jBtnSave;
    private javax.swing.JButton jBtnSelectGuest;
    private javax.swing.JButton jBtnSelectRoom;
    private javax.swing.JButton jBtnUpdate;
    private javax.swing.JComboBox jCmbUsluge;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtDatumDo;
    private javax.swing.JTextField jTxtDatumOD;
    private javax.swing.JTextField jTxtGuest;
    private javax.swing.JTextField jTxtPrice;
    private javax.swing.JTextField jTxtRoom;
    // End of variables declaration//GEN-END:variables

    private void prepareForm(FormMode formMode) {
        setLocationRelativeTo(null);
        //popuni sta treba
        if(formMode.equals(FormMode.FORM_ADD)) {
            //vidi ya polje ID
            JTxtErrors.setEnabled(false);
            
            jBtnDelete.setVisible(false);
            jBtnUpdate.setVisible(false);
            jBtnEnableChanges.setVisible(false);
        }
        
        if(formMode.equals(FormMode.FORM_VIEW)) {
            jBtnSave.setVisible(false);
            jBtnDelete.setVisible(false);
            jBtnUpdate.setVisible(false);
            jBtnEnableChanges.setVisible(true);
            
            //polja 
        }
        
        if(formMode.equals(FormMode.FORM_UPDATE)) {
        
        }
    }

    private void popuniTabelu() {
        GuestTableModel gtm = new GuestTableModel();
        jTable1.setModel(gtm);
    }
    
    public void dodajUTabelu(Gost g) {
        GuestTableModel gtm = (GuestTableModel) jTable1.getModel();
        if(gtm.sadrzi(g)) {
            JOptionPane.showMessageDialog(this, "Vec ste uneli tog gosta");
        } else {
            gtm.dodaj(g);
        }
    }
    
    public void stampajBrojSobe(long broj) {
        jTxtRoom.setText(""+broj);
    }

    public void stampajUsluge(List<UslugaNajma> usluge) {
        jCmbUsluge.removeAllItems();
        UslugaNajma nista = null;
        jCmbUsluge.addItem(nista);
        
        for (UslugaNajma uslugaNajma : usluge) {
            jCmbUsluge.addItem(uslugaNajma);
        }
    }
    
    void stampajUsluge(VrstaSobe vrsta) {
        jCmbUsluge.removeAllItems();
        UslugaNajma nista = null;
        jCmbUsluge.addItem(nista);
        
        List<UslugaNajma> usluge = new ArrayList<>();
        Kontroler.getInstanca().vratiUslugeZaVrstuSobe(vrsta);
        
        /*for (UslugaNajma uslugaNajma : usluge) {
            jCmbUsluge.addItem(uslugaNajma);
        }*/
    }

    public Soba getSoba() {
        return soba;
    }

    public void setSoba(Soba soba) {
        this.soba = soba;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public void prikaziPoruku(String poruka) {
        JOptionPane.showMessageDialog(this, poruka);
    }
    
    
}
