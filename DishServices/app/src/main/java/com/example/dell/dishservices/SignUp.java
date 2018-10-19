package com.example.dell.dishservices;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.dell.dishservices.model.User;
import com.google.android.gms.maps.model.ButtCap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUp extends AppCompatActivity {
    private EditText userName,userEmail,userPassward,edtsecureCode;
    private Button regiSter;
    private ProgressDialog progressDialog;
    //defining AwesomeValidation object
    //private AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        // awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        setupUIVievs();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        //awesomeValidation.addValidation(this, R.id.reName, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        // awesomeValidation.addValidation(this, R.id.reEmail, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        // awesomeValidation.addValidation(this, R.id.rePassward, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.passworderror);


        regiSter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(SignUp.this);
                progressDialog.setMessage("Your Number is Registering....");
                progressDialog.show();
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(userEmail.getText().toString()).exists())
                        {
                            progressDialog.dismiss();
                            Toast.makeText(SignUp.this,"phone already register ",Toast.LENGTH_LONG);
                        }
                        else {
                            progressDialog.dismiss();
                            User user = new User(userName.getText().toString(),userPassward.getText().toString(),edtsecureCode.getText().toString());
                            table_user.child(userEmail.getText().toString()).setValue(user);
                            Toast.makeText(SignUp.this,"phone  register ",Toast.LENGTH_LONG).show();
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                }) ;




            }
        });
    }
    private void setupUIVievs()
    {
        userName=(EditText)findViewById(R.id.reName);
        userEmail=(EditText)findViewById(R.id.reEmail);
        userPassward=(EditText)findViewById(R.id.rePassward);
        regiSter=(Button)findViewById(R.id.register);
        edtsecureCode=(EditText)findViewById(R.id.secureCode);

    }

}
