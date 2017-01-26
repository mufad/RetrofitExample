package com.droiddigger.retrofitexample.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.droiddigger.retrofitexample.R;
import com.droiddigger.retrofitexample.api_interface.ApiInteface;
import com.droiddigger.retrofitexample.model.Customer;
import com.droiddigger.retrofitexample.model.ServerResponse;
import com.droiddigger.retrofitexample.model.User;
import com.droiddigger.retrofitexample.retrofit.RetrofitApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class    MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ApiInteface apiInterface;
    private EditText emailEditText;
    private EditText passwordEditText;

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create an instance of Interface
        apiInterface = RetrofitApiClient.getClient().create(ApiInteface.class);

        //Initialize the view like EditText, TextView
        viewInitialization();

    }
    
    public void sign_in(View view){
        showProgressDialog();
        String email=emailEditText.getText().toString();
        String password=passwordEditText.getText().toString();
        Log.d("Name", email);
        Customer customer= new Customer(email, password);

        Call<ServerResponse> call = apiInterface.getUserName(customer);

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                hideProgressDialog();
                ServerResponse validity = response.body();
                emailEditText.setText("");
                passwordEditText.setText("");
                Toast.makeText(getApplicationContext(), "Welcome "+validity.getMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {

            }
        });
    }
    
    public void register(View view){
        startActivity(new Intent(MainActivity.this, Register.class));
    }
    private void viewInitialization() {
        emailEditText = (EditText) findViewById(R.id.emailET);
        passwordEditText = (EditText) findViewById(R.id.passwordET);
    }
    private void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage("Please Wait..");
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    private void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }

    }
}
