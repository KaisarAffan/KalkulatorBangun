package com.example.kalkulatorbangun.BangunRuang.BangunRuangChild;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kalkulatorbangun.R;

public class ball extends AppCompatActivity {

    EditText inputUser;
    Button buttonHitung;

    TextView textViewResult;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball);

        inputUser = findViewById(R.id.Etjari);
        buttonHitung = findViewById(R.id.hitung);
        textViewResult = findViewById(R.id.Tvhasil);


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
            double luas = 4 * phi * jari * jari;
            String hasil = String.format("%.2f", luas) + "cm";
            textViewResult.setText(hasil);
        } else {
            Toast.makeText(this, "Masukkan panjang jari-jari terlebih dahulu", Toast.LENGTH_SHORT).show();
        }
    }
}