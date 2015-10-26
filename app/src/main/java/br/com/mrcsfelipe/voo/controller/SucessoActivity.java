package br.com.mrcsfelipe.voo.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.mrcsfelipe.voo.R;
import br.com.mrcsfelipe.voo.business.VooBusiness;
import br.com.mrcsfelipe.voo.model.Voo;

/**
 * Created by markFelipe on 20/10/15.
 */
public class SucessoActivity extends AppCompatActivity {

    public static List<Voo> voos = new ArrayList<>();

    private VooBusiness vooBusiness;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucesso);


        Bundle bundle = getIntent().getExtras();
        Voo voo = bundle.getParcelable("sucesso");
        //voos.add(voo);

        vooBusiness = new VooBusiness(this.getApplicationContext());
        try {
            Voo vooSalvar = new Voo(voo.getNome(),voo.getNoVoo(),voo.getDestino());
            vooBusiness.salvar(vooSalvar);
        } catch (Exception e) {
            e.printStackTrace();
        }


        StringBuffer value = new StringBuffer();
        value.append(this.getString(R.string.lb_nome)).append("\n").append(voo.getNome()).append("\n").append("\n");
        value.append(this.getString(R.string.lb_no_voo)).append("\n").append(voo.getNoVoo()).append("\n").append("\n");
        value.append(this.getString(R.string.lb_destino)).append("\n").append(voo.getDestino());

        TextView message = (TextView) this.findViewById(R.id.textViewMessage);
        message.setText(value);
    }
}
