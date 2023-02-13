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


    @Override
    public String toString() {
        
        StringBuilder addres = new StringBuilder();
        addres.append("Public Key\t"+this.publicKeyPK.hashCode()+"\nBalance:\t"+this.balance);
        return addres.toString();

    }

}
