package com.example.shikha.navigationdrawer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class SecondActivity extends AppCompatActivity {
    TextInputLayout emaillayout;
    TextInputLayout passwordlayout;
    EditText email;
    EditText password;
    Button btn;
    RelativeLayout mroot;
    private View.OnClickListener msnackBarClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        emaillayout = (TextInputLayout) findViewById(R.id.input_email_layout);
        passwordlayout = (TextInputLayout) findViewById(R.id.input_layout_password);
        mroot = (RelativeLayout) findViewById(R.id.relativelayout);
        email = (EditText) findViewById(R.id.input_email);
        password = (EditText) findViewById(R.id.input_password);
    }


    private void submit(View v) {
        boolean isemptyemail = isemptyemail();
        boolean isemptypassword = isemptypassword();
        if (isemptyemail && isemptypassword) {
            Snackbar.make(mroot, "one or more fields are blank!", Snackbar.LENGTH_SHORT).
                    setAction(getString(R.string.text_dismiss), msnackBarClickListener).show();
        } else if (isemptyemail && !isemptypassword) {
            emaillayout.setError("Email cannot be blank1");
            passwordlayout.setError(null);
        } else if (!isemptyemail && isemptypassword) {
            passwordlayout.setError("pasword cannot be blank!");
            emaillayout.setError(null);
        } else {

        }


    }
    private boolean isemptyemail(){
        return email.getText()==null||
                email.getText().toString()==null
                ||email.getText().toString().isEmpty();
    }
    private boolean isemptypassword(){
        return password.getText()==null||
                password.getText().toString()==null
                ||password.getText().toString().isEmpty();
    }


}



