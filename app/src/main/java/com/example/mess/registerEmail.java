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

public class registerEmail extends AppCompatActivity {
    EditText name_reg_email, room_reg_email,email_reg_email;
    TextInputEditText password_reg_email, confirm_password_reg_email;
    Button btn_register_email;
    TextView tv_signIn_register_email, tv_registerPhone_register_email, tvOne, tvTwo, tvThree, tvFour, tvFive;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_email);

        name_reg_email= findViewById(R.id.name_reg_email);
        room_reg_email= findViewById(R.id.room_reg_email);
        email_reg_email= findViewById(R.id.email_reg_email);
        password_reg_email= findViewById(R.id.password_reg_email);
        confirm_password_reg_email= findViewById(R.id.confirm_password_reg_email);
        btn_register_email= findViewById(R.id.btn_register_email);
        tv_signIn_register_email= findViewById(R.id.tv_signIn_register_email);
        tv_registerPhone_register_email= findViewById(R.id.tv_registerPhone_register_email);
        tvOne= findViewById(R.id.tvOne);
        tvTwo= findViewById(R.id.tvTwo);
        tvThree= findViewById(R.id.tvThree);
        tvFour= findViewById(R.id.tvFour);
        tvFive= findViewById(R.id.tvFive);

        mAuth= FirebaseAuth.getInstance();
        btn_register_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((name_reg_email.getText().toString()).isEmpty()){
                    tvOne.setText("Name cannot be Empty");
                }
                else if((room_reg_email.getText().toString()).isEmpty()){
                    tvTwo.setText("Room Number cannot be Empty");
                }
                else if((email_reg_email.getText().toString()).isEmpty()){
                    tvThree.setText("Email cannot be Empty");
                }
                else if((password_reg_email.getText().toString()).isEmpty()){
                    tvFour.setText("Password cannot be Empty");
                }
                else if((confirm_password_reg_email.getText().toString()).isEmpty()){
                    tvFive.setText("Please confirm Password");
                }

                else{
                    mAuth.createUserWithEmailAndPassword(email_reg_email.getText().toString(), password_reg_email.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(registerEmail.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(registerEmail.this, signInEmail.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(registerEmail.this, "Failed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
    public void tv_signIn_register_email_listener(View view){
        Intent intent= new Intent(registerEmail.this, signInEmail.class);
        startActivity(intent);
    }
    public void tv_registerPhone_register_email_listener(View view){
        Intent intent= new Intent(registerEmail.this, registerPhone.class);
        startActivity(intent);
    }
}