package com.example.mess;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signInEmail extends AppCompatActivity {

    EditText name_signIn_email, room_signIn_email, email_signIn_email;
    TextInputEditText password_signIn_email;
    TextView tvSix, tvSeven, tvEight, tvNine, tv_Register_signIn_email, tv_signInPhone_signIn_email;
    Button btn_signIn_email;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_email);

        btn_signIn_email= findViewById(R.id.btn_signIn_email);
        name_signIn_email= findViewById(R.id.name_signIn_email);
        room_signIn_email= findViewById(R.id.room_signIn_email);
        email_signIn_email= findViewById(R.id.email_signIn_email);
        password_signIn_email= findViewById(R.id.password_signIn_email);
        tvSix= findViewById(R.id.tvSix);
        tvSeven= findViewById(R.id.tvSeven);
        tvEight= findViewById(R.id.tvEight);
        tvNine= findViewById(R.id.tvNine);
        tv_Register_signIn_email= findViewById(R.id.tv_Register_signIn_email);
        tv_signInPhone_signIn_email= findViewById(R.id.tv_signInPhone_signIn_email);

        mAuth= FirebaseAuth.getInstance();
        btn_signIn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((name_signIn_email.getText().toString()).isEmpty()){
                    tvSix.setText("Name cannot be Empty");
                }
                else if((room_signIn_email.getText().toString()).isEmpty()){
                    tvSeven.setText("Room Number cannot be empty");
                }
                else if((email_signIn_email.getText().toString()).isEmpty()){
                    tvEight.setText("Email cannot be Empty");
                }
                else if((password_signIn_email.getText().toString()).isEmpty()){
                    tvNine.setText("Password cannot be Empty");
                }
                else{
                    mAuth.signInWithEmailAndPassword(email_signIn_email.getText().toString(), password_signIn_email.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(signInEmail.this, "Sucessfull", Toast.LENGTH_SHORT).show();
                                Intent intent= new Intent(signInEmail.this, MainActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(signInEmail.this, "Failed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
    public void tv_Register_signIn_email_listener(View view){
        Intent intent= new Intent(signInEmail.this, registerEmail.class);
        startActivity(intent);
    }
    public void tv_signInPhone_signIn_email_listener(View view){
        Intent intent= new Intent(signInEmail.this,signInPhone.class );
        startActivity(intent);
    }
}