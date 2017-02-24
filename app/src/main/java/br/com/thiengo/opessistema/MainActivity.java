package br.com.thiengo.opessistema;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import br.com.thiengo.opessistema.domain.Opcao;
import br.com.thiengo.opessistema.extras.Mock;


public class MainActivity extends AppCompatActivity {

    private List<Opcao> opcoes;
    private OpcoesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opcoes = Mock.gerarOpcoes();
        adapter = new OpcoesAdapter( this, opcoes );
        ListView lvOpcoes = (ListView) findViewById(R.id.lv_opcoes);
        lvOpcoes.setAdapter( adapter );
    }

    @Override
    protected void onResume() {
        super.onResume();

        new Thread(){
            @Override
            public void run() {
                super.run();

                // AGUARDE 2 SEGUNDOS
                SystemClock.sleep( 5000 );

                /*
                 * ATUALIZE O PRIMEIRO ITEM DA
                 * LISTA DE OPÇÕES
                 */
                Opcao o = opcoes.get( 0 );
                o.setStatus( !o.ehStatus() );

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }.start();
    }
}
