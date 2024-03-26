package com.example.kalkulatorbangun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    Context context;
    List<Item> figure;
    private ItemClickListener mClickListener;
    public MyAdapter(Context context, List<Item> figure) {
        this.context = context;
        this.figure = figure;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.imageGeometry.setImageResource(figure.get(position).getImage());
        holder.title.setText(figure.get(position).getTitle());
        holder.description.setText(figure.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return figure.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageGeometry;

        TextView title,description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageGeometry = itemView.findViewById(R.id.Ivimage);
            title = itemView.findViewById(R.id.Tvtitle);
            description = itemView.findViewById(R.id.Tvdescription);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    public Item getItem(int id) {
        return figure.get(id);
    }
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}


