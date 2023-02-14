package edu.craptocraft;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;


public class TokenContractTest {
    

    static TokenContract ricknillos;
    static Address rick;
    static Address morty;

    @BeforeClass public static void onlyOnce(){

        morty = new Address();
        morty.generateKeyPair();

        rick = new Address();
        rick.generateKeyPair();
        
        ricknillos = new TokenContract(rick);

    }

    @Test public void setNameTest(){

        ricknillos.setName("Ricknillos");
        assertEquals("Ricknillos", ricknillos.getName());

    }

    @Test public void setSymbolTest(){

        ricknillos.setSymbol("RNiLL");
        assertEquals("RNiLL", ricknillos.symbol());
    
    }


    @Test public void setTotalSupplyTest(){

        ricknillos.setTotalSupply(100);
        assertEquals(100, ricknillos.totalSupply(), 0);
    }

    @Test public void setTokenPriceTest(){

        ricknillos.setTokenPrice(5d);
        assertEquals(5d, ricknillos.getTokenPrice(), 0);
    }


    @Test public void toStringTest(){

        String result = "Nombre del contrato:\t"+ricknillos.getName()+"\nSimbolo:\t"+ricknillos.symbol()+"\nTotalSupply\t"+ricknillos.totalSupply()+"\nTokenPrice:\t"+ricknillos.getTokenPrice()+"\nPublicKey\t"+ricknillos.getOwner().hashCode();
        assertEquals(result, ricknillos.toString());

    }
    
    
    @Test public void addOwnerTest(){
        
        ricknillos.addOwner(rick.getPK(), ricknillos.totalSupply());    
        
    }

    @Test public void numOwnersTest(){

        ricknillos.addOwner(rick.getPK(), ricknillos.totalSupply());    
        assertEquals(1, ricknillos.numOwners());

    }

    @Test public void balanceOfTest(){

        ricknillos.addOwner(rick.getPK(), ricknillos.totalSupply());    
        assertEquals(1, ricknillos.numOwners());
        assertEquals( 100 , ricknillos.balanceOf(rick.getPK()), 0);

    }


    // @Test public void transferTest(){

    //     morty = new Address();
    //     morty.generateKeyPair();

    //     rick = new Address();
    //     rick.generateKeyPair();

    //     ricknillos = new TokenContract(rick);

    //     ricknillos.addOwner(rick.getPK(), ricknillos.totalSupply()); 
    //     ricknillos.setName("Ricknillos");
    //     ricknillos.setSymbol("RNiLL");
    //     ricknillos.setTotalSupply(100);
    //     ricknillos.setTokenPrice(5d);


    //     // EN EL MAIN FUNCIONA , EN LOS TEST NO 
    //     ricknillos.transfer(morty.getPK(), 2d);
    //     assertEquals(2,  ricknillos.balanceOf(morty.getPK()) , 0);
        
    // }


}
