package com.cip.yerayplasenciaramos.adicmecum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cip.yerayplasenciaramos.adicmecum.model.Farmaco;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddFarmacoActivity extends AppCompatActivity {

    Button btn_addFarmaco,back;
    EditText nombre, efectosSecundarios, interaciones, indicaciones, posologia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_farmaco);

        btn_addFarmaco = findViewById(R.id.btn_addFarmaco);
        back = (Button) findViewById(R.id.back);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference adicmecumRef = database.getReference(FirebaseReferences.ADICMECUM_REFERENCES);

        nombre= (EditText) findViewById(R.id.nombre);
        efectosSecundarios= (EditText) findViewById(R.id.efectosSencundarios);
        indicaciones= (EditText) findViewById(R.id.indicaciones);
        interaciones= (EditText) findViewById(R.id.interaciones);
        posologia= (EditText) findViewById(R.id.posologia);

        back.setOnClickListener(v -> finish());

        btn_addFarmaco.setOnClickListener(v -> {
            if (!nombre.getText().toString().isEmpty() && !efectosSecundarios.getText().toString().isEmpty() && !indicaciones.getText().toString().isEmpty() && !interaciones.getText().toString().isEmpty() && !posologia.getText().toString().isEmpty()){
                Farmaco farmaco = new Farmaco(nombre.getText().toString(), efectosSecundarios.getText().toString(), indicaciones.getText().toString(), interaciones.getText().toString(), posologia.getText().toString());
                adicmecumRef.child(FirebaseReferences.FARMACOS_REFERENCES).push().setValue(farmaco);
                Toast.makeText(getBaseContext(), "Elemento Insertado", Toast.LENGTH_LONG).show();
                Intent i = new Intent(AddFarmacoActivity.this, FarmacosActivity.class);
                startActivity(i);
            }else{
                Toast.makeText(getBaseContext(), "Error: Revisar Campos", Toast.LENGTH_LONG).show();
            }
        });
    }
}