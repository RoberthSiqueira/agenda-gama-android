package com.br.agenda.DAO;

/**
 * Created by roberth on 22/05/16.
 */

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.br.agenda.POJO.ContatoVO;
import com.br.agenda.UI.R.id;
import com.br.agenda.UI.R.layout;

public class ContatoAdapter extends BaseAdapter  {
    private Context context;

    private List<ContatoVO> lstContato;
    private LayoutInflater inflater;

    public ContatoAdapter(Context context, List<ContatoVO> listAgenda) {
        this.context = context;
        this.lstContato = listAgenda;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //Atualizar ListView de acordo com o lstContato
    @Override
    public void notifyDataSetChanged() {
        try{
            super.notifyDataSetChanged();
        }catch (Exception e) {
            trace("Erro : " + e.getMessage());
        }
    }

    public int getCount() {
        return lstContato.size();
    }

    //Remover item da lista
    public void remove(final ContatoVO item) {
        this.lstContato.remove(item);
    }

    //Adicionar item na lista
    public void add(final ContatoVO item) {
        this.lstContato.add(item);
    }

    public Object getItem(int position) {
        return lstContato.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup viewGroup) {
        try
        {

            ContatoVO contato = lstContato.get(position);

            //O ViewHolder irá guardar a instâncias dos objetos do estado_row
            ViewHolder holder;

            //Quando o objeto convertView não for nulo nós não precisaremos inflar
            //os objetos do XML, ele será nulo quando for a primeira vez que for carregado
            if (convertView == null) {
                convertView = inflater.inflate(layout.contato_row, null);

                //Cria o Viewholder e guarda a instância dos objetos
                holder = new ViewHolder();
                holder.tvNome = (TextView) convertView.findViewById(id.txtNome);
                holder.tvTelefone = (TextView) convertView.findViewById(id.txtTelefone);

                convertView.setTag(holder);
            } else {
                //pega o ViewHolder para ter um acesso rápido aos objetos do XML
                //ele sempre passará por aqui quando,por exemplo, for efetuado uma rolagem na tela
                holder = (ViewHolder) convertView.getTag();
            }

            holder.tvNome.setText(contato.getNome());
            holder.tvTelefone.setText(contato.getTelefone());

            return convertView;

        }catch (Exception e) {
            trace("Erro : " + e.getMessage());
        }
        return convertView;
    }


    public void toast (String msg)
    {
        Toast.makeText (context, msg, Toast.LENGTH_SHORT).show ();
    }

    private void trace (String msg)
    {
        toast (msg);
    }

    //Criada esta classe estática para guardar a referência dos objetos abaixo
    static class ViewHolder {
        public TextView tvNome;
        public TextView tvTelefone;
    }
}