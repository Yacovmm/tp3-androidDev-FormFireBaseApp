package com.yacov.tp3_androiddev_firebase;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Map;

public class ListViewActivity extends ListActivity {

    private DatabaseReference databaseReference;
    FirebaseListAdapter<User> firebaseListAdapter;
    private ArrayList<String> nameList = new ArrayList<>();
    static int idPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Register");

        final FirebaseListOptions<User> options = new FirebaseListOptions.Builder<User>()
                .setQuery(databaseReference, User.class)
                .setLayout(android.R.layout.simple_list_item_1)
                .build();

        ListView myList = getListView();

        try {

            firebaseListAdapter = new FirebaseListAdapter<User>(options) {
                @Override
                protected void populateView(View view, final User model, final int position) {

                    final String user_key = getRef(position).getKey().toString();
                    final TextView name = (TextView) view.findViewById(android.R.id.text1);
                    name.setText(model.getName());

                    view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplicationContext(), "User" + model.getName() , Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
                            intent.putExtra("UserID", user_key);
                            startActivity(intent);

                        }
                    });


                }
            };

            myList.setAdapter(firebaseListAdapter);








        }catch (Exception e){
            Log.d("Error", e.getMessage());
        }
    }

//    @Override
//    protected void onListItemClick(ListView l, View v, int position, long id) {
//        super.onListItemClick(l, v, position, id);
//
//        Intent intent = new Intent(this, InfoActivity.class);
//        startActivity(intent);
//
//    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseListAdapter.startListening();
    }


    @Override
    protected void onStop() {
        super.onStop();
        firebaseListAdapter.stopListening();
    }
}
