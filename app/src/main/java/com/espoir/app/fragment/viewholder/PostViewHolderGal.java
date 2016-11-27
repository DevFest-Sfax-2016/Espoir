package com.espoir.app.fragment.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.espoir.app.Gallery;
import com.espoir.app.R;
import com.squareup.picasso.Picasso;

public class PostViewHolderGal extends RecyclerView.ViewHolder {

    public TextView titleView;
    public ImageView imageView;
    public ImageView starView;
    Context c;

    public PostViewHolderGal(View itemView) {
                super(itemView);

        titleView = (TextView) itemView.findViewById(R.id.titreGal);

        imageView = (ImageView) itemView.findViewById(R.id.imagegal);
        starView = (ImageView) itemView.findViewById(R.id.star2);
        c=itemView.getContext();

    }

    public void bindToPost(Gallery post, View.OnClickListener starClickListener) {
        titleView.setText(post.getTitre());
          Picasso.with(c).load(post.getImage()).into(imageView);
        starView.setOnClickListener(starClickListener);
    }
}
