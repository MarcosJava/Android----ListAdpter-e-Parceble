package br.com.mrcsfelipe.voo.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import br.com.mrcsfelipe.voo.R;
import br.com.mrcsfelipe.voo.model.Voo;
import br.com.mrcsfelipe.voo.util.VooAdapterList;

public class ListaVooActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_voo);


        ListView listView = (ListView) findViewById(R.id.listViewVoo);
        /*
        SucessoActivity.voos.add(new Voo("Marcos", 1, "London"));
        SucessoActivity.voos.add(new Voo("Marateo", 2, "Portugal"));
        SucessoActivity.voos.add(new Voo("Alequer", 3, "New York"));
        SucessoActivity.voos.add(new Voo("Romario", 4, "Brasil"));
        */
        VooAdapterList adapter = new VooAdapterList(ListaVooActivity.this, android.R.layout.simple_list_item_1, SucessoActivity.voos);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_voo, menu);
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
