package com.example.mydiary;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.RecyclerViewHolders> {

    private ArrayList<Data> mDataList;
    private LayoutInflater mInflate;
    private Context mContext;


    public MyRecyclerViewAdapter(Context context, ArrayList<Data> itemList) {
        this.mContext = context;
        this.mInflate = LayoutInflater.from(context);
        this.mDataList = itemList;
    }


    @NonNull
    @Override
    public RecyclerViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflate.inflate(R.layout.list_item, parent, false);
        RecyclerViewHolders viewHolder = new RecyclerViewHolders(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolders holder, final int position) {

        String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?key=451f608c5da2b0f5abd1cc0fc9a9cd2a";
        Glide.with(mContext)
                .load(url)
                .centerCrop()
                .crossFade()
                .into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("movieNm", mDataList.get(position).getMovieNum());
                intent.putExtra("directorNm", mDataList.get(position).getDirectorNum());
              //  intent.putExtra("poster_path", mDataList.get(position).getPoster_path());
                intent.putExtra("prdtStartYear", mDataList.get(position).getPrdtStartYear());
                intent.putExtra("prdtEndYear", mDataList.get(position).getPrdtEndYear());
                mContext.startActivity(intent);
                Log.d("Adapter", "Clcked: " + position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return this.mDataList.size();
    }



    public static class RecyclerViewHolders extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public RecyclerViewHolders(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}

