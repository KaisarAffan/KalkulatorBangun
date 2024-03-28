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

public class Tabung extends AppCompatActivity {

    EditText inputUser1,inputUser2;
    Button buttonHitung;

    TextView textViewResult;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabung);

        inputUser1 = findViewById(R.id.EtJari);
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
        String jariStr = inputUser1.getText().toString().trim();
        if (!tinggiStr.isEmpty() && !jariStr.isEmpty()) {
            double tinggi = Double.parseDouble(tinggiStr);
            double jari = Double.parseDouble(jariStr);
            if (tinggi <= 0) {
                Toast.makeText(this, "Tinggi harus lebih dari 0", Toast.LENGTH_SHORT).show();
                return;
            }else if(jari <= 0) {
                Toast.makeText(this, "Jari jari harus lebih dari 0", Toast.LENGTH_SHORT).show();
                return;
            }
            double phi = 3.14;
            double luas = 2 * phi * jari * (jari+tinggi);
            String hasil = String.format("%.2f", luas) + "cm";
            textViewResult.setText(hasil);
        } else {
            Toast.makeText(this, "Masukkan Tinggi dan Jari jari terlebih dahulu", Toast.LENGTH_SHORT).show();
        }
    }
}