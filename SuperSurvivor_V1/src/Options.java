/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Nkwabo Saleh
 */
public class Options {
    
    private int oid;
    private String firstopt;
    private String secondopt;
    private String thirdopt;
    private String firstoptselect;
    private String secondoptselect;
    private String thirdoptselect;
    
    public Options(int oid, String firstopt, String secondopt, String thirdopt, String firstoptselect, String secondoptselect, String thirdoptselect) {
        this.oid = oid;
        this.firstopt = firstopt;
        this.secondopt = secondopt;
        this.thirdopt = thirdopt;
        this.firstoptselect = firstoptselect;
        this.secondoptselect = secondoptselect;
        this.thirdoptselect = thirdoptselect;
    }
    
    public int getOid() {
        return this.oid;
    }
    
    public String getFirstOpt() {
        return this.firstopt;
    }
    
    public String getSecondOpt() {
        return this.secondopt;
    }
    
    public String getThirdOpt() {
        return this.thirdopt;
    }
    
    public String getFirstOptSelected() {
        return this.firstoptselect;
    }
    
    public String getSecondOptSelected() {
        return this.secondoptselect;
    }
    
    public String getThirdOptSelected() {
        return this.thirdoptselect;
    }
    
}
