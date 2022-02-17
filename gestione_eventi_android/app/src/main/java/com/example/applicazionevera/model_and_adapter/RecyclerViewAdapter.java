package com.example.applicazionevera.model_and_adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicazionevera.R;


public class RecyclerViewAdapter extends RecyclerView.Adapter < RecyclerViewAdapter.ViewHolder > {
    private MyData[] mydata;
    // RecyclerView recyclerView;
    public RecyclerViewAdapter(MyData[] mydata) {
        this.mydata = mydata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.recyclerview_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MyData MyData = mydata[position];


        holder.postimage.setImageResource(mydata[position].getPostImage());
        holder.commento.setText(mydata[position].getCommento());
        holder.vmedia.setText(mydata[position].getVmedia());
        holder.titolo.setText(mydata[position].getTitolo());
        holder.luogo.setText(mydata[position].getLuogo());
        holder.data.setText(mydata[position].getData());
    }
    @Override
    public int getItemCount() {
        return mydata.length;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView postimage;
        TextView  commento, vmedia, titolo, luogo, data;

        public ViewHolder(View itemView) {
            super(itemView);
            postimage = itemView.findViewById(R.id.immagineEventoHome);
            commento = itemView.findViewById(R.id.nCommenti);
            vmedia = itemView.findViewById(R.id.ValutazioneMedia);
            titolo = itemView.findViewById(R.id.titoloEventoHome);
            luogo = itemView.findViewById(R.id.luogoEventoHome);
            data = itemView.findViewById(R.id.DataEventoHome);
        }
    }
}