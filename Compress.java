/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesizereducer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.zip.DeflaterOutputStream;

/**
 *
 * @author Nitin
 */
public class Compress {

    String fPath;
    protected static int i;

    public Compress (String x) {
        fPath = x;
    }

    void shrink() throws FileNotFoundException, IOException {

        FileInputStream fis = new FileInputStream(fPath);
        String temp = fPath;
        String fnamesaver = null;
        StringTokenizer st = new StringTokenizer(temp, "\\");
        while ((st.hasMoreTokens())) {
            fnamesaver = st.nextToken();
        }
        temp = temp.replace(fnamesaver, "");
        System.out.println(temp);
        FileOutputStream fos = new FileOutputStream(temp + "\\Compressed"+fnamesaver);
        DeflaterOutputStream dos = new DeflaterOutputStream(fos);
        int data;
        while ((data = fis.read()) != -1) {
            dos.write(data);
        }
        fis.close();
        dos.close();
    }
}
