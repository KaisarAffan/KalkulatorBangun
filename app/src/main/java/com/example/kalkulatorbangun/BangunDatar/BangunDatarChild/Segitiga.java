package com.example.kalkulatorbangun.BangunDatar.BangunDatarChild;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kalkulatorbangun.R;


public class Segitiga extends AppCompatActivity {
    EditText inputUser1,inputUser2;
    Button buttonHitung;

    TextView textViewResult;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ch_segitiga);

        inputUser1 = findViewById(R.id.EtAlas);
        inputUser2 = findViewById(R.id.EtTinggi);
        buttonHitung = findViewById(R.id.sum);
        textViewResult = findViewById(R.id.tvHasil);


        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung();
            }
        });
    }
    private void hitung() {
        String tinggiStr = inputUser2.getText().toString().trim();
        String alasStr = inputUser1.getText().toString().trim();
        if (!alasStr.isEmpty() && !tinggiStr.isEmpty()) {
            double alas = Double.parseDouble(alasStr);
            double tinggi = Double.parseDouble(tinggiStr);
            if (alas <= 0) {
                Toast.makeText(this, "Alas harus lebih dari 0", Toast.LENGTH_SHORT).show();
                return;
            }else if(tinggi <= 0) {
                Toast.makeText(this, "Tinggi harus lebih dari 0", Toast.LENGTH_SHORT).show();
                return;
            }
            double luas = 0.5 * alas * tinggi;
            String hasil = String.format("%.2f", luas) + "cm";
            textViewResult.setText(hasil);
        } else {
            Toast.makeText(this, "Masukkan tinggi dan lebar terlebih dahulu", Toast.LENGTH_SHORT).show();
        }
    }
}