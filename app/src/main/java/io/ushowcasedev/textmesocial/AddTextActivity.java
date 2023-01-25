package io.ushowcasedev.textmesocial;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AddTextActivity extends AppCompatActivity {

    // creating variables for
    // EditText and buttons.
    private EditText userName;
    private EditText wText;
    private MaterialButton sendDatabtn;

    // creating a variable for our
    // Firebase Database.
    FirebaseDatabase database= FirebaseDatabase.getInstance();

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference myRef = database.getReference("Messages");

    //Adapters
    Messages text;

    //Array List
    ArrayList<Messages> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_text);
        list = new ArrayList<>();

        userName = findViewById(R.id.usernameEdit);
        wText = findViewById(R.id.editText);

        sendDatabtn = findViewById(R.id.sendBtn);
        sendDatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting text from our edittext fields.
                String nameValue = userName.getText().toString();
                String textValue = wText.getText().toString();
                String admin = "Admin";

                // below line is for checking whether the
                // edittext fields are empty or not.
                if (textValue.isEmpty()) {
                    Toast.makeText(AddTextActivity.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (nameValue.isEmpty()) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(AddTextActivity.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    // else call the method to add
                    // data to our database.
                    addDatatoFirebase(nameValue, textValue);
                    finish();
                }
            }
        });

    }

        private void addDatatoFirebase(String name, String wText) {
            // below 3 lines of code is used to set
            // data in our object class.
            Messages.setuserName(name);
            Messages.setText(wText);

            myRef.child(name).child("text").setValue(wText);
            myRef.child(name).child("username").setValue(name);
            // we are use add value event listener method
            // which is called with database reference.
            /*myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    // inside the method of on Data change we are setting
                    // our object class to our database reference.
                    // data base reference will sends data to firebase.
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                        //Messages userName = dataSnapshot.getValue(Messages.class);
                        //list.add(userName);
                        myRef.setValue(text);

                    }

                    // after adding this data we are showing toast message.
                    Toast.makeText(AddTextActivity.this, "data added", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    // if the data is not added or it is cancelled then
                    // we are displaying a failure toast message.
                    Toast.makeText(AddTextActivity.this, "Fail to add data" + error, Toast.LENGTH_SHORT).show();
                }
            });

             */
        }

    }