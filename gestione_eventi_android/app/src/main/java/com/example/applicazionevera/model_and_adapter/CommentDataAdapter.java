package com.example.applicazionevera.model_and_adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicazionevera.R;

import java.util.ArrayList;

public class CommentDataAdapter extends RecyclerView.Adapter <CommentDataAdapter.CommentDataViewHolder > {

    private ArrayList<CommentData> commentData;

    public CommentDataAdapter(ArrayList<CommentData> commentData) {
        this.commentData = commentData;
    }

    @NonNull
    @Override
    public CommentDataAdapter.CommentDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.itemlayout_comment, parent, false);
        CommentDataAdapter.CommentDataViewHolder viewHolder = new CommentDataAdapter.CommentDataViewHolder(listItem);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull CommentDataAdapter.CommentDataViewHolder holder, int position) {
        CommentData commentdata = commentData.get(position);


        holder.Image.setImageResource(commentdata.getImage());
        holder.commento.setText(commentdata.getCommento());
        holder.username.setText(commentdata.getUsername());
        holder.nome.setText(commentdata.getNome());
    }

    @Override
    public int getItemCount() {
        return commentData.size();
    }

    public static class CommentDataViewHolder extends RecyclerView.ViewHolder {
        ImageView Image;
       TextView commento,  username, nome;

        public CommentDataViewHolder(View itemView) {
            super(itemView);
            Image = itemView.findViewById(R.id.profile_photo);
            commento = itemView.findViewById(R.id.tv_commento);
            username = itemView.findViewById(R.id.tv_username);
            nome= itemView.findViewById(R.id.tv_name);
        }
    }

}
