package com.example.pushkar.seniordesign;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button loginButton;
    EditText usernameEditText;
    EditText passwordEditText;
    String responseStr=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton = (Button)findViewById(R.id.loginButtonID);
        usernameEditText = (EditText)findViewById(R.id.usernameEditTextID);
        passwordEditText = (EditText) findViewById(R.id.passwordEditTextID);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginButtonClicked();
            }
        });


    }

    private void loginButtonClicked(){
        String passwordString,usernameString;
        usernameString = usernameEditText.getText().toString();
        passwordString = passwordEditText.getText().toString();
        if(!(usernameString.equalsIgnoreCase("") || passwordString.equalsIgnoreCase(""))){
            //call query
            //if true call goToNextPage
            Log.i("credentials",""+usernameString);
            Log.i("credentials",""+passwordString);
            new Send().execute();
            //goToNextPage();

        }

    }

    private void goToNextPage(){
        Intent intent = new Intent(MainActivity.this,Home.class);
        startActivity(intent);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.
                INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }

    public class Send extends AsyncTask<String, Void,Long > {


        @Override
        protected Long doInBackground(String... urls) {

            String Name= "pushkar";


            HttpClient httpclient = new DefaultHttpClient();

            //HttpPost httppost = new HttpPost("https://httpbin.org/cache");
            HttpPost httppost = new HttpPost("https://postman-echo.com/post");

            try {
                // Add your data
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
                nameValuePairs.add(new BasicNameValuePair("Name", Name));
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                Log.i("onPost1"," aftersetEntity");

                // Execute HTTP Post Request
                HttpResponse response = httpclient.execute(httppost);
                Log.i("onPost1","response.execute done");
                responseStr = EntityUtils.toString(response.getEntity());
                if(responseStr!=null){
                    Log.i("onPost1 RESPONSE CAUH",responseStr);
                }


            } catch (Exception e) {
                Log.i("onPost1","ERROR-----");
                // TODO Auto-generated catch block
            }
            return null;

        }
        protected void onProgressUpdate(Integer... progress) {

        }

        protected void onPostExecute(Long result) {
            if(responseStr!=null){
                Log.i("onPost2",responseStr);
            }
            else {
                Log.i("onPost2","NULL");
            }
        }
    }
}
