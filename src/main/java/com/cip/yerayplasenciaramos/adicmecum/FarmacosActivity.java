package com.cip.yerayplasenciaramos.adicmecum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.cip.yerayplasenciaramos.adicmecum.model.Farmaco;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.ktx.Firebase;

import java.util.ArrayList;
import java.util.List;

public class FarmacosActivity extends AppCompatActivity {

    private List<Farmaco> listFarmaco = new ArrayList<Farmaco>();
    ArrayAdapter<Farmaco> arrayAdapterFarmaco;

    ListView listV_Farmacos;
    Button btn_addFarmaco, back;

    FirebaseDatabase database;
    DatabaseReference adicmecumRef; //final

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmacos);

        back = findViewById(R.id.back);
        btn_addFarmaco = findViewById(R.id.btn_addFarmaco);
        listV_Farmacos = findViewById(R.id.lv_datosFarmacos);

        //database = FirebaseDatabase.getInstance();
        //adicmecumRef = database.getReference(FirebaseReferences.ADICMECUM_REFERENCES);
        //DatabaseReference farmacoaRef = database.getReference(FirebaseReferences.FARMACOS_REFERENCES);
        //adicmecumRef.child(FirebaseReferences.FARMACOS_REFERENCES).push().setValue(farmaco);
        inicilizaFirebase();
        listarDatos();

        back.setOnClickListener(v -> finish());

        btn_addFarmaco.setOnClickListener(v -> {
            Intent i = new Intent(FarmacosActivity.this, AddFarmacoActivity.class);
            startActivity(i);
        });
    }

    private void listarDatos() {
        adicmecumRef.child(FirebaseReferences.FARMACOS_REFERENCES).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listFarmaco.clear();
                for (DataSnapshot objSnapchot : snapshot.getChildren()){
                    Farmaco f = objSnapchot.getValue(Farmaco.class);
                    listFarmaco.add(f);

                    arrayAdapterFarmaco = new ArrayAdapter<Farmaco>(FarmacosActivity.this, android.R.layout.simple_list_item_1, listFarmaco);
                    listV_Farmacos.setAdapter(arrayAdapterFarmaco);

                    listV_Farmacos.setOnItemClickListener((parent, view, position, id) -> {
                        Farmaco farmacoSelected = (Farmaco) parent.getItemAtPosition(position);
                        Intent i = new Intent(FarmacosActivity.this,ElementsFarmacosActivity.class);
                        i.putExtra("nombre",farmacoSelected.getNombre());
                        i.putExtra("efectosSecundarios",farmacoSelected.getEfectosSecundarios());
                        i.putExtra("indicaciones",farmacoSelected.getIndicaciones());
                        i.putExtra("interaciones",farmacoSelected.getInteracciones());
                        i.putExtra("posologia",farmacoSelected.getPosologia());
                        startActivity(i);
                    });
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void inicilizaFirebase(){
        database = FirebaseDatabase.getInstance();
        adicmecumRef = database.getReference(FirebaseReferences.ADICMECUM_REFERENCES);
        DatabaseReference farmacoaRef = database.getReference(FirebaseReferences.FARMACOS_REFERENCES);
    }
}