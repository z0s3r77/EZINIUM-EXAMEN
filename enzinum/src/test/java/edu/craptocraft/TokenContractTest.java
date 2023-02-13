package edu.craptocraft;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;


public class TokenContractTest {
    

    static TokenContract ricknillos;

    @BeforeClass public static void onlyOnce(){

        Address rick = new Address();
        rick.generateKeyPair();
        ricknillos = new TokenContract(rick);

    }

    @Test public void setNameTest(){

        ricknillos.setName("Ricknillos");
        assertEquals("Ricknillos", ricknillos.getName());

    }

    @Test public void setSymbolTest(){

        ricknillos.setSymbol("RNiLL");
        assertEquals("RNiLL", ricknillos.getSymbol());
    
    }


    @Test public void setTotalSupplyTest(){

        ricknillos.setTotalSupply(100);
        assertEquals(100, ricknillos.getTotalSupply());
    }

    @Test public void setTokenPriceTest(){

        ricknillos.setTokenPrice(5d);
        assertEquals(5d, ricknillos.getTokenPrice(), 0);
    }


    @Test public void toStringTest(){

        String result = "Nombre del contrato:\t"+ricknillos.getName()+"\nSimbolo:\t"+ricknillos.getSymbol()+"\nTotalSupply\t"+ricknillos.getTotalSupply()+"\nTokenPrice:\t"+ricknillos.getTokenPrice()+"\nPublicKey\t"+ricknillos.getOwner().hashCode();
        assertEquals(result, ricknillos.toString());

    }
    
    
}
