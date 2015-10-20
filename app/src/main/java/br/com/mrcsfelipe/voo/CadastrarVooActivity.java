package br.com.mrcsfelipe.voo;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class CadastrarVooActivity extends AppCompatActivity {


    private EditText nome, noVoo, destino;
    private Button salvar;
    private Voo voo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_voo);


        nome = (EditText) findViewById(R.id.et_nome);
        noVoo = (EditText) findViewById(R.id.et_num_voo);
        destino = (EditText) findViewById(R.id.et_destino);
        salvar = (Button) findViewById(R.id.bnt_salvar);


    }

    public void salvar(View view){
        List<CharSequence> msgsErros = new ArrayList<CharSequence>();
        try{

            String lbNome = nome.getText().toString().trim();
            String lbDestino = destino.getText().toString().trim();
            String lbnumVoo = noVoo.getText().toString().trim();

            if(TextUtils.isEmpty(lbNome)){
                msgsErros.add("Insira o nome");
            }

            if(TextUtils.isEmpty(lbDestino)){
                msgsErros.add("Insire o valor para destino");
            }

            Integer numVoo = 0;
            try{
                numVoo = Integer.parseInt(lbnumVoo);
            }catch (Exception e){
                msgsErros.add("Adicione o numero do voo");
            }

            if(!msgsErros.isEmpty()){

                Intent intencao = new Intent(CadastrarVooActivity.this, SucessoActivity.class);
                intencao.putExtra("erros", (Parcelable) msgsErros);
                startActivity(intencao);
                return;
            }

            voo = new Voo(lbNome,numVoo, lbDestino);

            Intent intencao = new Intent(CadastrarVooActivity.this, SucessoActivity.class);
            intencao.putExtra("sucesso", voo);
            startActivity(intencao);

        }catch (Exception e){

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastrar_voo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
