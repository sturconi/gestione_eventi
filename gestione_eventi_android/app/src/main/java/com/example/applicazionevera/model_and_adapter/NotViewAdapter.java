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

public class NotViewAdapter extends RecyclerView.Adapter < NotViewAdapter.NotViewHolder >{

    private ArrayList<NotData> notdata;



    public NotViewAdapter(ArrayList<NotData> array) {
        this.notdata = array;

    }

    @NonNull
    @Override
    public NotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.recyclerview_notifiche, parent, false);
        NotViewHolder viewHolder = new NotViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NotViewHolder holder, int position) {
        NotData notifica = notdata.get(position);


        holder.image.setImageResource(notifica.getImage());
        holder.testo.setText(notifica.getNotifica());


    }

    @Override
    public int getItemCount() {
        return notdata.size();
    }


    public static class NotViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView testo;


    public NotViewHolder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.FotoNotifica);
        testo = itemView.findViewById(R.id.TestoNotifica);
    }

    }


}

