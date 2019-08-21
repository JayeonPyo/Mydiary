package com.example.mydiary;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        Intent intent = getIntent();
        String movieNm = intent.getStringExtra("movieNm");
        String directorNm = intent.getStringExtra("directorNm");
        String poster_path = intent.getStringExtra("poster_path");
        String prdtStartYear = intent.getStringExtra("prdtStartYear");
        String prdtEndYear = intent.getStringExtra("prdtEndYear");

        TextView textView_title = (TextView)findViewById(R.id.tv_title);
        textView_title.setText(movieNm);
        TextView textView_original_title = (TextView)findViewById(R.id.tv_director);
        textView_original_title.setText(directorNm);
        ImageView imageView_poster = (ImageView) findViewById(R.id.iv_poster);
        Glide.with(this)
                .load(poster_path)
                .centerCrop()
                .crossFade()
                .into(imageView_poster);

        TextView textView_overview = (TextView)findViewById(R.id.tv_prdtstart);
        textView_overview.setText(prdtStartYear);
        TextView textView_release_date = (TextView)findViewById(R.id.tv_prdtend);
        textView_release_date.setText(prdtEndYear);
    }


}
