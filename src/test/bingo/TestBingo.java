/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.bingo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author StandAlone
 */
public class TestBingo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner dis=new Scanner(System.in);
        dis.useDelimiter("\\D");
//        int[] ints = new int[9999];
        ArrayList<Integer> arl = new ArrayList<Integer>();
        int[][] multi = new int[5][5];
        int count = 1;
        
        boolean bingo = false;
        
        for (int i=0;i<=4;i++){
            for (int j=0;j<=4;j++){
                multi[i][j] = count;
                count++;
            }
        }
            
        int inx = 0;
        try {
            while(dis.hasNext()){
                arl.add(dis.nextInt());
                inx++;
            }
        } catch (Exception e){
            
            int check_col = 0;
            for (int i=0;i<=4;i++){
                int check = 0;
                check_col = 0;
                for (int j=0;j<=4;j++){
                    for (int k=0;k<arl.size();k++){
                        if(arl.get(k) == multi[i][j])
                            check++;
                        for (int g=i+2;g<=25;g+=5){
                            if(arl.get(k) == g)
                                check_col++;
                        }
                        if(check_col == 5)
                            bingo = true;
                            break;
                    }
                }
                if(check==5 || check_col == 5)
                    bingo = true;
                    break;
            }
            if(bingo)
                System.out.println("Bingo");
            else
                System.out.println("Not Bingo");
            
            dis.close();
        }
        
                
    }
    
}
