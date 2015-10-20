package br.com.mrcsfelipe.voo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by markFelipe on 20/10/15.
 */
public class SucessoActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucesso);


        Bundle bundle = getIntent().getExtras();
        Voo voo = bundle.getParcelable("dvd");

        // Generate message
        StringBuffer value = new StringBuffer();
        value.append(this.getString(R.string.lb_nome)).append("\n").append(voo.getNome()).append("\n").append("\n");
        value.append(this.getString(R.string.lb_no_voo)).append("\n").append(voo.getNoVoo()).append("\n").append("\n");
        value.append(this.getString(R.string.lb_destino)).append("\n").append(voo.getDestino());

        // Set message message
        TextView message = (TextView) this.findViewById(R.id.textViewMessage);
        message.setText(value);
    }
}
