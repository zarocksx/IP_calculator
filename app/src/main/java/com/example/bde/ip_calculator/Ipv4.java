package com.example.bde.ip_calculator;

import android.util.Log;

import java.lang.reflect.Array;

import static android.content.ContentValues.TAG;

/**
 * Created by Bartoloni Bryan on 19-05-18.
 */

public class Ipv4 {
    private String adress;
    private int[] oct;
    private int[] tab_adress;

    public Ipv4(String adress) {
        this.adress = adress;
        oct = new int[5];
        tab_adress = new int[5];
        this.stringToIP(adress);
        Log.i(TAG, "Ipv4: "+oct[0]+"."+oct[1]+"."+oct[2]+"."+oct[3]);
    }
    public Ipv4(Ipv4 ip1, Ipv4 ip2){
        oct = new int[5];
        tab_adress = new int[5];
        this.calculAdress(ip1,ip2);

    }

    private void calculAdress(Ipv4 ip1, Ipv4 ip2) {
        for (int i=0; i<4; i++ ){
            tab_adress[i] = ip1.getAdress(i) & ip2.getAdress(i);
            Log.d("resultat", ""+i+"->" +( ip1.getAdress(i) & ip2.getAdress(i))) ;

        }
    }
    public String getIP(){
        String myIp= "";
        for (int i=0; i<4; i++ ){
            myIp += (Integer.toString(tab_adress[i])+".");
        }
        return myIp;
    }

    public int getAdress(int i){
        return this.tab_adress[i];
    }

    private int stringToIP(String adress){
        int octNumber = 0;
        String buffer = new String("");
        for (char c : adress.toCharArray()) {
            if (dotRemover(c) == 1){
                this.oct[octNumber] = Integer.parseInt(Integer.toBinaryString( Integer.parseInt(buffer) ) );
                this.tab_adress[octNumber] = Integer.parseInt(buffer);
                Log.d("info:","--"+octNumber+"--"+c+"--");
                octNumber++;
                buffer = "";
            }else{
                buffer += c;
            }
        }
        this.oct[octNumber] = Integer.parseInt(Integer.toBinaryString( Integer.parseInt(buffer) ) );
        this.tab_adress[octNumber] = Integer.parseInt(buffer);
        Log.d("info:","--"+octNumber+"--final");
        return 1;
    }

    private int dotRemover(char c){
        if (c == '.'){
            return 1;
        }
        return 0;
    }
}
