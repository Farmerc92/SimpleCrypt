package com.zipcodewilmington.simplecrypt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class FileWriterROT13Test {

    @Before
    public void init(){
        ROT13 cipher = new ROT13();

        cipher.encryptTextFile(new File("sonnet18.txt"));
        cipher.decryptTextFile(new File("sonnet18.enc"));
    }

    @Test
    public void testFileWriter(){
        try {
            BufferedReader reader1 = new BufferedReader(new FileReader("sonnet18.txt"));
            BufferedReader reader2 = new BufferedReader(new FileReader("sonnet18.dec"));
            String line1;
            String line2;
            while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null){
                line1 = reader1.readLine();
                line2 = reader2.readLine();
                Assert.assertEquals(line1, line2);
            }
            reader1.close();
            reader2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
