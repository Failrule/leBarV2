package co.lebar.lebarv2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;
import com.github.johnpersano.supertoasts.library.SuperToast;
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils;

import java.io.OutputStreamWriter;
import java.util.concurrent.TimeUnit;

import me.anwarshahriar.calligrapher.Calligrapher;

public class ingreso extends AppCompatActivity {




    private Button ingresarBtn;
    private EditText ing_correo, ing_contrasenia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);

        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this,"Hamburg.TTF",true);

        ingresarBtn = (Button) findViewById(R.id.ingresarBtn);
        ing_correo = (EditText) findViewById(R.id.etIng_correo);
        ing_contrasenia = (EditText) findViewById(R.id.etIng_contrasenia);



        ingresarBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {



                String user = "user@lebar.com";
                String pass = "1234";


                if(ing_correo.getText().toString().isEmpty()){
                    Toast.makeText(ingreso.this, "¿Correo?", Toast.LENGTH_SHORT).show();
                }else if (ing_contrasenia.getText().toString().isEmpty()){
                    Toast.makeText(ingreso.this, "¿Contraseña?", Toast.LENGTH_SHORT).show();
                    SuperToast.create(ingreso.this, "¿Contraseña?", Toast.LENGTH_LONG).show();

                }else{

                    if(ing_correo.getText().toString().equals(user)&&ing_contrasenia.getText().toString().equals(pass)){

                        startActivity(new Intent(ingreso.this,Inicio.class));
                     //   Toast.makeText(ingreso.this, "Hola "+ing_correo.getText().toString(), Toast.LENGTH_SHORT).show();

                        SuperActivityToast.create(ingreso.this, new Style(), Style.TYPE_PROGRESS_BAR)

                                .setProgressBarColor(Color.WHITE)
                                .setText("Ingresando")
                                .setDuration(Style.DURATION_LONG)
                                .setFrame(Style.FRAME_LOLLIPOP)
                                .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_CYAN))
                                .setAnimations(Style.ANIMATIONS_POP).show();

                        try {
                            OutputStreamWriter fout= new OutputStreamWriter(openFileOutput("h4x0r1", Context.MODE_PRIVATE));
                            fout.write(ing_correo.getText().toString());
                            fout.close();
                        }
                        catch (Exception ex)
                        {
                            Log.e("Login", "Error al escribir fichero a memoria interna");
                        }

                        try {
                            OutputStreamWriter fout= new OutputStreamWriter(openFileOutput("h4x0rb", Context.MODE_PRIVATE));
                            fout.write(ing_contrasenia.getText().toString());
                            fout.close();
                        }
                        catch (Exception ex)
                        {
                            Log.e("Login", "Error al escribir fichero a memoria interna");
                        }

                        startActivity(new Intent(ingreso.this, Inicio.class));

                        finish();
                        }else{
                        Toast.makeText(ingreso.this, "Revisa bien usuario y/o contraseña", Toast.LENGTH_SHORT).show();



                    }


                }


            }
        });

    }
}
