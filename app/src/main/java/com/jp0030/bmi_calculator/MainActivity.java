package com.jp0030.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight , edtHigthFt , edtHightIn ;
        AppCompatButton btnCalculate;
        TextView txtResult;
        LinearLayout llMain ;

        edtWeight = findViewById(R.id.edtWeight);
        edtHigthFt = findViewById(R.id.edtHightFt);
        edtHightIn = findViewById(R.id.edtHightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        llMain = findViewById(R.id.llMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHigthFt.getText().toString());
                int in = Integer.parseInt(edtHightIn.getText().toString());

                int totalIn = ft*12 + in ;
                double totaleCm = totalIn*2.53 ;
                double totaleM = totaleCm/100;

                double bmi = wt/(totaleM*totaleM);

                if (bmi>25){
                    txtResult.setText("You're over Waight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.OW));
                }else if (bmi<18){
                    txtResult.setText("You're UndrWaight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.UW));
                }else {
                    txtResult.setText("You're Healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.HE));
                }
            }
        });

    }
}