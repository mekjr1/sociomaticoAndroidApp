package ucm.ac.mz.sociomatico.Models;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ucm.ac.mz.sociomatico.Controllers.categorias;
import ucm.ac.mz.sociomatico.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Detalhes extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);



        TextView titulo =(TextView) findViewById(R.id.titulo_publicacao_detalhes);
        TextView subtitulo = (TextView) findViewById(R.id.Corpo_da_Publicacao);
        ImageView img = (ImageView) findViewById(R.id.Imagem);

        Intent i = getIntent();

        String imagem = i.getExtras().get("imagem").toString();














       Picasso.get().load(imagem).into(img);





        String num = i.getExtras().get("itemPosition").toString();
        int n = Integer.parseInt(num);

        String titulo1 = i.getExtras().get("titulo").toString();
        String subtitulo1 = i.getExtras().get("conteudo").toString();


        subtitulo1 = subtitulo1.replace("<h3 style=\"text-align: justify;\">","");
        subtitulo1 = subtitulo1.replace("<p style=\"text-align: justify;\">","");
        subtitulo1 = subtitulo1.replace("</p>","\n");
        subtitulo1 = subtitulo1.replace("</h3>","\n");

        titulo.setText(titulo1);
        subtitulo.setText(subtitulo1);




    }
}