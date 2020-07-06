/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.MvnRecepcijaKlijent.sesija;

import rs.ac.bg.fon.ai.nprog.MvnRecepcijaBiblioteka.domen.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Win10
 */
public class Mapa {
    private static Mapa instanca;
    private final Map<String, Object> map;

    public Mapa() {
        map = new HashMap<>();
    }

    public static Mapa getInstanca() {
        if(instanca==null) {
            instanca=new Mapa();
        }
        return instanca;
    }

    public Map<String, Object> getMap() {
        return map;
    }
    
    public void setReceptionist(Recepcioner recepcioner) {
        map.put("current.receptionist", recepcioner);
    }
    
    public Recepcioner getReceptionist() {
        return (Recepcioner) map.get("current.receptionist");
    }
    
    public void setGuest(Gost guest) {
        map.put("current.guest", guest);
    }
    
    public Gost getGuest() {
        return (Gost) map.get("current.guest");
    }
    
    public void setGuests(List<Gost> gosti) {
        map.put("current.guests",gosti);
    }
    
    public List<Gost> getGuests() {
        return (List<Gost>) map.get("current.guests");
    }
    
    public void setZakup(ZakupSobe zakup) {
        map.put("current.zakup", zakup);
    }
    
    public ZakupSobe getZakup() {
        return (ZakupSobe) map.get("current.zakup");
    }
}
