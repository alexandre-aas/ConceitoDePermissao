package com.s.d.a.a.conceitodepermissao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.support.v4.app.ActivityCompat;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class ConceitoDePermissaoActivity extends AppCompatActivity {

    private static String TAG = "ConceitoDePermissaoNoAndroid6ouSuperior";
    private static final int CODIGO_DO_PEDIDO_DE_GRAVACAO = 199;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conceito_de_permissao);

        int permissao = ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO);

        if (permissao != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permissão para gravar negada!");
            //fazerPedido();

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.RECORD_AUDIO)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Permissão para acessar o microfone solicitada para que esse app possa gravar áudio.")
                        .setTitle("Permissão solicitada.");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        Log.i(TAG, "Clicado.");
                        fazerPedido();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            } else {
                fazerPedido();
            }
        }
    }

    protected void fazerPedido(){
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.RECORD_AUDIO}, CODIGO_DO_PEDIDO_DE_GRAVACAO);

    }

    @Override
    public void onRequestPermissionsResult(int codigoDoPedido,
                                           String listaDePermissoes[], int[] resultadosConcedidos) {
        switch (codigoDoPedido) {
            case CODIGO_DO_PEDIDO_DE_GRAVACAO: {

                if (resultadosConcedidos.length == 0
                        || resultadosConcedidos[0] !=
                        PackageManager.PERMISSION_GRANTED) {

                    Log.i(TAG, "Permissão negada pelo usuário!");
                } else {
                    Log.i(TAG, "Permissão concedida pelo usuário!");
                }
                return;
            }
        }
    }
}
