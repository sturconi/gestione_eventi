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

public class EvCatAdapter  extends RecyclerView.Adapter <EvCatAdapter.EvCatViewHolder > {
    private ArrayList<EvCatData> evcatdata;
    private OnEventListener eOnEventListener ;


    public EvCatAdapter(ArrayList<EvCatData> array, OnEventListener onEventListener) {
        this.evcatdata = array;
        this.eOnEventListener = onEventListener;

    }
    @Override
    public EvCatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.recyclerview_eventcat, parent, false);
        EvCatViewHolder viewHolder = new EvCatViewHolder(listItem, eOnEventListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EvCatViewHolder holder, int position) {
        EvCatData eventcat = evcatdata.get(position);


        holder.Image.setImageResource(eventcat.getImage());
        holder.indirizzo.setText(eventcat.getIndirizzo());
        holder.titolo.setText(eventcat.getTitolo());
        holder.data.setText(eventcat.getData());

    }


    @Override
    public int getItemCount() {
        return evcatdata.size();
    }



    public static class EvCatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView Image;
        TextView titolo, indirizzo, data;
        EvCatAdapter.OnEventListener onEventListener;

        public EvCatViewHolder(View itemView, OnEventListener onEventListener) {
            super(itemView);
            Image = itemView.findViewById(R.id.immagineEvCat);
            indirizzo = itemView.findViewById(R.id.indirizzoEv);
            titolo = itemView.findViewById(R.id.titoloEv);
            data = itemView.findViewById(R.id.dataEv);

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