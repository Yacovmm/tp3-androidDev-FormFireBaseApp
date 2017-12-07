package com.yacov.tp3_androiddev_firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

import static com.yacov.tp3_androiddev_firebase.ListViewActivity.idPosition;

public class InfoActivity extends AppCompatActivity {

    private String user_key = null;
    private TextView singlwName, singleCidade ,singleTel, singleCel, singleCpf, singleEmail , singleSenha;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);


        user_key = getIntent().getExtras().getString("UserID");

        singlwName = (TextView) findViewById(R.id.singleNameID);
        singleSenha = (TextView) findViewById(R.id.singleSenhaID);
        singleCpf = (TextView) findViewById(R.id.singleCpfID);
        singleTel = (TextView) findViewById(R.id.singleTelID);
        singleCel = (TextView) findViewById(R.id.singleCelID);
        singleEmail = (TextView) findViewById(R.id.singleEmailID);
        singleCidade = (TextView) findViewById(R.id.singleCidadeID);


        mDatabase = FirebaseDatabase.getInstance().getReference().child("Register");

        mDatabase.child(user_key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String stringName = (String) dataSnapshot.child("name").getValue();
                String stringSenha = (String) dataSnapshot.child("password").getValue();
                String stringTel = (String) dataSnapshot.child("tel").getValue();
                String stringCel = (String) dataSnapshot.child("cel").getValue();
                String stringEmail = (String) dataSnapshot.child("email").getValue();
                String stringCidade = (String) dataSnapshot.child("city").getValue();
                String stringCpf = (String) dataSnapshot.child("cpf").getValue();

                singlwName.setText("Name: "+ stringName);
                singleSenha.setText("Senha: " + stringSenha);
                singleCidade.setText("Cidade: "+ stringCidade);
                singleCpf.setText("Cpf: "+ stringCpf);
                singleTel.setText("Tel: "+ stringTel);
                singleCel.setText("Cel: "+ stringCel);
                singleEmail.setText("Email: "+ stringEmail);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
}
