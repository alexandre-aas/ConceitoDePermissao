package com.s.d.a.a.conceitodepermissao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.util.Log;

public class ConceitoDePermissaoActivity extends AppCompatActivity {

    private static String TAG = "ConceitoDePermissaoNoAndroid6ouSuperior";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conceito_de_permissao);

        int permissao = ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO);

        if (permissao != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permissão para gravar negada!");
        }
    }
}
