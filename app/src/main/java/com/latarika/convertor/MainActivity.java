package com.latarika.convertor;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText text_from_user;
    private TextView result;
    private Button btn;
    private float num;
    private FloatingActionButton floatBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnBtnClick();

    }


    public void OnBtnClick() {
        this.text_from_user = findViewById(R.id.editText);
        this.result = findViewById(R.id.result_field);

        this.btn = findViewById(R.id.button_convert);
        this.floatBtn = findViewById(R.id.floatBtn);

        floatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.latarika.convertor.LoginActivity");
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = text_from_user.getText().toString();
                if (!text.matches("")) {
                     num = Float.parseFloat(text);
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this); // диалоговое окно
                    builder.setMessage("Хотите умножить значение на 2?");
                    builder.setCancelable(false); //всплывающее окно нельзя будет отменить
                    builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            num *= 1.61* 2f;
                            result.setText(Float.toString(num));
                            btn.setText("Готово");
                            btn.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                        }
                    });
                    builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            num *= 1.61f;
                            result.setText(Float.toString(num));

                            btn.setText("Готово");
                            btn.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                            dialog.cancel();
                        }
                    });

                    AlertDialog alert = builder.create();
                    alert.setTitle("Умножение чисел");
                    alert.show(); // показывает всплывающее окно


                }else {

                    Toast.makeText(MainActivity.this, //всплывающая подсказка
                            "Введите число",
                            Toast.LENGTH_LONG).show();

                }
            }
        });


//        float num = Float.parseFloat(text_from_user.getText().toString());
//        num *= 1.61;
//        result.setText(Float.toString(num));
    }
}
