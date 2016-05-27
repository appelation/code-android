package com.appelation.philatelycatalog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.appleation.library.Helper;
import com.appleation.library.User;
import com.appleation.library.UserSQLiteHelper;

import java.io.IOException;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    UserSQLiteHelper userSQLiteHelper = new UserSQLiteHelper(this);

    Button bSignUp;
    EditText etFirstName, etLastName, etEmail, etPassword, etConfirmPassword;
    AutoCompleteTextView atvCountry;

    String first_name, last_name, email, password, confirm_password, country;

    private boolean validateEditTexts() {

        etFirstName = (EditText) findViewById(R.id.etFirstName);

        if (etFirstName.getText().toString().trim().equals("")) {
            etFirstName.setError("Invalid first name. Please provide a valid first name!");
            return false;
        } else {
            etFirstName.setError(null);
        }

        etEmail = (EditText) findViewById(R.id.etEmail);

        if (!Helper.isValidEmail(etEmail.getText().toString().trim())) {
            etEmail.setError("Invalid email. Please provide a valid email address!");
            return false;
        } else {
            etEmail.setError(null);
        }

        etPassword = (EditText) findViewById(R.id.etPassword);

        if (!Helper.isValidPassword(etPassword.getText().toString().trim())) {
            etPassword.setError("Invalid password!. password must contains one digit from 0-9, must contains one lowercase characters, must contains one uppercase characters, must contains one special symbols in the list \"@#$%\", length at least 6 characters and maximum of 12.");
            return false;
        } else {
            etPassword.setError(null);
        }

        etConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);

        if (!Helper.isValidPassword(etPassword.getText().toString().trim(), etConfirmPassword.getText().toString().trim())) {
            etConfirmPassword.setError("Invalid confirm password!. confirm password should match with password. password must contains one digit from 0-9, must contains one lowercase characters, must contains one uppercase characters, must contains one special symbols in the list \"@#$%\", length at least 6 characters and maximum of 12.");
            return false;
        } else {
            etConfirmPassword.setError(null);
        }

        atvCountry = (AutoCompleteTextView) findViewById(R.id.atvCountry);

        if (atvCountry.getText().toString().trim().equals("")) {
            atvCountry.setError("Invalid country. Please provide a valid country name!");
            return false;
        } else {
            atvCountry.setError(null);
        }

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Get a reference to the AutoCompleteTextView in the layout
        AutoCompleteTextView atvCountry = (AutoCompleteTextView) findViewById(R.id.atvCountry);

        // Get the string array
        String[] countries = getResources().getStringArray(R.array.list_of_countries);

        // Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        atvCountry.setThreshold(2);
        atvCountry.setAdapter(adapter);

        bSignUp = (Button) findViewById(R.id.bSignUp);
        bSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()) {
                case R.id.bSignUp:
                    if (validateEditTexts()) {
                        Toast.makeText(getApplicationContext(), "sign up button clicked!", Toast.LENGTH_LONG).show();

                        etFirstName = (EditText) findViewById(R.id.etFirstName);
                        etLastName = (EditText) findViewById(R.id.etLastName);
                        etEmail = (EditText) findViewById(R.id.etEmail);
                        etPassword = (EditText) findViewById(R.id.etPassword);
                        etConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);
                        atvCountry = (AutoCompleteTextView) findViewById(R.id.atvCountry);

                        first_name = etFirstName.getText().toString();
                        last_name = etLastName.getText().toString();
                        email = etEmail.getText().toString();
                        password = etPassword.getText().toString();
                        confirm_password = etConfirmPassword.getText().toString();
                        country = atvCountry.getText().toString();

                        User user = new User();
                        user.setFirst_name(first_name);
                        user.setSurname(last_name);
                        user.setEmail(email);
                        user.setPassword(password);
                        user.setCountry(country);

                        Toast.makeText(getApplicationContext(), "inputs are -> " + user.getFirst_name() + " " + user.getSurname(), Toast.LENGTH_LONG).show();

                        userSQLiteHelper.insertUser(user, getApplicationContext());
                        userSQLiteHelper.exportDB(getApplicationContext());
                    }

                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
