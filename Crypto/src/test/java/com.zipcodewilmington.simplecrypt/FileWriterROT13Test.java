package com.zipcodewilmington.simplecrypt;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class FileWriterROT13Test {

    @Before
    public void init(){
        ROT13 cipher = new ROT13();

        cipher.encryptTextFile(new File("sonnet18.txt"));
        cipher.decryptTextFile(new File("sonnet18.enc"));
    }

    @Test
    public void testFileWriter(){

    }
}
