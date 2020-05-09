package com.example.areyousick;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox cbNafas, cbDemam, cbBatuk, cbSakitTubuh, cbSakitTenggorokan, cbHidungTersumbat, cbKelelahan, cbKehulanganBau;
    public int jmlCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etNama = (EditText) findViewById(R.id.etNama);
        final EditText etUmur = (EditText) findViewById(R.id.etUmur);
        final EditText etAlamat = (EditText) findViewById(R.id.etAlamat);

        cbNafas = (CheckBox) findViewById(R.id.cbNafas);
        cbDemam = (CheckBox) findViewById(R.id.cbDemam);
        cbBatuk = (CheckBox) findViewById(R.id.cbBatuk);
        cbSakitTubuh = (CheckBox) findViewById(R.id.cbSakitTubuh);
        cbSakitTenggorokan = (CheckBox) findViewById(R.id.cbTenggorokan);
        cbHidungTersumbat = (CheckBox) findViewById(R.id.cbHidungTersumbat);
        cbKelelahan = (CheckBox) findViewById(R.id.cbKelelahan);
        cbKehulanganBau = (CheckBox) findViewById(R.id.cbKelelahan);

        final Button btnHasilCovid = (Button) findViewById(R.id.btnHasilCovid);
        final Button btnInfoCovid = (Button) findViewById(R.id.btnInfo);

        btnHasilCovid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etNama.getText().toString();
                String umur = etUmur.getText().toString();
                String alamat = etAlamat.getText().toString();
                Intent inten1 = new Intent(MainActivity.this, HasilTest.class);
                inten1.putExtra("nama", nama);
                inten1.putExtra("umur", umur);
                inten1.putExtra("alamat", alamat);
                if (!cbNafas.isChecked() && !cbDemam.isChecked() && !cbBatuk.isChecked() && !cbSakitTubuh.isChecked()
                        && !cbSakitTenggorokan.isChecked() && !cbHidungTersumbat.isChecked() && !cbKelelahan.isChecked() && !cbKehulanganBau.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Kamu sudah sehat!", Toast.LENGTH_SHORT).show();
                } else {
                    if (cbNafas.isChecked()) {
                        jmlCheckbox++;
                    } else {
                        jmlCheckbox = jmlCheckbox + 0;
                    }
                    if (cbDemam.isChecked()) {
                        jmlCheckbox++;
                    } else {
                        jmlCheckbox = jmlCheckbox + 0;
                    }
                    if (cbBatuk.isChecked()) {
                        jmlCheckbox++;
                    } else {
                        jmlCheckbox = jmlCheckbox + 0;
                    }
                    if (cbSakitTubuh.isChecked()) {
                        jmlCheckbox++;
                    } else {
                        jmlCheckbox = jmlCheckbox + 0;
                    }
                    if (cbSakitTenggorokan.isChecked()) {
                        jmlCheckbox++;
                    } else {
                        jmlCheckbox = jmlCheckbox + 0;
                    }
                    if (cbHidungTersumbat.isChecked()) {
                        jmlCheckbox++;
                    } else {
                        jmlCheckbox = jmlCheckbox + 0;
                    }
                    if (cbKelelahan.isChecked()) {
                        jmlCheckbox++;
                    } else {
                        jmlCheckbox = jmlCheckbox + 0;
                    }
                    if (cbKehulanganBau.isChecked()) {
                        jmlCheckbox++;
                    } else {
                        jmlCheckbox = jmlCheckbox + 0;
                    }
                    if (jmlCheckbox >= 0 && jmlCheckbox <= 2) {
                        String a = "Istirahat yang cukup \n #DiRumahAja";
                        inten1.putExtra("tingkat", a);
                    }
                    if (jmlCheckbox >= 3 && jmlCheckbox <= 5) {
                        String a = "Isolasi Diri dan tunggu 2 minggu \n #DiRumahAja";
                        inten1.putExtra("tingkat", a);
                    }
                    if (jmlCheckbox > 5 && jmlCheckbox <= 7) {
                        String a = "Anda Kemungkinan sudah terkena Covid-19 Hubungi Rumah Sakit!";
                        inten1.putExtra("tingkat", a);
                    }
                    if (jmlCheckbox == 8) {
                        String a = "Anda terkena Covid-19, Hubungi Rumah Sakit dan Isolasikan diri segera";
                        inten1.putExtra("tingkat", a);
                    }
                    Bundle extras = new Bundle();
                    extras.putString("jmlHasil", jmlCheckbox + "");
                    inten1.putExtras(extras);
                    startActivity(inten1);
                    jmlCheckbox = 0;
                    finish();
                }

            }
        });

        btnInfoCovid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("https://covid19.go.id");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(webIntent);
            }
        });

    }


    public void OpenMaps(View view) {

// Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
// Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");

// Attempt to start an activity that can handle the Intent
        startActivity(mapIntent);
    }

    public void CallCenter(View view) {
        String phone = "117";
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(intent);
    }
}
