package br.com.thiengo.opessistema;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import br.com.thiengo.opessistema.domain.Opcao;


public class OpcoesAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Opcao> opcoes;

    public OpcoesAdapter( Context context, List<Opcao> opcoes ) {
        inflater = LayoutInflater.from(context);
        this.opcoes = opcoes;
    }

    @Override
    public int getCount() {
        return opcoes.size();
    }

    @Override
    public Object getItem(int i) {
        return opcoes.get( i );
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {
        OpcaoViewHolder holder;
        Opcao opcao = opcoes.get( posicao );

        if( view == null ){
            holder = new OpcaoViewHolder();
            view = inflater.inflate( R.layout.item_opcao, viewGroup, false );
            view.setTag( holder );
            holder.setViews( view );
        }
        else{
            holder = (OpcaoViewHolder) view.getTag();
        }
        holder.setDados( opcao );

        return view;
    }
}
