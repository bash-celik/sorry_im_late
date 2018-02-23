package com.gengar.sorryimlate.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gengar.sorryimlate.LateDB;
import com.gengar.sorryimlate.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<LateDB> list;

    private class Text extends RecyclerView.ViewHolder {
        private TextView textView;

        public Text(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
        }

    }

    public Adapter(List<LateDB> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Text(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.text,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((Text)holder).textView.setText(list.get(position).getDate().getTime().toString());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
