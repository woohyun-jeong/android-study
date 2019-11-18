package com.whjung.android_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 리사이클러뷰에 표시할 데이터 리스트 생성.
        ArrayList<Item> list = new ArrayList<>();
        for (int i=0; i<100; i++) {
            list.add(new Item(String.format("TEXT %d", i), false)) ;
        }

        // 리사이클러뷰에 LinearLayoutManager 객체 지정.
        RecyclerView recyclerView = findViewById(R.id.recycler) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this)) ;

        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
        SimpleAdapter adapter = new SimpleAdapter(list) ;
        recyclerView.setAdapter(adapter) ;

    }
}
