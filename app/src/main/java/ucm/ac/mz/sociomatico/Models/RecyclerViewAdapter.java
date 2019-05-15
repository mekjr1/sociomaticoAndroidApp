package ucm.ac.mz.sociomatico.Models;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;


    public RecyclerViewAdapter(ArrayList<Model> mlist, Context context) {
        this.dataset = mlist;
        this.mContext = context;
    }

    public static class ImageTypeViewHolder extends RecyclerView.ViewHolder{


        TextView title, subtitle,data;
        ImageView imageView;
        public ImageTypeViewHolder(View itemView) {
            super(itemView);

            this.title = (TextView)  itemView.findViewById(R.id.title);
            this.subtitle = (TextView) itemView.findViewById(R.id.subtitle);
            this.imageView = (ImageView) itemView.findViewById(R.id.Icon);
            this.data = (TextView) itemView.findViewById(R.id.data);
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
        View view = LayoutInflater.from( parent.getContext()).inflate(R.layout.postdetails, parent, false);
            return new ImageTypeViewHolder(view) ;
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading, parent, false);
            return new LoadingViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

       if (holder instanceof ImageTypeViewHolder) {
           final Model object = dataset.get(position);

           ((ImageTypeViewHolder) holder).title.setText(Html.fromHtml(object.title));
           ((ImageTypeViewHolder) holder).subtitle.setText(Html.fromHtml(object.subtitle));
           Picasso.get().load(dataset.get(position).Image).into(((ImageTypeViewHolder) holder).imageView);
           ((ImageTypeViewHolder) holder).data.setText(object.Data);


           ((ImageTypeViewHolder) holder).title.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(mContext, Detalhes.class);

                   intent.putExtra("itemPosition", position);
                   intent.putExtra("titulo", ((ImageTypeViewHolder) holder).title.getText());
                   intent.putExtra("conteudo", dataset.get(position).content);
                   intent.putExtra("imagem", dataset.get(position).Image);
                   intent.putExtra("data", dataset.get(position).Data);
                   mContext.startActivity(intent);
               }
           });

           ((ImageTypeViewHolder) holder).subtitle.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(mContext, Detalhes.class);
                   intent.putExtra("itemPosition", position);
                   intent.putExtra("titulo", ((ImageTypeViewHolder) holder).title.getText());
                   intent.putExtra("conteudo", dataset.get(position).content);
                   intent.putExtra("imagem", dataset.get(position).Image);
                   intent.putExtra("data", dataset.get(position).Data);
                   mContext.startActivity(intent);
               }
           });
           ((ImageTypeViewHolder) holder).imageView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(mContext, Detalhes.class);
                   intent.putExtra("itemPosition", position);
                   intent.putExtra("titulo", ((ImageTypeViewHolder) holder).title.getText());
                   intent.putExtra("conteudo", dataset.get(position).content);
                   intent.putExtra("imagem", dataset.get(position).Image);
                   intent.putExtra("data", dataset.get(position).Data);

                   mContext.startActivity(intent);
               }
           });


       }  else if (holder instanceof LoadingViewHolder) {
               showLoadingView((LoadingViewHolder) holder, position);
           }

        /// dataset.get(position)
    }


    private class LoadingViewHolder extends RecyclerView.ViewHolder {

        ProgressBar progressBar;

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
    }


    private void showLoadingView(LoadingViewHolder viewHolder, int position) {
        //ProgressBar would be displayed

    }

    @Override
    public int getItemCount() {
        return dataset.size() ;
    }


    @Override
    public int getItemViewType(int position) {
        return dataset.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }
}
