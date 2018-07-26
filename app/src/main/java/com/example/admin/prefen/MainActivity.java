package com.example.admin.prefen;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button but,butGet;
    private final String NAME="bestleader";
    private final String AGE="age";
    private final String BRO="bro";
    private final String bestleader="The best leader";
    private final String content="U r the best";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but=this.findViewById(R.id.button);
        butGet=this.findViewById(R.id.butGet);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
                saveData2();

            }
        });
        butGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void saveData(){
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream=openFileOutput(bestleader,Context.MODE_PRIVATE);
            fileOutputStream.write(content.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveData2(){

        FileOutputStream fileOutputStream=null;
        File filename;
        try {
            filename = new File(getCacheDir(),bestleader);
            fileOutputStream=new FileOutputStream(filename);
            fileOutputStream.write(content.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
