package com.example.instagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    private final String TAG = "SignUpActivity";
    private EditText etEmail;
    private EditText etNewUserName;
    private EditText etNewPassword;
    private Button btnFinish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etEmail = findViewById(R.id.etNewEmail);
        etNewUserName = findViewById(R.id.etNewUserName);
        etNewPassword = findViewById(R.id.etNewPassword);
        btnFinish = findViewById(R.id.btnFinish);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etNewPassword.getText().toString();
                String NewUserName = etNewUserName.getText().toString();
                submitUser(email, password, NewUserName);
            }
        });
    }

    private void submitUser(String email, String password, String newUserName) {
        ParseUser user = new ParseUser();
        // Set core properties
        user.setUsername(newUserName);
        user.setPassword(password);
        user.setEmail(email);

        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    Log.d(TAG, "Sign up Succeed");
                    finish();

                } else {
                    Log.d(TAG, "Sign Up did not succeed");
                    e.printStackTrace();
                }
            }
        });
    }
}
