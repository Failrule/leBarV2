package co.lebar.lebarv2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils;

import me.anwarshahriar.calligrapher.Calligrapher;

public class registro extends AppCompatActivity {

    private Button listo;
    private EditText reg_contrasenia,reg_conf_contrasenia, reg_correo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this,"Hamburg.TTF",true);



        listo = (Button) findViewById(R.id.listoBtn);
        reg_contrasenia = (EditText) findViewById(R.id.etReg_Contrasenia);
        reg_conf_contrasenia = (EditText) findViewById(R.id.etReg_Conf_contrasenia);
        reg_correo = (EditText) findViewById(R.id.etCorreo);


        listo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (reg_correo.getText().toString().isEmpty()){
                    Toast.makeText(registro.this, "Correo obligatorio", Toast.LENGTH_SHORT).show();
                }else if(reg_contrasenia.getText().toString().isEmpty()){
                    Toast.makeText(registro.this, "Contraseña obligatoria", Toast.LENGTH_SHORT).show();
                }else if(reg_contrasenia.getText().toString().equals(reg_conf_contrasenia.getText().toString())){


                    SuperActivityToast.create(registro.this, new Style(), Style.TYPE_PROGRESS_BAR)

                            .setProgressBarColor(Color.WHITE)
                            .setText("Registrando")
                            .setDuration(Style.DURATION_LONG)
                            .setFrame(Style.FRAME_LOLLIPOP)
                            .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_CYAN))
                            .setAnimations(Style.ANIMATIONS_POP).show();

                   // Toast.makeText(registro.this, "Registro exitoso", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(registro.this,ingreso.class));
                    finish();

                }else {
                    Toast.makeText(registro.this, "Contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
