package co.lebar.lebarv2;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import me.anwarshahriar.calligrapher.Calligrapher;

//public class ingreso extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    public class ingreso extends AppCompatActivity {

    private GoogleApiClient googleApiClient;
    private SignInButton loginBtn;
    public static final int SIGN_IN_CODE = 777;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);



       /*Calligrapher calligrapher = new Calligrapher(this);
       calligrapher.setFont(this, "Hamburg.TTF", true);*/

        loginBtn = findViewById(R.id.loginBtn);

        //eliminar con comentarios
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ingreso.this,Inicio.class));
            }
        });
        //eliminar con comentarios

       /* GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
             // .requestEmail()
              .build();

       googleApiClient = new GoogleApiClient.Builder(this)
               .enableAutoManage(this, this)
               .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
               .build();


        loginBtn.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view) {
               Intent  intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
               startActivityForResult(intent, SIGN_IN_CODE);

            }


       });


    }

      @Override
        public void onConnectionFailed (@NonNull ConnectionResult connectionResult){

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SIGN_IN_CODE){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignResult(result);
        }
    }

    private void handleSignResult(GoogleSignInResult result) {
        if (result.isSuccess()){
            goMainScreen();
        }else{
            Toast.makeText(this, "No", Toast.LENGTH_SHORT).show();
        }


    }

    private void goMainScreen() {
        Intent intent = new Intent(this, Inicio.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }*/
    }//Eliminar con comentarios
}


