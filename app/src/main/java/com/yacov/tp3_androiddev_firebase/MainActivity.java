package com.yacov.tp3_androiddev_firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText name, senha, email, tel, cel, cpf, city;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        database = FirebaseDatabase.getInstance();
        myRef = database.getInstance().getReference().child("Register");
        myRef.keepSynced(true);

        name = (EditText) findViewById(R.id.nameID);
        senha = (EditText) findViewById(R.id.senhaID);
        email = (EditText) findViewById(R.id.emailID);
        tel = (EditText) findViewById(R.id.telefoneID);
        cel = (EditText) findViewById(R.id.celularID);
        cpf = (EditText) findViewById(R.id.cpfID);
        city = (EditText) findViewById(R.id.cityID);
    }

    public void saveClick(View view){
        String nameString = name.getText().toString();
        String senhaString = senha.getText().toString();
        String emailString = email.getText().toString();
        String telString = tel.getText().toString();
        String celString = cel.getText().toString();
        String cpfString = cpf.getText().toString();
        String cityString = city.getText().toString();

        if (nameString.isEmpty() || senhaString.isEmpty() || emailString.isEmpty() || telString.isEmpty() ||
                celString.isEmpty() || cpfString.isEmpty() || cityString.isEmpty()){
            Toast.makeText(MainActivity.this, "Todos campos devem ser preenchidos", Toast.LENGTH_SHORT).show();

        }else {
            User user = new User(nameString, senhaString, emailString, telString, celString, cpfString, cityString);

            DatabaseReference newRegister = myRef.push();

            newRegister.setValue(user);

//            newRegister.child("name").setValue(nameString);
//            newRegister.child("password").setValue(senhaString);
//            newRegister.child("email").setValue(emailString);
//            newRegister.child("tel").setValue(telString);
//            newRegister.child("cel").setValue(celString);
//            newRegister.child("cpf").setValue(cpfString);
//            newRegister.child("city").setValue(cityString);

        }

    }

    public void viewLisClick(View view){
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);

    }

}
