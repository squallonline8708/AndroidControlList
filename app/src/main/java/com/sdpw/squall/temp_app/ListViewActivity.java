package com.sdpw.squall.temp_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    private ListView lvFruit;
    private ListView ScrolllvFruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        List<String> fruit=new ArrayList<String>();
        fruit.add("apple");
        fruit.add("pear");
        fruit.add("orange");
        fruit.add("grape");
        fruit.add("banana");

        lvFruit=(ListView)findViewById(R.id.lvFruit);

        //参数2：使用自定义的layout布局
        //adapter=new ArrayAdapter<String>(ListViewActivity.this,R.layout.list_item_fruit,fruit);
        //参数2：使用Android系统的layout布局
        adapter=new ArrayAdapter<String>(ListViewActivity.this,android.R.layout.simple_list_item_1,fruit);
        lvFruit.setAdapter(adapter);

        ScrolllvFruit = (ListView) findViewById(R.id.ScrolllvFruit);
        ScrolllvFruit.setAdapter(adapter);

        ScrolllvFruit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Res=parent.getItemAtPosition(position).toString();
                Toast t=Toast.makeText(getApplicationContext(),Res,Toast.LENGTH_SHORT);
                t.show();
            }
        });
    }
}
