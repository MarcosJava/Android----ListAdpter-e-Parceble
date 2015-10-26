package br.com.mrcsfelipe.voo.business;

import android.content.Context;
import android.text.TextUtils;

import java.util.List;

import br.com.mrcsfelipe.voo.dao.VooDao;
import br.com.mrcsfelipe.voo.model.Voo;

/**
 * Created by marcos.pinto on 26/10/2015.
 */
public class VooBusiness {

    private VooDao vooDao;


    public VooBusiness(Context context) {
        vooDao = new VooDao(context);
    }


    public long salvar(Voo voo) throws Exception {

        boolean validos = dadosValidos(voo);

        if(validos){
            return vooDao.salvar(voo);

        } else {
            return 0;

        }


    }


    public List<Voo> getListVoos() throws Exception {
        return vooDao.getListVoos();
    }

    public boolean dadosValidos(Voo voo){

        if(voo.getNome().trim().equalsIgnoreCase("")
            || voo.getNome() == null){

            return false;

        } else if (voo.getNoVoo() == 0
                    || voo.getNoVoo() == null){
            return false;

        } else if (voo.getDestino().trim().equalsIgnoreCase("")
                    || voo.getDestino() == null){
            return false;

        }

        return true;
    }
}
