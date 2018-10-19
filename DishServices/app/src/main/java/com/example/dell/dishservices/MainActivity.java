package com.example.dell.dishservices;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.dishservices.common.Common;
import com.example.dell.dishservices.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private EditText U, P;
    private TextView forgetp1;
    private Button Login, signup;
    private LinearLayout scr;

    private ProgressDialog progressDialog;
    FirebaseDatabase database;
   DatabaseReference table_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        U = (EditText) findViewById(R.id.Name);
        P = (EditText) findViewById(R.id.Passward);
        forgetp1 = (TextView) findViewById(R.id.forgetp);
        Login = (Button) findViewById(R.id.Login);
        signup = (Button) findViewById(R.id.Sign_up);
        scr = (LinearLayout) findViewById(R.id.Screen);

         database = FirebaseDatabase.getInstance();
         table_user = database.getReference("User");


        //if(FirebaseDatabase.getInstance().getReference() !=null)
        //{
          //finish();
        //startActivity(new Intent(MainActivity.this,Home.class));
        //}

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        progressDialog = new ProgressDialog(MainActivity.this);
                        progressDialog.setMessage("Welcome to dish services");
                        progressDialog.show();


                        table_user.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                // get user info
                                if(dataSnapshot.child(U.getText().toString()).exists()) {
                                    progressDialog.dismiss();
                                    User user = dataSnapshot.child(U.getText().toString()).getValue(User.class);
                                    user.setPhone(U.getText().toString());
                                    if(user.getPassword().equals(P.getText().toString()))
                                    {
                                        Toast.makeText(MainActivity.this, "sign in sucessfully", Toast.LENGTH_LONG).show();
                                        Intent login = new Intent(MainActivity.this,Home.class);
                                        Common.currentUser = user;
                                        startActivity(login);
                                        finish();
                                    }
                                    else
                                    {
                                        Toast.makeText(MainActivity.this, "wrong passward", Toast.LENGTH_LONG).show();
                                    }
                                }
                                else
                                {
                                    progressDialog.dismiss();
                                    Toast.makeText(MainActivity.this, "user not present in database", Toast.LENGTH_LONG).show();

                                }

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }


                });
            }


        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignUp.class));
            }
        });
        forgetp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showForgetPwdDialog();

            }
        });
    }


    private void showForgetPwdDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Forget password");
        builder.setMessage("Enter your secure code");

        LayoutInflater inflater = this.getLayoutInflater();
        View forget_view = inflater.inflate(R.layout.forget_password,null);

        builder.setView(forget_view);
        builder.setIcon(R.drawable.ic_security_black_24dp);

        final EditText edtmail = (EditText)forget_view.findViewById(R.id.reEmail);
        final EditText edtSecureCode = (EditText)forget_view.findViewById(R.id.secureCode);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        User user = dataSnapshot.child(edtmail.getText().toString())
                                .getValue(User.class);
                        if (user.getSecureCode().equals(edtSecureCode.getText().toString()))
                            Toast.makeText(MainActivity.this,"Your passward :"+user.getPassword(),Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Wrong secure code !",Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();

    }
}




