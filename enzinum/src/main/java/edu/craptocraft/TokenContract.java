package edu.craptocraft;

import java.security.PublicKey;

public class TokenContract {
    
    public PublicKey ownerPublicKey;
    public String name;
    public String symbol;
    public int totalSupply;
    public double tokenPrice;


    public TokenContract(Address owner){
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

    public String getSymbol() {
        return symbol;
    }

    public double getTokenPrice() {
        return tokenPrice;
    }

    public int getTotalSupply() {
        return totalSupply;
    }

    @Override
    public String toString() {
        return "Nombre del contrato:\t"+this.getName()+"\nSimbolo:\t"+this.getSymbol()+"\nTotalSupply\t"+this.getTotalSupply()+"\nTokenPrice:\t"+this.getTokenPrice()+"\nPublicKey\t"+this.getOwner().hashCode();
    }


}
