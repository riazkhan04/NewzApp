package riaz.example.com.newzapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import riaz.example.com.newzapp.Objects.ArticlesDetails;
import riaz.example.com.newzapp.R;

/**
 * Created by RIAZ on 31/10/17.
 */

public class RecyclerNewzAdapter extends RecyclerView.Adapter<RecyclerNewzAdapter.ViewHolder>{

    ArrayList<ArticlesDetails> artcle_arr;
    private Context context;

    public RecyclerNewzAdapter(ArrayList<ArticlesDetails> artcle_arr, Context context) {
        this.artcle_arr = artcle_arr;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.title.setText("Headlines : "+ Html.fromHtml(artcle_arr.get(position).getTitle()));
        holder.description.setText( "Description : " + Html.fromHtml(artcle_arr.get(position).getDescription()));
        holder.url.setText(" Link : " + Html.fromHtml(artcle_arr.get(position).getUrl()));


        Glide.with(context)
                .load(artcle_arr.get(position).getUrlToImage())
                .fitCenter()
                .into(holder.img);

        holder.publishedAt.setText("Date : " + artcle_arr.get(position).getPublishedAt());


    }

    @Override
    public int getItemCount() {
        return artcle_arr.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title,description,url,urlImage,publishedAt;
        ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);

            title= (TextView) itemView.findViewById(R.id.title);
            description= (TextView) itemView.findViewById(R.id.description);
            url= (TextView) itemView.findViewById(R.id.url);
            urlImage= (TextView) itemView.findViewById(R.id.urlImage);
            publishedAt= (TextView) itemView.findViewById(R.id.publishedAt);

            img= (ImageView) itemView.findViewById(R.id.img);

        }
    }
}