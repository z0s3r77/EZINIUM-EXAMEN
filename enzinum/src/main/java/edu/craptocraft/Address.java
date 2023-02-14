package edu.craptocraft;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Address {
    
    protected  PublicKey publicKeyPK = null;
    protected  PrivateKey privateKeySK = null;
    protected double balance = 0d;
    protected String symbol = "EZI";


    public void generateKeyPair(){
        
        KeyPair pair = GenSig.generateKeyPair();
        this.publicKeyPK = pair.getPublic();
        this.privateKeySK = pair.getPrivate();

    }


    public PublicKey getPK(){
        return this.publicKeyPK;
    }

    @Override
    public String toString() {
        
        StringBuilder addres = new StringBuilder();
        addres.append("Public Key\t"+this.publicKeyPK.hashCode()+"\nBalance:\t"+this.balance);
        return addres.toString();

    }


    public void transferEZI(double d) {

        this.balance += d;

    }


    public void send(TokenContract contrato, double d) {

        if (this.balance >= d) {
            
            this.balance -= d;
            contrato.playable(this.publicKeyPK, d);


        } 
    }

    public double getBalance(){
        return this.balance;
    }

}
