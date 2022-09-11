package com.example.socketly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class MainActivity extends AppCompatActivity {
    public Button button;
    public TextView textView;
    public EditText editText;
    public String message;
    private Socket mSocket;
    {
        try {
                mSocket = IO.socket("<YOUR URI>");
        } catch (URISyntaxException e) {
            Log.v("errorTag", e.getMessage());
            Toast.makeText(this, "failed Conn", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editTextTextPersonName);

        mSocket.connect();
        //textView.setText("");
        setListening();

        button.setOnClickListener(view -> {
            String message = editText.getText().toString().trim();
            editText.setText("");
            editText.setHint("Enter data");
            if(!message.isEmpty()){
                String jsonString = "{message: "+"'"+ message + "'"+ "}";
                try {
                    JSONObject jsonData = new JSONObject(jsonString);
                    mSocket.emit("join",jsonData);

                } catch (JSONException e) {
                    Log.v("errorTag", e.getMessage());
                    Toast.makeText(this, "failed emit", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setListening() {
        mSocket.on("join", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                try{
                    JSONObject messageJson = new JSONObject(args[0].toString());
                    message = messageJson.getString("message");
                    runOnUiThread(() -> textView.setText(message));
                } catch(Exception e){
                    Log.v("errorTag", e.getMessage());
                    Toast.makeText(MainActivity.this, "listener error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSocket.disconnect();
        mSocket.off();
    }
}