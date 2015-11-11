package com.cei37.binary;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Test1 {
	public static void main(String str[]) throws IOException {
		String file = "/home/vicente/Downloads/dcct_22dff184-679c-4699-b3f6-aa01e52a534d_ProjectBambinoSERPWBS201012v104.xls";
        FileInputStream fileinputstream = new FileInputStream(file);

        int numberBytes = fileinputstream.available();
        byte bytearray[] = new byte[numberBytes];

        fileinputstream.read(bytearray);

        FileWriter fWriter = null;
        BufferedWriter writer = null; 
        fWriter = new FileWriter("/home/vicente/Downloads/out.txt");
        writer = new BufferedWriter(fWriter);
          
        for(int i = 0; i < numberBytes; i++){
            //System.out.print((char)bytearray[i]);
            writer.write((char)bytearray[i]);
        }
        writer.flush();
        writer.close();

        fileinputstream.close();
	}
}
