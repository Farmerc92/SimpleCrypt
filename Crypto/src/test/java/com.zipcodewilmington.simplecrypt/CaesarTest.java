package com.zipcodewilmington.simplecrypt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CaesarTest {

    @Test
    public void caesarCipherTest(){
        Caesar caesar = new Caesar(5);
        String baseSring = "Hello there!";

        String expectedString = caesar.caesarCipherEncrypt(baseSring);

        String actualString = "Mjqqt ymjwj!";

        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void caesarDecryptTest(){
        Caesar caesar = new Caesar(5);
        String actualString = "Hello there!";

        String encryptedString = caesar.caesarCipherEncrypt(actualString);
        String expectedString = caesar.caesarCipherDecrypt(encryptedString);

        Assert.assertEquals(expectedString, actualString);
    }
}
