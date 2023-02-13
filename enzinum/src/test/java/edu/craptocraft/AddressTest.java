package edu.craptocraft;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;

public class AddressTest {

    Address rick = null;

    @Before
    public void initialize() {

        assertNull(this.rick);
        this.rick = new Address();
        this.rick.generateKeyPair();
    }


    // Como se valida una privatekey y publickey?
    @Test
    public void constructorTest() {

        assertNotNull(this.rick);
        assertEquals(0, this.rick.balance, 0);
        assertEquals("EZI", this.rick.symbol);


    }

    @Test
    public void keyGenerator() {

        this.rick.generateKeyPair();

        assertNotNull(this.rick.publicKeyPK);
        assertNotNull(this.rick.privateKeySK);

    }


    @Test
    public void toStringTest(){
        

        String result = "Public Key\t"+this.rick.publicKeyPK.hashCode()+"\nBalance:\t"+this.rick.balance;
        assertEquals(result, rick.toString());

    }

}
