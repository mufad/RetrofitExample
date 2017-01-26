package com.droiddigger.retrofitexample.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.droiddigger.retrofitexample.R;
import com.droiddigger.retrofitexample.api_interface.ApiInteface;
import com.droiddigger.retrofitexample.model.ServerResponse;
import com.droiddigger.retrofitexample.model.User;
import com.droiddigger.retrofitexample.retrofit.RetrofitApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {
    private ApiInteface apiInterface;
    EditText name, email, password;
    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        apiInterface = RetrofitApiClient.getClient().create(ApiInteface.class);
        initialize();
    }

    public void initialize(){
        name= (EditText) findViewById(R.id.nameET);
        email= (EditText) findViewById(R.id.emailET);
        password= (EditText) findViewById(R.id.passwordET);
    }
    public void register(View view) {
        showProgressDialog();
        User user=new User(name.getText().toString(), password.getText().toString(), email.getText().toString());
        Log.d("TAG", user.getName());

        Call<ServerResponse> call = apiInterface.getRegistrationToken(user);

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                ServerResponse validity = response.body();
                hideProgressDialog();
                Toast.makeText(getApplicationContext(), validity.getMessage(), Toast.LENGTH_LONG).show();
                startActivity(new Intent(Register.this, MainActivity.class));

            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"Error occurred", Toast.LENGTH_LONG).show();

            }
        });

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

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
