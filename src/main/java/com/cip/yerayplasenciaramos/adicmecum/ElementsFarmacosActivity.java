package com.cip.yerayplasenciaramos.adicmecum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cip.yerayplasenciaramos.adicmecum.model.Farmaco;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class ElementsFarmacosActivity extends AppCompatActivity {

    Button back, btn_upd, btn_del;
    EditText efectosSecundarios, interaciones, indicaciones, posologia;
    TextView nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elements_farmacos);

        back = (Button) findViewById(R.id.back);
        btn_upd = (Button) findViewById(R.id.btn_upd);
        btn_del  = (Button) findViewById(R.id.btn_del);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference adicmecumRef = database.getReference(FirebaseReferences.ADICMECUM_REFERENCES);

        nombre= (TextView) findViewById(R.id.nombre);
        efectosSecundarios= (EditText) findViewById(R.id.efectosSencundarios);
        indicaciones= (EditText) findViewById(R.id.indicaciones);
        interaciones= (EditText) findViewById(R.id.interaciones);
        posologia= (EditText) findViewById(R.id.posologia);

        Intent i = getIntent();

        nombre.setText(i.getStringExtra("nombre"));
        efectosSecundarios.setText(i.getStringExtra("efectosSecundarios"));
        indicaciones.setText(i.getStringExtra("indicaciones"));
        interaciones.setText(i.getStringExtra("interaciones"));
        posologia.setText(i.getStringExtra("posologia"));

        back.setOnClickListener(v -> finish());

        btn_upd.setOnClickListener(v -> {
            if (!nombre.getText().toString().isEmpty() && !efectosSecundarios.getText().toString().isEmpty() && !indicaciones.getText().toString().isEmpty() && !interaciones.getText().toString().isEmpty() && !posologia.getText().toString().isEmpty()){
                Farmaco farmaco = new Farmaco(
                        nombre.getText().toString(),
                        efectosSecundarios.getText().toString(),
                        indicaciones.getText().toString(),
                        interaciones.getText().toString(),
                        posologia.getText().toString());
                Query query = adicmecumRef.child(FirebaseReferences.FARMACOS_REFERENCES).orderByChild("nombre").equalTo(farmaco.getNombre());
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String key = "";
                        for(DataSnapshot objeto : snapshot.getChildren()){
                            key = objeto.getKey(); //Obtenemos el id del registro para poderlo editar
                        }
                        Map<String, Object> farmacoMap = new HashMap();
                        farmacoMap.put("nombre", farmaco.getNombre());
                        farmacoMap.put("efectosSecundarios", farmaco.getEfectosSecundarios());
                        farmacoMap.put("indicaciones", farmaco.getIndicaciones());
                        farmacoMap.put("interacciones", farmaco.getInteracciones());
                        farmacoMap.put("posologia", farmaco.getPosologia());
                        adicmecumRef.child(FirebaseReferences.FARMACOS_REFERENCES).child(key).updateChildren(farmacoMap);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                Toast.makeText(getBaseContext(), "Elemento Actualizado", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getBaseContext(), "Error: Revisar Campos", Toast.LENGTH_LONG).show();
            }
        });

        btn_del.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(ElementsFarmacosActivity.this);

            builder.setTitle(" - Confirmar - ");
            builder.setMessage("Estas seguro que deseas eliminar ?");

            builder.setPositiveButton("SI",(dialog, which) -> {
                if (!nombre.getText().toString().isEmpty() && !efectosSecundarios.getText().toString().isEmpty() && !indicaciones.getText().toString().isEmpty() && !interaciones.getText().toString().isEmpty() && !posologia.getText().toString().isEmpty()){
                    Farmaco farmaco = new Farmaco();
                    farmaco.setNombre(nombre.getText().toString());
                    Query query = adicmecumRef.child(FirebaseReferences.FARMACOS_REFERENCES).orderByChild("nombre").equalTo(farmaco.getNombre());
                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for(DataSnapshot objeto : snapshot.getChildren()){
                                objeto.getRef().removeValue();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                Toast.makeText(getBaseContext(), "Elemento eliminado", Toast.LENGTH_LONG).show();
                Intent i1 = new Intent(ElementsFarmacosActivity.this, FarmacosActivity.class);
                startActivity(i1);
            });

            builder.setNegativeButton("NO", (dialog, which) -> dialog.dismiss());

            AlertDialog alert = builder.create();
            alert.show();
        });

    }
}