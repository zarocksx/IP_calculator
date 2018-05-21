package com.example.bde.ip_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText ip;
    EditText masque;
    Button button;
    TextView adresseReseau;
    Ipv4 ip_ip;
    Ipv4 masque_ip;
    Ipv4 sub_adress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ip = findViewById(R.id.IP);
        adresseReseau = findViewById(R.id.adresseReseau);
        masque = findViewById(R.id.Masque);
        button = findViewById(R.id.ButtonOK);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                ip_ip = new Ipv4(ip.getText().toString());
                masque_ip = new Ipv4(masque.getText().toString());
                sub_adress = new Ipv4(ip_ip,masque_ip);
                adresseReseau.setText(sub_adress.getIP());
              // button.setText(Integer.toBinaryString(254));
            }
        });
    }


}
