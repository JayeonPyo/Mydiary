package com.example.mydiary;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TestActivity extends AppCompatActivity {

    private TestAdapter adapter = new TestAdapter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //recycleView 초기화
        RecyclerView recyclerView = findViewById(R.id.recycler_view1);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        //아이템 로드
        adapter.setItems(new SampleData().getItems());

    }
}

