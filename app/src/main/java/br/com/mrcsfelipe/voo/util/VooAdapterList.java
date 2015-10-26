package br.com.mrcsfelipe.voo.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.mrcsfelipe.voo.R;
import br.com.mrcsfelipe.voo.model.Voo;

/**
 * Created by marcos.pinto on 20/10/2015.
 */
public class VooAdapterList extends ArrayAdapter<Voo> {

    private List<Voo> items;

    public VooAdapterList(Context context, int textViewResourceId, List<Voo> objects) {
        super(context, textViewResourceId, objects);
        items = objects;
    }

    /**
     * private view holder class
     */
    private class ViewHolder {
        TextView textViewNome;
        TextView textViewNoVoo;
        TextView textViewDestino;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Create viewHolder e ger dvdItem in position
        ViewHolder viewHolder = null;
        Voo vooItem = this.getItem(position);

        // Definy layout
        LayoutInflater layoutInflater =
                (LayoutInflater) this.getContext()
                                     .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        // Case by exists layout
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_list_adapter_voo, null);
            viewHolder = new ViewHolder();
            viewHolder.textViewNome = (TextView) convertView.findViewById(R.id.textViewNome);
            viewHolder.textViewNoVoo  = (TextView) convertView.findViewById(R.id.textViewNoVoo);
            viewHolder.textViewDestino = (TextView) convertView.findViewById(R.id.textViewDestin);

            convertView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) convertView.getTag();

        // Set values
        viewHolder.textViewNome.setText(vooItem.getNome());
        viewHolder.textViewNoVoo.setText(vooItem.getNoVoo().toString());
        viewHolder.textViewDestino.setText(vooItem.getDestino());

        // Return view
        return convertView;
    }
}
