package com.example.areyousick;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HasilTest extends AppCompatActivity {
    private TextView tvNama, tvUmur, tvAlamat, tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_test);

        tvNama = (TextView) findViewById(R.id.tvNama);
        tvUmur = (TextView) findViewById(R.id.tvUmur);
        tvAlamat = (TextView) findViewById(R.id.tvAlamat);
        tvHasil = (TextView) findViewById(R.id.tvHasil);

        tvNama.setText("Nama : " + getIntent().getStringExtra("nama"));
        tvUmur.setText("Umur : " + getIntent().getStringExtra("umur"));
        tvAlamat.setText("Alamat : " + getIntent().getStringExtra("alamat"));
        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        String jmlHasil = extras.getString("jmlHasil");
        int intjmlHasil = Integer.parseInt(jmlHasil);
//        tvHasil.setText(getIntent().getStringExtra("jmlHasil"));
        tvHasil.setText(getIntent().getStringExtra("tingkat"));
    }
    public void onBackPressed() {
        Intent goLogin = new Intent(this, MainActivity.class);
        startActivity(goLogin);
        finish();
    }
}