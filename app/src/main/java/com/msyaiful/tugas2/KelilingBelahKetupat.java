package com.msyaiful.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KelilingBelahKetupat extends AppCompatActivity implements View.OnClickListener {
    private EditText emssisi;
    private Button hasilkel;
    private TextView rumuskel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keliling_belah_ketupat);

        emssisi = findViewById(R.id.sisi);
        hasilkel = findViewById(R.id.hasil2);
        hasilkel.setOnClickListener(this);
        rumuskel = findViewById(R.id.kelbelket);
    }

    @Override
    public void onClick (View view){
        if (view.getId() == R.id.hasil2){
            String inputsisi = emssisi.getText().toString().trim();

            boolean isInvalidInput = false;
            Double asisi = toDouble(inputsisi);

            if (asisi == null) {
                isInvalidInput = true;
                emssisi.setError("Tolong Diisi");
            }
            if (!isInvalidInput) {
                double kel = asisi * 4;
                Intent data = new Intent();
                EditText textnama = findViewById(R.id.sisi);

                data.setData(Uri.parse(String.valueOf(kel)));
                setResult(RESULT_OK, data);

                finish();

            }
        }
    }
    private Double toDouble(String string) {
        try {
            return Double.valueOf(string);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
