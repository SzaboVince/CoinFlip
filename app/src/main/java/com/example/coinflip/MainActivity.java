package com.example.coinflip;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView kep;
    private Button fej;
    private Button iras;
    private TextView dobasok;
    private TextView gyozelem;
    private TextView vereseg;
    private int dobasdb;
    private int gyozelemdb;
    private int veresegdb;
    private Random rnd;
    private AlertDialog.Builder alert_vege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        fej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int veletlen= rnd.nextInt(2);
                switch(veletlen){
                    case 0:
                        kep.setImageResource(R.drawable.heads);
                        dobasdb++;
                        gyozelemdb++;
                        Toast.makeText(MainActivity.this,"Fej - Megnyerted a kört!",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        kep.setImageResource(R.drawable.tails);
                        dobasdb++;
                        veresegdb++;
                        Toast.makeText(MainActivity.this,"Írás - Elveszítetted a kört!",Toast.LENGTH_SHORT).show();
                        break;
                }
                dobasok.setText("Dobások: "+dobasdb);
                gyozelem.setText("Győzelem: "+gyozelemdb);
                vereseg.setText("Vereség: "+veresegdb);
                if (dobasdb==5){
                    if(gyozelemdb>veresegdb){
                        alert_vege.setTitle("Győzelem");
                        alert_vege.show();
                    }
                    else if (veresegdb>gyozelemdb) {
                        alert_vege.setTitle("Vereség");
                        alert_vege.show();
                    }
                    else{
                        alert_vege.setTitle("Döntetlen");
                        alert_vege.show();
                    }
                }
            }
        });
        iras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int veletlen= rnd.nextInt(2);
                switch(veletlen){
                    case 0:
                        kep.setImageResource(R.drawable.heads);
                        dobasdb++;
                        veresegdb++;
                        Toast.makeText(MainActivity.this,"Fej - Elveszítetted a kört!",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        kep.setImageResource(R.drawable.tails);
                        dobasdb++;
                        gyozelemdb++;
                        Toast.makeText(MainActivity.this,"Írás - Megnyerted a kört!",Toast.LENGTH_SHORT).show();
                        break;
                }
                dobasok.setText("Dobások: "+dobasdb);
                gyozelem.setText("Győzelem: "+gyozelemdb);
                vereseg.setText("Vereség: "+veresegdb);
                if (dobasdb==5){
                    if(gyozelemdb>veresegdb){
                        alert_vege.setTitle("Győzelem");
                        alert_vege.show();
                    }
                    else if (veresegdb>gyozelemdb) {
                        alert_vege.setTitle("Vereség");
                        alert_vege.show();
                    }
                    else{
                        alert_vege.setTitle("Döntetlen");
                        alert_vege.show();
                    }
                }
            }
        });
    }

    public void init(){
        kep=findViewById(R.id.kep);
        fej=findViewById(R.id.fej);
        iras=findViewById(R.id.iras);
        dobasok=findViewById(R.id.dobasok);
        gyozelem=findViewById(R.id.gyozelem);
        vereseg=findViewById(R.id.vereseg);
        dobasdb=0;
        gyozelemdb=0;
        veresegdb=0;
        rnd=new Random();
        alert_vege=new AlertDialog.Builder(MainActivity.this);
        alert_vege.setTitle("Győzelem");
        alert_vege.setMessage("Szeretne új játékot játszani?");
        alert_vege.setNegativeButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                newgame();
            }
        });
        alert_vege.setPositiveButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alert_vege.setCancelable(false);
        alert_vege.create();
    }
    public void newgame(){
        kep.setImageResource(R.drawable.heads);
        init();
        dobasok.setText("Dobások: "+dobasdb);
        gyozelem.setText("Győzelem: "+gyozelemdb);
        vereseg.setText("Vereség: "+veresegdb);
    }
}