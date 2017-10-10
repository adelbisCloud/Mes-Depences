package com.example.dell.mesdepences.util;

import com.example.dell.mesdepences.Component.DatePickerFragment;
//import com.example.dell.mesdepences.DAO.MesDepencesDao;
import com.example.dell.mesdepences.DataBase.DataBaseManager;
import com.example.dell.mesdepences.R;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText Depence_Montant;
    EditText Depence_Description;
    Spinner Depence_Categorie;
    Button boutton_date;
    Button boutton_Ajouter;
    Button boutton_Afficher;

    //private Depences depencesExtra;
    private DataBaseManager data ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boutton_date = (Button) findViewById(R.id.btDate);
        boutton_date.setOnClickListener(this);

        Depence_Montant= (EditText) findViewById(R.id.editMontant);

        boutton_Ajouter = (Button) findViewById(R.id.btAjouter);
        boutton_Ajouter.setOnClickListener(this);

        boutton_Afficher = (Button) findViewById(R.id.btViewAll);
        boutton_Afficher.setOnClickListener(this);

        Depence_Description =(EditText)findViewById(R.id.editDescription);

        Depence_Categorie=(Spinner)findViewById(R.id.category_depence);

        data=new DataBaseManager(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btDate) {
            new DatePickerFragment().show(getFragmentManager(), "datePicker");
        }else if (id == R.id.btViewAll){
            Intent intent=new Intent(this,Liste_Des_Dpences.class);
            startActivity(intent);

        }else if (id == R.id.btAjouter){
            if (Depence_Montant.getText().toString().isEmpty()){
                Depence_Montant.setError("Ajouter la Montant");
                return;
            }
            if (Depence_Description.getText().toString().isEmpty()){
                Depence_Description.setError("Ajouter une description");
                return;
            }

            Toast.makeText(this,"ok",Toast.LENGTH_LONG).show();
            boolean isInserted = data.insertData(Depence_Description.getText().toString());

            if(isInserted == true) {
                Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();

            }
            else{
                Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
            }
        }

        }


    }


