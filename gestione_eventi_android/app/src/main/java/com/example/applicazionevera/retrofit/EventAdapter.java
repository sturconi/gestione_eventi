package com.example.applicazionevera.retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicazionevera.R;
import com.example.applicazionevera.model_and_adapter.RecyclerViewAdapter;

import java.util.List;

public class
EventAdapter extends RecyclerView.Adapter < EventAdapter.ViewHolder > {
    private List<Event> events;
    private RecyclerViewAdapter.OnEventListener mOnEventListener ;


    public EventAdapter(List<Event> array, RecyclerViewAdapter.OnEventListener onEventListener) {
        this.events = array;
        this.mOnEventListener = onEventListener;

    }
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.recyclerview_row, parent, false);
        EventAdapter.ViewHolder viewHolder = new EventAdapter.ViewHolder(listItem, mOnEventListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Event evento = events.get(position);
        holder.postimage.setImageResource(evento.getImmagine());
        holder.titolo.setText(evento.getNome_evento());
        holder.luogo.setText(evento.getLuogo());
        holder.mese.setText(evento.getData().substring(3,6));
        holder.giorno.setText(evento.getData().substring(0,2));
    }

    @Override
    public int getItemCount() {
        if (events == null)
            return 0;

        return events.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView postimage;
        TextView titolo, luogo, mese,giorno;
        RecyclerViewAdapter.OnEventListener onEventListener;

        public ViewHolder(View itemView, RecyclerViewAdapter.OnEventListener onEventListener) {
            super(itemView);
            postimage = itemView.findViewById(R.id.cardImage);
            giorno= itemView.findViewById(R.id.cardGiorno);
            titolo = itemView.findViewById(R.id.cardTitolo);
            luogo = itemView.findViewById(R.id.cardLuogo);
            mese = itemView.findViewById(R.id.cardMese);
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
