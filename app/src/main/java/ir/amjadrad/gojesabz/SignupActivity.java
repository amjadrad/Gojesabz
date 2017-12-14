package ir.amjadrad.gojesabz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Amjad Qasemie Rad on 12/14/2017.
 */

public class SignupActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    String prefName = "myPref";
    String usernameKey = "un";
    String passwordKey = "pw";

    EditText etUsername, etPassword;
    Button btnSignup;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnSignup = (Button) findViewById(R.id.btnSignup);
        sharedPreferences = getSharedPreferences(prefName, MODE_PRIVATE);


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String un = etUsername.getText().toString();
                String pw = etPassword.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(usernameKey , un);
                editor.putString(passwordKey , pw);
                editor.commit();

                startActivity(new Intent(SignupActivity.this , SigninActivity.class));
                finish();

            }
        });



    }
}
