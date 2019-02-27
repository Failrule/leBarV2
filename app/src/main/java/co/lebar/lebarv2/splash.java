package co.lebar.lebarv2;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import me.anwarshahriar.calligrapher.Calligrapher;

public class splash extends AppCompatActivity {

    private ImageView splashtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this,"Hamburg.TTF",true);

        splashtv = (ImageView) findViewById(R.id.splashiv);
        Animation anim_splash = AnimationUtils.loadAnimation(this, R.anim.transision1);
        splashtv.startAnimation(anim_splash);



        Thread timer = new Thread(){
          public void run() {
              try {
                  sleep(3000);

              }catch (InterruptedException e){
                  e.printStackTrace();
              }
              finally {
                  startActivity(new Intent(splash.this, leDoor.class));
                  finish();
              }
          }
        };
        timer.start();
    }
}
