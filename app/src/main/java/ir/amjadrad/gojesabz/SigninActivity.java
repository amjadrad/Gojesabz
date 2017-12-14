package ir.amjadrad.gojesabz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Amjad Qasemie Rad on 12/14/2017.
 */

public class SigninActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    String prefName = "myPref";
    String usernameKey = "un";
    String passwordKey = "pw";

    EditText etUsername, etPassword;
    Button btnLogin;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signin);
        sharedPreferences = getSharedPreferences(prefName, MODE_PRIVATE);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (sharedPreferences.contains(usernameKey)) {

                    String un = etUsername.getText().toString();
                    String pw = etPassword.getText().toString();

                    String unPref = sharedPreferences.getString(usernameKey , "!");
                    String pwPref = sharedPreferences.getString(passwordKey , "!");

                    if (un.equals(unPref) && pw.equals(pwPref)){
                        Intent intent = new Intent(SigninActivity.this , MainActivity.class);
                        startActivity(intent);

                    }else{
                        Toast toast = Toast.makeText(SigninActivity.this , "نام کاربری یا گذرواژه اشتباه است" , Toast.LENGTH_SHORT);
                        toast.show();
                    }
                } else {
                    // Go to Signup activity
                    startActivity(new Intent(SigninActivity.this , SignupActivity.class));

                }

            }
        });
    }
}
