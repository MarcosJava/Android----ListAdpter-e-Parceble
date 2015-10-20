package br.com.mrcsfelipe.voo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by markFelipe on 20/10/15.
 */
public class ErroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_erro);

        Bundle bundle = getIntent().getExtras();
        ArrayList<CharSequence> errors = bundle.getCharSequenceArrayList("errors");

        StringBuffer value = new StringBuffer();
        for (CharSequence error : errors) {
            value.append(error).append("\n");
        }

        TextView message = (TextView) this.findViewById(R.id.textViewMessage);
        message.setText(value);
    }
}
