/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.MvnRecepcijaKlijent.kontroler;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.konstante.*;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.*;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaKlijent.forme.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaKlijent.niti.PokretanjeKlijenta;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaKlijent.sesija.Mapa;
import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.transfer.*;

/**
 *
 * @author Jelena Sreckovic
 */
public class Kontroler {
    private static Kontroler instanca;

    PokretanjeKlijenta pk;
    
    MainForma mainForma;
    LoginForma loginForma;
    GuestForma gostForma;
    SearchGuestForma pretraziGostaForma;
    SearchRoomForma pretraziSobuForma;
    ZakupForma zakupForma;
    SearchZakupForma pretraziZakupForma;
    
    public Kontroler() {
    }

    public static Kontroler getInstanca() {
        if(instanca==null) {
            instanca = new Kontroler();
        }
        return instanca;
    }
    
    public void poveziSE() {
        pk = new PokretanjeKlijenta();
        pk.start();
    }
    
    public void login(String username, String password) { 
        Recepcioner recepcioner = new Recepcioner();
        recepcioner.setKorisnickoIme(username);
        recepcioner.setLozinka(password);
        Zahtev r = new Zahtev(recepcioner, Operacije.NADJI_RECEPCIONERA);
        r.setParametar(recepcioner);
        pk.posaljiZahtev(r);
    }
    
    public void pokreni() {
        this.loginForma = new LoginForma();
        loginForma.setVisible(true);
    }
    public void porukaNeuspesnoPrijavljivanje(String poruka) {
        loginForma.prikaziPoruku(poruka);
        //return;
    }
    
    public void porukaUspesnoPrijavljivanje(String poruka) {
        loginForma.prikaziPoruku(poruka);
        
    }

    public void postaviRecepcionera(Recepcioner recepcioner) {
        Mapa.getInstanca().setReceptionist(recepcioner);
    }

    public void glavnaForma() {
        loginForma.dispose();
        mainForma = new MainForma();
        mainForma.setVisible(true);
    }
    
    
    public void gostForma(JFrame roditelj) {
      gostForma = new GuestForma(roditelj, true, FormMode.FORM_ADD);
      gostForma.setVisible(true);
    }
    
    public void postaviGostFormu(GuestForma gf) {
        gostForma = gf;
    }
    
    public void postaviPretraziSobuFormu(SearchRoomForma srf) {
        pretraziSobuForma = srf;
    }
    
    public void postaviPretraziGostaFormu(SearchGuestForma sgf) {
        pretraziGostaForma = sgf;
    }
    
    public void postaviZakupGormu(ZakupForma zf) {
        zakupForma = zf;
    }
    
    public void sacuvajGosta(Gost g) {
    	Zahtev r = new Zahtev();
        r.setOperacija(Operacije.KREIRAJ_GOSTA);
        r.setParametar(g);
        pk.posaljiZahtev(r);
    }
    
    public void porukaNeuspesnoGost(String poruka) {
        gostForma.prikaziPoruku(poruka);
        //return;
    }
    
    public void porukaUspesnoGost(String poruka) {
        gostForma.prikaziPoruku(poruka);
        
    }
    
    public void postaviGosta(Gost g) {
        Mapa.getInstanca().setGuest(g);
        System.out.println("POSTAVIO gosta" + g.getImeGosta());
    }
    
    public void izmeniGosta(Gost g) {
    	Zahtev r = new Zahtev();
        r.setParametar(g);
        r.setOperacija(Operacije.IZMENI_GOSTA);
        pk.posaljiZahtev(r);
    }
    
    public void obrisiGosta(Gost g) {
    	Zahtev r = new Zahtev();
        r.setParametar(g);
        r.setOperacija(Operacije.OBRISI_GOSTA);
        pk.posaljiZahtev(r);
    }
    
    public void pretraziGostForma(JFrame roditelj) {
      pretraziGostaForma = new SearchGuestForma(roditelj, true, FormMode.FORM_UPDATE);
      pretraziGostaForma.setVisible(true);
    }

    public void pretraziGoste(List<String> columns, List<String> values) {
    	Zahtev r = new Zahtev();
        r.setOperacija(Operacije.PRETRAZI_GOSTE);
        r.setParametar(columns);
        r.setParametar2(values);
        pk.posaljiZahtev(r);
    }
    
    public void porukaUspesnoPretraziGoste(String poruka) {
        pretraziGostaForma.prikaziPoruku(poruka);
    }
    
    public void porukaNeuspesnoPretraziGoste(String poruka) {
        pretraziGostaForma.prikaziPoruku(poruka);
    }
    
    public void postaviGoste(List<Gost> gosti) {
 
        pretraziGostaForma.postaviGoste(gosti);
    }
    
    public void vratiSveGoste() {
    	Zahtev r = new Zahtev();
        r.setOperacija(Operacije.VRATI_SVE_GOSTE);
        
        pk.posaljiZahtev(r);
    }
    
    public void pretraziSobe(List<String> columns, List<String> values) { 
    	Zahtev r = new Zahtev();
        r.setOperacija(Operacije.PRETRAZI_SOBE);
        
        r.setParametar(columns);
        r.setParametar2(values);
        pk.posaljiZahtev(r);
;
    }
    
    public void vratiSveSobe() {
    	Zahtev r = new Zahtev();
        r.setOperacija(Operacije.VRATI_SVE_SOBE);
        
        pk.posaljiZahtev(r);
    }
    
    public void vratiSveVrsteSoba(int forma) {
    	Zahtev r = new Zahtev();
        r.setOperacija(Operacije.VRATI_SVE_VRSTE_SOBA);
        r.setParametar(forma);
        pk.posaljiZahtev(r);
    }
    
    public long vratiIDZakupa() {
    	Zahtev r = new Zahtev();
        r.setOperacija(Operacije.VRATI_ID);
        pk.posaljiZahtev(r);
        
        Odgovor response = pk.primiOdgovor();
        long ID =(long) response.getOdgovor();
        return ID;
    }
    
    public void sacuvajZakup(ZakupSobe zs) {
    	Zahtev r = new Zahtev();
        r.setOperacija(Operacije.KREIRAJ_ZAKUP);
        r.setParametar(zs);
        pk.posaljiZahtev(r);
    }
    
    public void pretraziZakupe(List<String> columns, List<String> values) {
    	Zahtev r = new Zahtev();
        r.setOperacija(Operacije.PRETRAZI_ZAKUPE);
        r.setParametar(columns);
        r.setParametar2(values);
        pk.posaljiZahtev(r);
    }
    
    public void vratiSveZakupe() {
    	Zahtev r = new Zahtev();
        r.setOperacija(Operacije.VRATI_SVE_ZAKUPE);
        
        pk.posaljiZahtev(r);
    }

    public void postaviSobe(List<Soba> nadjeni) {
        pretraziSobuForma.postaviSobe(nadjeni);
        
    }

    public void postaviVrsteSoba(List<VrstaSobe> vrste, int forma) {

        switch(forma) {
            case Forme.SEARCH_ROOM_FORMA:
                pretraziSobuForma.postaviVrste(vrste);
            break;
            case Forme.SEARCH_ZAKUP_FORMA:
                pretraziZakupForma.postaviVrste(vrste);
            break;
        
        }
    }

    public void porukaUspesnoPretraziSobe(String poruka) {
        System.out.println("IMPLEMENTIRANO "+ poruka);
        pretraziSobuForma.prikaziPoruku(poruka);
    }

    public void porukaNeuspesnoPretraziSobe(String poruka) {
        System.out.println("IMPLEMENTIRANO "+ poruka);
        pretraziSobuForma.prikaziPoruku(poruka);
    }
    
    public void porukaUspesnoPretraziSobeZaVrste(String poruka, int forma) {
        switch(forma) {
            case Forme.SEARCH_ROOM_FORMA:
                pretraziSobuForma.prikaziPoruku(poruka);
            break;
            case Forme.SEARCH_ZAKUP_FORMA:
                pretraziZakupForma.prikaziPoruku(poruka);
            break;
        
        }
        
    }

    public void porukaNeuspesnoPretraziSobeZaVrste(String poruka, int forma) {
        System.out.println("IMPLEMENTIRANO "+ poruka);
        pretraziSobuForma.prikaziPoruku(poruka);
    }

    public void odjaviRecepcionera() {
    	Zahtev r = new Zahtev();
        r.setOperacija(Operacije.LOGOUT);
        
        pk.posaljiZahtev(r);
    }

    public void postaviIdZakupa(long id) {
        zakupForma.setId(id);
    }

    public void zakupForma(JFrame roditelj) {
        zakupForma = new ZakupForma(roditelj, true, FormMode.FORM_ADD);
        zakupForma.setVisible(true);
    }

    public void vratiID() {
    	Zahtev r = new Zahtev();
        r.setOperacija(Operacije.VRATI_ID);
        
        pk.posaljiZahtev(r);
    }

    public void kreirajZakup(ZakupSobe zs, Gost gost) {
    	Zahtev r = new Zahtev();
        r.setOperacija(Operacije.KREIRAJ_ZAKUP);
        zs.setGostZakupljuje(gost);
        r.setParametar(zs);
        
        pk.posaljiZahtev(r);
    }

    public void porukaNeuspesnoZakup(String poruka) {
        zakupForma.prikaziPoruku(poruka);
    }

    public void porukaUspesnoZakup(String poruka) {
        zakupForma.prikaziPoruku(poruka);
    }
    
    public void vratiUslugeZaVrstuSobe(VrstaSobe vs) {
    	Zahtev r = new Zahtev();
        r.setOperacija(Operacije.VRATI_USLUGE_ZA_SOBU);
        List<String> columns = new ArrayList<>();
        columns.add("vrstaSobeID");
        List<String> values = new ArrayList<>();
        values.add(""+vs.getVrstaSobeID()+"");
        r.setParametar(columns);
        r.setParametar2(values);
        
        pk.posaljiZahtev(r);
    }
    
    public void postaviUsluge(List<UslugaNajma> usluge) {
        zakupForma.stampajUsluge(usluge);
    }

    public void pretraziZakupForma(JFrame roditelj) {
        pretraziZakupForma = new SearchZakupForma(roditelj, true);
        pretraziZakupForma.setVisible(true);
    }
    
    public void postaviZakupe(List<ZakupSobe> nadjeni) {
        
        pretraziZakupForma.postaviZakupe(nadjeni);
    }

    public void porukaNeuspesnoPretraziZakupe(String poruka) {
        pretraziZakupForma.prikaziPoruku(poruka);
    }

    public void porukaUspesnoPretraziZakupe(String poruka) {
        pretraziZakupForma.prikaziPoruku(poruka);
    }

    public double izracunajCenu(String datOD, String datDO, UslugaNajma usluga) {
        double cenaUsluge = usluga.getCenaUsluge();
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
        
        long diff = datumDo.getTime() - datumOd.getTime();
        int days = (int) (diff / (24*60*60*1000));
        System.out.println("DANA " + days);
        
        return days*cenaUsluge;
    }
}
