package com.example.mess;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText date_main, breakfast, lunch, dinner, snacks, room_reg_email;
    Button btn_submit_main;

    FirebaseFirestore Auth= FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date_main= findViewById(R.id.date_main);
        breakfast= findViewById(R.id.breakfast);
        lunch= findViewById(R.id.lunch);
        dinner= findViewById(R.id.dinner);
        snacks= findViewById(R.id.snacks);
        btn_submit_main= findViewById(R.id.btn_submit_main);
        room_reg_email= findViewById(R.id.room_reg_email);

        btn_submit_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map<String, Object> Karan= new HashMap<>();
                Karan.put("Breakfast", breakfast.getText().toString());
                Karan.put("Lunch", lunch.getText().toString());
                Karan.put("Snacks", snacks.getText().toString());
                Karan.put("Dinner", dinner.getText().toString());

                if((date_main.getText().toString()).isEmpty()){
                    date_main.setError("Date cannot be Empty");
                }
                Auth.collection("612A")
                        .document(date_main.getText().toString())
                        .set(Karan)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Data Stored Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}