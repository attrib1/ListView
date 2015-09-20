package com.example.admin.tut_non;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.AlertDialogWrapper;
import com.afollestad.materialdialogs.MaterialDialog;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {

    private Button btnToast;
    private Button btnChangText, btnNewActivity;
    private TextView textchang;
    private Button btnpage2;
    private Button btnpage3;
    private Button btndai;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnToast = (Button) findViewById(R.id.buttonToast);
        btnChangText = (Button) findViewById(R.id.btnChangText);
        textchang = (TextView) findViewById(R.id.textchang);
        btnNewActivity = (Button) findViewById(R.id.btnNewPage);
        btnpage2 = (Button) findViewById(R.id.btnNewPage2);
        btnpage3 = (Button) findViewById(R.id.btnNewPage3);
        btndai = (Button)findViewById(R.id.btndai);

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Click ปุ่ม Toast", Toast.LENGTH_SHORT).show();
            }
        });

        changtext();

        btndai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(MainActivity.this)
                        .title("title")
                        .content("content")
                        .inputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL)
                        .input("1", "1", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {
                                // Do something
                                Toast.makeText(getApplication(),""+input,Toast.LENGTH_SHORT).show();
                            }
                        }).show();


            }
        });

    }

    private void changtext() {

        btnpage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this,MainActivity4.class);
                startActivity(in);
            }
        });

        btnpage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, MainActivity3Activity.class);
                startActivity(myIntent);
            }
        });

        btnChangText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textchang.setText("Chang Text");

            }
        });

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
                //  myIntent.putExtra("key", value); //Optional parameters
                startActivity(myIntent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
