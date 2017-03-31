/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jadsay2
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PrimitiveCombination {

    public static void main(String[] args) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {

            fw = new FileWriter("newfile.txt");
            bw = new BufferedWriter(fw);

        } catch (IOException e) {

            e.printStackTrace();

        }
        int count = 0;
        for (int i1 = 1; i1 <= 6; i1++) {
            for (int i2 = i1 + 1; i2 <= 7; i2++) {
                for (int i3 = i2 + 1; i3 <= 8; i3++) {
                    for (int i4 = i3 + 1; i4 <= 9; i4++) {
                        for (int i5 = i4 + 1; i5 <= 10; i5++) {
                            for (int i6 = i5 + 1; i6 <= 11; i6++) {
                                String content = i1+" "+i2+" "+i3+" "+i4+" "+i5+" "+i6+"\n";
                                try {

                                    bw.write(content);

                                } catch (IOException e) {

                                    e.printStackTrace();

                                }
                                count++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Done");
                System.out.println(count);

    }
}
