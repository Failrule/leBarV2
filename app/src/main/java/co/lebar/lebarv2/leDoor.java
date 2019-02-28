package co.lebar.lebarv2;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStreamReader;

import me.anwarshahriar.calligrapher.Calligrapher;

public class leDoor extends AppCompatActivity {

    private Button registrar,ingresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_le_door);


        try {
            BufferedReader fin = new BufferedReader(new InputStreamReader(openFileInput("h4x0r1")));
            String texto = fin.readLine();

            if (texto.equals("user@lebar.com")) {//si el texto en files coincide con la BD (c)
                Toast.makeText(this, "Hola " + texto, Toast.LENGTH_LONG).show();
                startActivity(new Intent(leDoor.this, Inicio.class));
                fin.close();
                finish();
            } else {
                Toast.makeText(this, "Datos actualizados", Toast.LENGTH_SHORT).show();
               // File f = new File(Environment.getDataDirectory()+"/data/files/");
                eliminarPorExtension(Environment.getDataDirectory()+"/data/co.lebar.lebarv2/files/", "h4");

                door();
            }
        } catch (Exception ex) {


                  door();

            Log.e("Ficheros", "Error al leer fichero desde memoria interna");
        }
    }

    public void door(){

        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "Hamburg.TTF", true);

        registrar = (Button) findViewById(R.id.registrarseBtn);
        ingresar = (Button) findViewById(R.id.ingresarBtn);


        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(leDoor.this, registro.class));
                finish();


            }
        });

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(leDoor.this, ingreso.class));
                finish();

            }
        });


    }



        public static void eliminarPorExtension(String path, final String extension){

            File[] archivos = new File(path).listFiles(new FileFilter() {

                public boolean accept(File archivo) {

                    if (archivo.isFile())

                    return archivo.getName().startsWith(extension);

                    return false;

                }

            });

            for (File archivo : archivos)

            archivo.delete();

        }



    }

