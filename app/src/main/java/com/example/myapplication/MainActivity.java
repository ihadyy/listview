package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private Button btnShow;
    private ListView list1;
    private String[] arr;
    private ArrayAdapter<String> adapter;
    private ImageView imageView;
    private ArrayList<Integer> imageList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView);
        imageList = new ArrayList<>();
        imageList.add(R.drawable.img_1);
        imageList.add(R.drawable.img_2);
        imageList.add(R.drawable.img);
        imageList.add(R.drawable.img_3);
        imageList.add(R.drawable.img_4);
        imageList.add(R.drawable.img_5);
        initViews();
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list1.setAdapter(adapter);
            }
        });
        list1.setOnItemClickListener(this);
    }

    private void initViews() {
        btnShow=findViewById(R.id.btnShowList);
        list1=findViewById(R.id.lstStones);
        initArray();
        adapter=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arr);
    }

    private void initArray() {
        arr= getResources().getStringArray(R.array.games);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, arr[position].toString()+" Was clicked..", Toast.LENGTH_SHORT).show();
        imageView.setImageResource(imageList.get(position));
    }
}