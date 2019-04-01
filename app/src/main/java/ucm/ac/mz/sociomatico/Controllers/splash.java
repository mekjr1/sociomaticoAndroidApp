package ucm.ac.mz.sociomatico.Controllers;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ucm.ac.mz.sociomatico.R;

public class splash extends AppCompatActivity {

    private static int time = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent inte  = new Intent(splash.this, MainActivity.class);

                startActivity(inte);
                finish();
            }
        }, time);



    }
}
