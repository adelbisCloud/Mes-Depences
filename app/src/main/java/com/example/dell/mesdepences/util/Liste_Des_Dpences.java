package com.example.dell.mesdepences.util;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dell.mesdepences.DataBase.DataBaseManager;
import com.example.dell.mesdepences.R;

import java.util.ArrayList;

import static android.R.attr.data;

public class Liste_Des_Dpences extends AppCompatActivity {

    ListView listView;

    private DataBaseManager data ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste__des__dpences);
        listView=(ListView)findViewById(R.id.listViewData);
        data=new DataBaseManager(this);
        showData();

    }
    public void showData(){
        ArrayList<String> listData = data.getAllData();
        ArrayAdapter arrayAdapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,listData);
        listView.setAdapter(arrayAdapter);

    }
}
