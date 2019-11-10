package com.androlord.music_shop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androlord.music_shop.Data.Songs;
import com.androlord.music_shop.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.myViewHolder> {
    ArrayList<Songs> list=new ArrayList<Songs>();
    Context context;
    public MusicListAdapter(Context context,ArrayList<Songs> list){
        this.list=list;
        this.context=context;
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_song,parent,false);
        myViewHolder myViewHolder=new myViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.artist.setText(list.get(position).artist);
        holder.songname.setText(list.get(position).name);
        Glide.with(context).asBitmap().load(list.get(position).cover).transform(new RoundedCorners(4)).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(holder.cover);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{
        ImageView cover;
        TextView songname,artist;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            cover=itemView.findViewById(R.id.singlesongcover);
            songname=itemView.findViewById(R.id.singlesongname);
            artist=itemView.findViewById(R.id.singlesinger);
        }
    }
}
