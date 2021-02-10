package com.cip.yerayplasenciaramos.adicmecum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private TextView userNombre,userEmail,userID;
    private Button btnCerrarSesion, btnEliminarCta;
    private Button btn_farmacos, btn_congresos, btn_recursos;
    FirebaseAuth mAuth;
    private String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //userNombre = findViewById(R.id.userNombre);
        //userEmail = findViewById(R.id.userEmail);
        //userID = findViewById(R.id.userId);
        btnCerrarSesion = findViewById(R.id.btnLogout);
        btn_farmacos = findViewById(R.id.btn_farmacos);
        btn_congresos = findViewById(R.id.btn_congresos);
        btn_recursos = findViewById(R.id.btn_recursos);
        //btnEliminarCta = findViewById(R.id.btnEliminarCta);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        //userEmail.setText(user.getEmail());
        //userID.setText(user.getUid());

        btnCerrarSesion.setOnClickListener(view -> {
            mAuth.signOut();
            Intent intent = new Intent(MainActivity.this, loginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });

        btn_farmacos.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, FarmacosActivity.class);
            startActivity(i);
        });

        btn_congresos.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, CongresosActivity.class);
            startActivity(i);
        });

        btn_recursos.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, RecursosActivity.class);
            startActivity(i);
        });


       /*btnEliminarCta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                AuthCredential credential = EmailAuthProvider.getCredential(user.getEmail(), password);
                // Prompt the user to re-provide their sign-in credentials
                user.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    mAuth.signOut();
                                    Intent intent = new Intent(MainActivity.this, loginActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);

                                }else{
                                    Toast.makeText(getApplicationContext(), "No se pudo eliminar: "+task.getException(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                });
            }
        });*/
    }

}
