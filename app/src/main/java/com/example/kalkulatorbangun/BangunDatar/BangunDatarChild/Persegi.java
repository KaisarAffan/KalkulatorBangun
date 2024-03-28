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

public class Persegi extends AppCompatActivity {
    EditText inputUser;
    Button buttonHitung;

    TextView textViewResult;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ch_persegi);

        inputUser = findViewById(R.id.Etsisi);
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
        String sisiStr = inputUser.getText().toString().trim();
        if (!sisiStr.isEmpty()) {
            double sisi = Double.parseDouble(sisiStr);
            if (sisi <= 0) {
                Toast.makeText(this, "Panjang sisi harus lebih dari 0", Toast.LENGTH_SHORT).show();
                return;
            }
            double luas = sisi * sisi;
            String hasil = String.format("%.2f", luas) + "cm";
            textViewResult.setText(hasil);
        } else {
            Toast.makeText(this, "Masukkan panjang sisi terlebih dahulu", Toast.LENGTH_SHORT).show();
        }
    }
}
