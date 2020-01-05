package com.example.androidwerkstukdavyvankeymeulen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidwerkstukdavyvankeymeulen.Database.AppDatabase;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private RequestQueue requestQueue;
    private String imgurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        requestQueue = Volley.newRequestQueue(this);

        jsonParse();

    }


    private void jsonParse(){
            String url = "https://dog.ceo/api/breeds/image/random";

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                JSONObject jsonObject = response.getJSONObject("message");
                                imgurl=jsonObject.getString("message");

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
        Picasso.get().load(imgurl).into(imageView);
    }




    //stappen die moeten gebeuren na klikken van login
    public void login(View view)
    {
        //If statement checken of login klopt!!

        //functie aanroepen voor terug naar andere activity te gaan
        openListActivity();
    }

    //functie voor terug naar andere activity te gaan met intent
    public void openListActivity() {
        Intent intent = new Intent(this, PetListActivity.class);
        startActivity(intent);
    }

    public boolean emailVal(String mail){
        if(mail=="mail"){
            return true;
        }
        return false;

    }






}
