package com.droiddigger.retrofitexample.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.droiddigger.retrofitexample.R;
import com.droiddigger.retrofitexample.api_interface.ApiInteface;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create an instance of Interface
        apiInterface = RetrofitApiClient.getClient().create(ApiInteface.class);

        //Initialize the view like EditText, TextView
        viewInitialization();

    }


    // Login button event
    public void buttonClickEvent(View view){

        if(view.getId()==R.id.login_button){
            String userId;
            String password;
            User user = new User();

            userId = userIdEditText.getText().toString();
            password = passwordEditText.getText().toString();

            user.setUserId(userId);
            user.setPassword(password);

            checkUserValidity(user);
        }
        else {
            String userId;

            userId = jokeUserIdEditText.getText().toString();

            getJokeFromServer(userId);
        }

    }
    
    public void sign_in(View view){
        String email=emailEditText.getText().toString();
        String password=passwordEditText.getText().toString();
    }
    
    public void register(View view){
        startActivity(new Intent(MainActivity.this, Register.class));
    }


    // POST method to determine user validity
    private void checkUserValidity(User userCredential){

        Call<ServerResponse> call = apiInterface.getUserValidity(userCredential);

        call.enqueue(new Callback<ServerResponse>() {

            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {

                ServerResponse validity = response.body();
                Toast.makeText(getApplicationContext(), validity.getMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }


    // GET method to get a Joke from remote server
    private void getJokeFromServer(String userId) {

        Call<ServerResponse> call = apiInterface.getJoke(userId);

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                ServerResponse validity = response.body();
                jokeTextView.setText(validity.getMessage());
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }


    private void viewInitialization() {
        emailEditText = (EditText) findViewById(R.id.emailET);
        passwordEditText = (EditText) findViewById(R.id.passwordET);
    }
}
