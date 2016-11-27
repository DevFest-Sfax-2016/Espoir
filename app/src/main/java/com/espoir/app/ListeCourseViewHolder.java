package com.espoir.app;

/**
 * Created by Lenovo on 14/11/2016.
 */


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URI;
public class ListeCourseViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener, ItemClickListener, View.OnCreateContextMenuListener {

    public TextView titleView;
    public TextView authorView;
    public ImageView starView;
    public ImageView imageView_liste_course;
    public TextView numStarsView;
    ItemClickListener itemClickListenerS;
    ItemClickListener itemClickListenerL;

    private Context c=null;


    public ListeCourseViewHolder(View itemView) {
        super(itemView);


        titleView = (TextView) itemView.findViewById(R.id.textView2);
        authorView = (TextView) itemView.findViewById(R.id.date1);
        starView = (ImageView) itemView.findViewById(R.id.star2);
        imageView_liste_course = (ImageView) itemView.findViewById(R.id.imageView3);
        c=itemView.getContext();

    }

    public void setSimpleOnClickLitener(ItemClickListener simpleOnClickLitener) {
        this.itemClickListenerS = simpleOnClickLitener;

    }

    public void bindToPost(Status post, View.OnClickListener starClickListener) {
        titleView.setText(post.getAuthor());
        authorView.setText(post.getBody());

        Picasso.with(c).load(post.getIamge()).into(imageView_liste_course);
      //  Log.v("ssssssssssssssssss", post.getIamge());
    //    starView.setOnClickListener(starClickListener);
    }

    public void bindToPostLog(Status post, View.OnLongClickListener starClickListener) {
        titleView.setText(post.getAuthor());
        authorView.setText(post.getIamge());

        Picasso.with(c).load(post.getBody()).into(imageView_liste_course);
       Log.v("ssssssssssssssssss", post.getBody());
        starView.setOnLongClickListener(starClickListener);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("gérer ma liste d'achat");
        menu.add(0,0,0,"gerer articles de ma liste");
        menu.add(0,1,0,"modifier ma liste");
        menu.add(0,2,0,"supprimer ma liste");
        menu.add(0,3,0,"archiver ma liste");
    }

    @Override
    public boolean onLongClick(View v) {

        this.itemClickListenerL.onClick(v,getLayoutPosition(),false);
        return false;
    }

    @Override
    public void onClick(View view, int position, boolean isLongClick) {
        this.itemClickListenerS.onClick(view,getLayoutPosition(),false);

    }

    @Override
    public void onClick(View v) {

    }
}
