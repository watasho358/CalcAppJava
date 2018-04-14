package jp.techacademy.watanabe.shouta.calcappjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String text1;
    String text2;
    EditText mEditText1;
    EditText mEditText2;
    int mes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);

        mEditText1 = findViewById(R.id.editText1);
        mEditText2 = findViewById(R.id.editText2);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        text1 = mEditText1.getText().toString();
        text2 = mEditText2.getText().toString();
        double a = 0;
        double b = 0;
        try {
             a = Double.parseDouble(mEditText1.getText().toString());
             b = Double.parseDouble(mEditText2.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "数字を入力してください", Toast.LENGTH_SHORT).show();
            return;
        }

        double result = 0;


        if (v.getId() == R.id.button1) {
            result = a + b;
        } else if (v.getId() == R.id.button2) {
            result = a - b;
        } else if (v.getId() == R.id.button3) {
            result = a * b;
        } else if (v.getId() == R.id.button4) {
            if (b == 0) {
                Toast.makeText(MainActivity.this, "0で割ることはできません", Toast.LENGTH_SHORT).show();
                return;
            }
            result = a / b;
        }
        intent.putExtra("result", result);
        startActivity(intent);
    }
}
