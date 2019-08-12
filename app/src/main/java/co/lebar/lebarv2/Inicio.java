package co.lebar.lebarv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import me.anwarshahriar.calligrapher.Calligrapher;

public class Inicio extends AppCompatActivity {

    private Button comida, bebida, cancion, chat;
    private ImageView logo;
    private TextView establecimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this,"Hamburg.TTF",true);

        establecimiento = (TextView) findViewById(R.id.establecimiento);
       // logo =(ImageView)findViewById(R.id.logo);
        comida = (Button) findViewById(R.id.comidaBtn);
        bebida = (Button)findViewById(R.id.bebidaBtn);
        cancion = (Button)findViewById(R.id.musicaBtn);
        chat = (Button)findViewById(R.id.chatBtn);



       // Picasso.get().load("http://lebar.myscriptcase.com/api/alfa/BBC.png").into(logo);



        establecimiento.setText("Bar");


        comida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proxmsg();
            }
        });

        bebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proxmsg();
            }
        });

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proxmsg();
            }
        });

        bebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Inicio.this,bebidas.class));
            }
        });




        cancion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Inicio.this,ordenar_cancion.class));



            }
        });



    }

    public void proxmsg(){
        Toast.makeText(this, "Próximamente", Toast.LENGTH_SHORT).show();

    }

}

