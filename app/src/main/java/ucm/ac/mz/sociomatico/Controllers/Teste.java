package ucm.ac.mz.sociomatico.Controllers;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import ucm.ac.mz.sociomatico.R;

public class Teste extends AppCompatActivity {

    public static TextView texto;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        btn= (Button) findViewById(R.id.botao);
        texto = (TextView) findViewById(R.id.dados);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             // Fetchdata process = new Fetchdata();
             // process.execute();

            }
        });



    }

}
