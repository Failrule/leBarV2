package co.lebar.lebarv2;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import me.anwarshahriar.calligrapher.Calligrapher;

public class ordenar_cancion extends AppCompatActivity {

        public EditText nombre, artista;
        public Button pedir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordenar_cancion);
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this,"Hamburg.TTF",true);

        nombre = (EditText)findViewById(R.id.etCancion);
        artista = (EditText)findViewById(R.id.etArtista);
        pedir = (Button)findViewById(R.id.btnPedir);


        final Intent ok_cancion = new Intent(ordenar_cancion.this,Inicio.class);

        pedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nombre.getText().toString().isEmpty()){
                    Toast.makeText(ordenar_cancion.this, "¡Anímate!", Toast.LENGTH_LONG).show();

                }else{
                    if(artista.getText().toString().isEmpty()){
                        Toast.makeText(ordenar_cancion.this, "Eso es, pero dame mas!", Toast.LENGTH_LONG).show();

                    }else{
                        if(nombre.getText().toString()!=""&artista.getText().toString()!=""){
                            Date cDate = new Date();
                            Date cHour = new Date();
                            String fDate = new SimpleDateFormat("yyyy-MM-dd").format(cDate);
                            String fHour = new SimpleDateFormat("kk:mm:ss").format(cHour);


                            new CargarDatos().execute("http://lebar.myscriptcase.com/api/alfa/registro.php?id_cliente=2&cancion=" + nombre.getText().toString() + "&artista=" + artista.getText().toString() + "&fecha=" + fDate + "&hora=" + fHour);
                            startActivity(ok_cancion);
                            Toast.makeText(ordenar_cancion.this, "" + nombre.getText().toString() + " DE: " + artista.getText().toString(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(ordenar_cancion.this, "¡Ush... temazo!", Toast.LENGTH_LONG).show();

                            finish();
                        }
                    }


                }


            }


        });



    }



    private class CargarDatos extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {
                return downloadUrl(urls[0]);

            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {


           // Toast.makeText(getApplicationContext(), "Completado", Toast.LENGTH_LONG).show();

        }

        private String downloadUrl(String myurl) throws IOException {
            Log.i("URL", "" + myurl);
            myurl = myurl.replace(" ", "%20");
            InputStream is = null;
            // Only display the first 500 characters of the retrieved
            // web page content.
            int len = 500;

            try {
                URL url = new URL(myurl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                // Starts the query
                conn.connect();
                int response = conn.getResponseCode();
                Log.d("respuesta", "The response is: " + response);
                is = conn.getInputStream();

                // Convert the InputStream into a string
                String contentAsString = readIt(is, len);
                return contentAsString;

                // Makes sure that the InputStream is closed after the app is
                // finished using it.


            } catch (Exception ex) {
                String error = ex.getMessage();
                String asdasdasd = "";
                return null;
            } finally {
                if (is != null) {
                    is.close();
                }
            }
        }

        public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
            Reader reader = null;
            reader = new InputStreamReader(stream, "UTF-8");
            char[] buffer = new char[len];
            reader.read(buffer);
            return new String(buffer);
        }


    }


}

