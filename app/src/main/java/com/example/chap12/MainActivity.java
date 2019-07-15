package com.example.chap12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button detailBtn, dialogBtn;
    ListView listView;

    ArrayAdapter<String> adapter;
    ArrayList<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detailBtn = findViewById(R.id.main_btn_detail);
        dialogBtn = findViewById(R.id.main_btn_dialog);
        listView = findViewById(R.id.main_list);

        datas = new ArrayList<>();
        datas.add("onCreate");
        adapter = new ArrayAdapter<String>(this, R.layout.item_main_list, datas);
        listView.setAdapter(adapter);

    }
}
