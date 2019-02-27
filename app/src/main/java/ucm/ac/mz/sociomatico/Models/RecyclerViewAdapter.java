package ucm.ac.mz.sociomatico.Models;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ucm.ac.mz.sociomatico.Controllers.categorias;
import ucm.ac.mz.sociomatico.Models.Model;
import ucm.ac.mz.sociomatico.R;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ucm.ac.mz.sociomatico.Models.Model;
//import ucm.ac.mz.sociomatico.Models.WPPostDetails;
import ucm.ac.mz.sociomatico.R;





public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private ArrayList<Model> dataset;
    private Context mContext;
    public RecyclerViewAdapter(ArrayList<Model> mlist, Context context) {
        this.dataset = mlist;
        this.mContext = context;
    }

    public static class ImageTypeViewHolder extends RecyclerView.ViewHolder{


        TextView title, subtitle;
        ImageView imageView;
        public ImageTypeViewHolder(View itemView) {
            super(itemView);

            this.title = (TextView)  itemView.findViewById(R.id.title);
            this.subtitle = (TextView) itemView.findViewById(R.id.subtitle);
            this.imageView = (ImageView) itemView.findViewById(R.id.Icon);
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext()).inflate(R.layout.postdetails, parent, false);
        return new ImageTypeViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final Model object = dataset.get(position);

        ( (ImageTypeViewHolder) holder).title.setText( object.title );
        ( (ImageTypeViewHolder) holder).subtitle.setText( object.subtitle );
        Picasso.get().load(dataset.get(position).Image).into(( (ImageTypeViewHolder) holder).imageView);

        ( (ImageTypeViewHolder) holder).title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(mContext, Detalhes.class);

                intent.putExtra("itemPosition", position);
                intent.putExtra("titulo", ((ImageTypeViewHolder) holder).title.getText());
                intent.putExtra("conteudo", dataset.get(position).content);
                intent.putExtra("imagem", dataset.get(position).Image);
               mContext.startActivity(intent);
            }
        });

        ( (ImageTypeViewHolder) holder).subtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(mContext,Detalhes.class);
              intent.putExtra("itemPosition", position);
                intent.putExtra("titulo", ((ImageTypeViewHolder) holder).title.getText());
                intent.putExtra("conteudo", dataset.get(position).content);
                intent.putExtra("imagem", dataset.get(position).Image);
               mContext.startActivity(intent);
            }
        });
        ( (ImageTypeViewHolder) holder).imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(mContext, Detalhes.class);
                intent.putExtra("itemPosition", position);
                intent.putExtra("titulo", ((ImageTypeViewHolder) holder).title.getText());
                intent.putExtra("conteudo", dataset.get(position).content);
                intent.putExtra("imagem", dataset.get(position).Image);

              mContext.startActivity(intent);
            }
        });

        /// dataset.get(position)
    }

    @Override
    public int getItemCount() {
        return dataset.size() ;
    }
}
