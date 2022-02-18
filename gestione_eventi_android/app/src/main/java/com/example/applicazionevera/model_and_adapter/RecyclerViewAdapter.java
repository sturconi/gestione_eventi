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

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter < RecyclerViewAdapter.ViewHolder > {
    private ArrayList<MyData> mydata;
    private OnEventListener mOnEventListener ;


    public RecyclerViewAdapter(ArrayList<MyData> array, OnEventListener onEventListener) {
        this.mydata = array;
        this.mOnEventListener = onEventListener;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.recyclerview_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem, mOnEventListener);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        MyData evento = mydata.get(position);


        holder.postimage.setImageResource(evento.getPostImage());
        holder.commento.setText(evento.getCommento());
        holder.vmedia.setText(evento.getVmedia());
        holder.titolo.setText(evento.getTitolo());
        holder.luogo.setText(evento.getLuogo());
        holder.data.setText(evento.getData());
    }
    @Override
    public int getItemCount() {
        return mydata.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView postimage;
        TextView  commento, vmedia, titolo, luogo, data;
        OnEventListener onEventListener;

        public ViewHolder(View itemView, OnEventListener onEventListener) {
            super(itemView);
            postimage = itemView.findViewById(R.id.immagineEventoHome);
            commento = itemView.findViewById(R.id.nCommenti);
            vmedia = itemView.findViewById(R.id.ValutazioneMedia);
            titolo = itemView.findViewById(R.id.titoloEventoHome);
            luogo = itemView.findViewById(R.id.luogoEventoHome);
            data = itemView.findViewById(R.id.DataEventoHome);

            this.onEventListener = onEventListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onEventListener.onEventClick(getAdapterPosition());
        }
    }

    public interface OnEventListener{
        void onEventClick(int position);
    }
}