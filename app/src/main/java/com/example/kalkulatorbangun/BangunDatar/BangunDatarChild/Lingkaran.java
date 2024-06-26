package com.example.kalkulatorbangun.BangunDatar.BangunDatarChild;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kalkulatorbangun.R;

public class Lingkaran extends AppCompatActivity {
    EditText inputUser;
    Button buttonHitung;

    TextView textViewResult;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ch_lingkaran);

        inputUser = findViewById(R.id.EtJari);
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
        String jariStr = inputUser.getText().toString().trim();
        if (!jariStr.isEmpty()) {
            double jari = Double.parseDouble(jariStr);
            if (jari <= 0) {
                Toast.makeText(this, "Panjang jari-jari harus lebih dari 0", Toast.LENGTH_SHORT).show();
                return;
            }

            double phi = 3.14;
            double luas = phi * jari * jari;
            String hasil = String.format("%.2f", luas) + "cm";
            textViewResult.setText(hasil);
        } else {
            Toast.makeText(this, "Masukkan panjang jari-jari terlebih dahulu", Toast.LENGTH_SHORT).show();
        }
    }
}