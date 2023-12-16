package com.example.pr_20_angelika;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText inputName,inputLastName,inputMiddleName,inputHeight,inputWeight,inputPhoneNumber;
    Button btnSave, btnRead;
    private DatabaseReference myDatabase;
    final String USER_KEY = "User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputName = findViewById(R.id.editText);
        inputLastName = findViewById(R.id.editText2);
        inputMiddleName = findViewById(R.id.editText3);
        inputHeight = findViewById(R.id.editText4);
        inputWeight = findViewById(R.id.editText5);
        inputPhoneNumber = findViewById(R.id.editText6);

        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        btnRead = findViewById(R.id.btnRead);
        btnRead.setOnClickListener(this);

        myDatabase = FirebaseDatabase.getInstance().getReference(USER_KEY);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnSave){
            onSave();
        }
        else if(view.getId() == R.id.btnRead){
         //Reading
        }
    }

    public void onSave(){
        String ID = myDatabase.getKey();
        String Name = inputName.getText().toString();
        String LastName = inputLastName.getText().toString();
        String MiddleName = inputMiddleName.getText().toString();
        String Height = inputHeight.getText().toString();
        String Weight = inputWeight.getText().toString();
        String PhoneNumber = inputPhoneNumber.getText().toString();
        User user = new User(ID, Name, LastName, MiddleName, Height, Weight, PhoneNumber);
        myDatabase.push().setValue(user);
    }
}