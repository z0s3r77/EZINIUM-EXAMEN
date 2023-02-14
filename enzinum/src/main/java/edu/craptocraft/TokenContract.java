package edu.craptocraft;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class TokenContract {
    
    public PublicKey ownerPublicKey;
    public Address owner;
    public String name;
    public String symbol;
    public double totalSupply;
    public double tokenPrice;
    public Map<PublicKey, Double > balances = new HashMap<PublicKey, Double>();


    public TokenContract(Address owner){
        this.owner = owner;
        this.ownerPublicKey = owner.publicKeyPK;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setTokenPrice(double tokenPrice) {
        this.tokenPrice = tokenPrice;
    }

    public void setTotalSupply(int totalSupply) {
        this.totalSupply = totalSupply;
    }

    public String getName() {
        return name;
    }

    public PublicKey getOwner() {
        return ownerPublicKey;
    }

    public String symbol() {
        return symbol;
    }

    public double getTokenPrice() {
        return tokenPrice;
    }

    public Double totalSupply() {
        return this.totalSupply;
    }

    @Override
    public String toString() {
        return "Nombre del contrato:\t"+this.getName()+"\nSimbolo:\t"+this.symbol()+"\nTotalSupply\t"+this.totalSupply()+"\nTokenPrice:\t"+this.getTokenPrice()+"\nPublicKey\t"+this.getOwner().hashCode();
    }


    public void addOwner(PublicKey publicKey , Double totalSupply){

        this.balances.putIfAbsent(publicKey, totalSupply);

    }

    public int numOwners() {
        return this.balances.size();
    }

    public Double balanceOf(PublicKey pk) {
       
        if (this.balances.get(pk)==null) {
            return 0d;        
       }else{
            return this.balances.get(pk);
       }


    }

    public void transfer(PublicKey pk, double d) {
    
        if (this.balances.get(this.ownerPublicKey) >= d) {
            this.balances.put(this.ownerPublicKey, this.balances.get(this.ownerPublicKey) - d );

            if (this.balances.get(pk) == null) {
                this.balances.put(pk, d);  
            } else {
                this.balances.put(pk , this.balances.get(pk) +d );
            }
        } 
    
    }


    public void transfer(PublicKey origen, PublicKey destino, double d){

        if (this.balances.get(origen) >= d) {
            this.balances.put(origen, this.balances.get(origen) - d);

            if (this.balances.get(destino) == null) {
                this.balances.put(destino, d);  
            } else {
                this.balances.put(destino , this.balances.get(destino) +d );
            }


        }

    }


    public void owners(){

        this.balances.entrySet().stream()
                                .filter( own -> own.getKey() != this.getOwner())
                                .forEach(own -> System.out.println(own.getKey().hashCode() + " " + this.balances.get(own.getKey())));

    }

    public double totalTokensSold() {
        return this.balances.entrySet().stream()
                                        .filter( own -> own.getKey() != this.getOwner())
                                        .mapToDouble(own -> own.getValue().doubleValue())
                                        .sum();
    }




    public void playable(PublicKey receptorTokens , Double EnZinIums) {

        double entradas = EnZinIums / this.tokenPrice;

        if (entradas >= 1) {

            transfer(receptorTokens, entradas);

            this.owner.transferEZI(EnZinIums);
            
        }


    }




}
