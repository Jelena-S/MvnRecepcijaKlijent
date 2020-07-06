/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.MvnRecepcijaKlijent.niti;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.konstante.Operacije;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaKlijent.kontroler.Kontroler;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.transfer.*;

/**
 *
 * @author Win10
 */
public class PokretanjeKlijenta extends Thread{
    Socket soket;
    Kontroler kontroler;
    boolean kraj;

    public PokretanjeKlijenta() {
        kontroler = Kontroler.getInstanca();
        kraj = false;
    }

    @Override
    public void run() {
        poveziSE();
        
        while(!kraj) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                System.err.println("Prekinuta nit dok spava.");
            }
            
            System.out.println("Cekanje odgovora..");
            
            Odgovor response = primiOdgovor();
            
            if(response==null || response.getOperacija()==0) {
                System.out.println("Preskoci");
                continue;
            }
            
            switch(response.getOperacija()) {
                case Operacije.NADJI_RECEPCIONERA:
                    if(response.getOdgovor()==null) {
                        kontroler.porukaNeuspesnoPrijavljivanje("Sistem ne moze da nadje recepcionera po zadatim vrednostima");
                    } else {
                        kontroler.porukaUspesnoPrijavljivanje("Recepcioner je uspesno prijavljen");
                        Recepcioner r = (Recepcioner) response.getOdgovor();
                        kontroler.postaviRecepcionera(r);
                        kontroler.glavnaForma();
                    }
                    break;
                case Operacije.LOGOUT:
                    System.out.println("Server zaustavljen");
                    JOptionPane.showMessageDialog(null, "Dovidjenja");
                    System.out.println("Greska prilikom slanja zahteva");
                    System.exit(0);
                    break;
                case Operacije.KREIRAJ_GOSTA:
                    if(response.getOdgovor()==null) {
                        kontroler.porukaNeuspesnoGost("Sistem ne moze da zapamti gosta");
                    } else {
                        Gost g = (Gost) response.getOdgovor();
                        kontroler.postaviGosta(g);
                        kontroler.porukaUspesnoGost("Sistem je zapamtio gosta");
                        
                    }
                    break;
                case Operacije.IZMENI_GOSTA:
                    if((boolean)response.getOdgovor()) {
                        kontroler.porukaUspesnoGost("Sistem je izmenio gosta");
                    } else {
                        kontroler.porukaNeuspesnoGost("Sistem ne moze da izmeni gosta");
                    }
                    break;
                case Operacije.OBRISI_GOSTA:
                    if((boolean)response.getOdgovor()) {
                        kontroler.porukaUspesnoGost("Sistem je obrisao gosta");
                    } else {
                        kontroler.porukaNeuspesnoGost("Sistem ne moze da obrise gosta");
                    }
                    break;
                case Operacije.PRETRAZI_GOSTE:
                    if(response.getOdgovor()==null) {
                        kontroler.porukaNeuspesnoPretraziGoste("Sistem ne moze da nadje goste po zadatim vrednostima");
                    } else {
                        kontroler.porukaUspesnoPretraziGoste("Sistem je nasao goste po zadatim vrednostima");
                        List<Gost> nadjeni = (List<Gost>) response.getOdgovor();
                        kontroler.postaviGoste(nadjeni);
                    }
                    break;
                case Operacije.VRATI_SVE_GOSTE:
                    if(response.getOdgovor()==null) {
                        kontroler.porukaNeuspesnoPretraziGoste("Sistem ne moze da ucita goste");
                    } else {
                        
                        List<Gost> nadjeni = (List<Gost>) response.getOdgovor();
                        kontroler.postaviGoste(nadjeni);
                        kontroler.porukaUspesnoPretraziGoste("Sistem je ucitao sve goste");
                        System.out.println("PROCITAO SVE GOSTE");
                    }
                    break;
                case Operacije.PRETRAZI_SOBE: //u niti mi se vraca???????
                    if(response.getOdgovor()==null) {
                        kontroler.porukaNeuspesnoPretraziSobe("Sistem ne moze da nadje SOBE po zadatim vrednostima");
                    } else {
                        kontroler.porukaUspesnoPretraziSobe("Sistem je nasao SOBE po zadatim vrednostima");
                        List<Soba> nadjeni = (List<Soba>) response.getOdgovor();
                        kontroler.postaviSobe(nadjeni);
                    }
                    break;
                case Operacije.VRATI_SVE_SOBE:
                    if(response.getOdgovor()==null) {
                        kontroler.porukaNeuspesnoPretraziSobe("Sistem ne moze da nadje SOBE");
                    } else {
                        List<Soba> nadjeni = (List<Soba>) response.getOdgovor();
                        kontroler.postaviSobe(nadjeni);
                        kontroler.porukaUspesnoPretraziSobe("Sistem je nasao SOBE");
                    }
                    break;
                case Operacije.VRATI_SVE_VRSTE_SOBA:
                    if(response.getOdgovor()==null) {
                        kontroler.porukaNeuspesnoPretraziSobeZaVrste("Sistem ne moze da nadje VRSTE SOBA po zadatim vrednostima",Integer.parseInt(response.getPoruka()));
                    } else {
                        List<VrstaSobe> vrste = (List<VrstaSobe>) response.getOdgovor();
                        System.out.println("PROCITAO VRSTE: "+vrste.get(0).getVrstaSobeID());
                        
                        kontroler.postaviVrsteSoba(vrste, Integer.parseInt(response.getPoruka()));
                        kontroler.porukaUspesnoPretraziSobeZaVrste("Sistem je nasao VRSTE SOBE",Integer.parseInt(response.getPoruka()));
                    }
                    break;
                case Operacije.VRATI_ID:
                    long id = (long) response.getOdgovor();
                    kontroler.postaviIdZakupa(id);
                    //ispisi poruku
                    break;
                case Operacije.KREIRAJ_ZAKUP:
                    if(response.getOdgovor()==null) {
                        kontroler.porukaNeuspesnoZakup("Sistem ne moze da zapamti zakup");
                    } else {
                        kontroler.porukaUspesnoZakup("Sistem je zapamtio zakup");
                        ZakupSobe zs = (ZakupSobe) response.getOdgovor();//mozda prikazi
                        //kontroler.postaviGosta(g);
                    }
                    break;
                case Operacije.VRATI_SVE_ZAKUPE:
                    if(response.getOdgovor()==null) {
                        kontroler.porukaNeuspesnoPretraziZakupe("Sistem ne moze da nadje Zakupe");
                        System.out.println("Sistem ne moze da nadje ZAKUPE");
                    } else {
                        kontroler.porukaUspesnoPretraziZakupe("Sistem je nasao ZAKUPE");
                        System.out.println("Sistem je nasao ZAKUPE");
                        List<ZakupSobe> nadjeni = (List<ZakupSobe>) response.getOdgovor();
                        kontroler.postaviZakupe(nadjeni);
                    }
                    break;
                case Operacije.PRETRAZI_ZAKUPE:
                    if(response.getOdgovor()==null) {
                        kontroler.porukaNeuspesnoPretraziZakupe("Sistem ne moze da nadje ZAKUPE po zadatim vrednostima");
                        System.out.println("Sistem ne moze da nadje ZAKUPE po zadatim vrednostima");
                    } else {
                        kontroler.porukaUspesnoPretraziZakupe("Sistem je nasao ZAKUPE po zadatim vrednostima");
                        System.out.println("Sistem je nasao ZAKUPE po zadatim vrednostima");
                        List<ZakupSobe> nadjeni = (List<ZakupSobe>) response.getOdgovor();
                        kontroler.postaviZakupe(nadjeni);
                    }
                    break;
                case Operacije.VRATI_USLUGE_ZA_SOBU:
                    if(response.getOdgovor()==null) {
                        kontroler.porukaNeuspesnoZakup("Sistem ne moze da nadje usluge");
                        System.out.println("NIJE NASAO USLUGE");
                    } else {
                        kontroler.porukaUspesnoZakup("Sistem je nasao usluge");
                        List<UslugaNajma> nadjeni = (List<UslugaNajma>) response.getOdgovor();
                        kontroler.postaviUsluge(nadjeni);
                        System.out.println("POSTAVIO USLIGE");
                    }
                    break;
            }
        }
    }

    public Odgovor primiOdgovor() {
        Odgovor r = new Odgovor();
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(soket.getInputStream());
            r=(Odgovor) objectInputStream.readObject();
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, "Server nije aktivan.");
            System.exit(0);
        } catch (SocketException se) {
            //Logger.getLogger(PokretanjeKlijenta.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Server pao");
            
            JOptionPane.showMessageDialog(null, "Server nije dostupan.");
            System.exit(0);
        } catch (IOException ex) {
            //Logger.getLogger(PokretanjeKlijenta.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("Server pao");
            
            JOptionPane.showMessageDialog(null, "Uspesno ste se odjavili. Dovidjenja.");
            System.exit(0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PokretanjeKlijenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
    public void posaljiZahtev(Zahtev r) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(soket.getOutputStream());
            objectOutputStream.writeObject(r);
        } catch (IOException ex) {
            Logger.getLogger(PokretanjeKlijenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void poveziSE() {
        try {
            soket = new Socket("localhost", 9000);
            System.out.println("Pokretanje klijenta");
        } catch (IOException ex) {
            //Logger.getLogger(PokretanjeKlijenta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Server nije dostupan");
            
        }
    }
    
    
}
