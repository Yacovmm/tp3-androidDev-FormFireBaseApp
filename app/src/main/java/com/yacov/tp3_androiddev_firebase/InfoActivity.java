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
    private TextView singlwName, singleSenha;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);


        user_key = getIntent().getExtras().getString("UserID");

        singlwName = (TextView) findViewById(R.id.singleNameID);
        singleSenha = (TextView) findViewById(R.id.singleSenhaID);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Register");

        mDatabase.child(user_key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String stringName = (String) dataSnapshot.child("name").getValue();
                String stringSenha = (String) dataSnapshot.child("password").getValue();

                singlwName.setText(stringName);
                singleSenha.setText(stringSenha);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
}
