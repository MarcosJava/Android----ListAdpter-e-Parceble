package br.com.mrcsfelipe.voo.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.mrcsfelipe.voo.R;
import br.com.mrcsfelipe.voo.business.VooBusiness;
import br.com.mrcsfelipe.voo.model.Voo;
import br.com.mrcsfelipe.voo.util.VooAdapterList;

/**
 * Created by marcos.pinto on 26/10/2015.
 */
public class ListaVooDB extends AppCompatActivity {

    private VooBusiness vooBusiness;
    private List<Voo> voos;

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

        try {
            vooBusiness = new VooBusiness(this.getApplicationContext());
            voos = vooBusiness.getListVoos();
        } catch (Exception e) {
            e.printStackTrace();
        }


        VooAdapterList adapter = new VooAdapterList(ListaVooDB.this,
                                                    android.R.layout.simple_list_item_1,
                                                    voos);
        listView.setAdapter(adapter);
    }
}
