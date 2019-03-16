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
import java.util.zip.InflaterInputStream;

/**
 *
 * @author Nitin
 */
public class DeCompress {

    String fPath;
    protected static int i;
    public DeCompress(String x) {
        fPath = x;
    }

    void grow() throws FileNotFoundException, IOException {

        
        String temp = fPath;
        String fnamesaver = null;
        StringTokenizer st = new StringTokenizer(temp, "\\");
        while ((st.hasMoreTokens())) {
            fnamesaver = st.nextToken();
        }
        System.out.println(fnamesaver);
        temp = temp.replace(fnamesaver, "");
        FileInputStream fis = new FileInputStream(fPath);
        FileOutputStream fos = new FileOutputStream(temp + "\\Decompressed"+fnamesaver);
        InflaterInputStream iis = new InflaterInputStream(fis);
        int data;
        while ((data = iis.read()) != -1) {
            fos.write(data);
        }
        fos.close();
        iis.close();
    }
}
