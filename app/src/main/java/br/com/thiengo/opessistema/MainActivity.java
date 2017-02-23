package br.com.thiengo.opessistema;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import br.com.thiengo.opessistema.domain.Opcao;
import br.com.thiengo.opessistema.extras.Mock;


public class MainActivity extends AppCompatActivity {

    private List<Opcao> opcoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opcoes = Mock.gerarOpcoes();
        OpcoesAdapter adapter = new OpcoesAdapter( this, opcoes );
        ListView lvOpcoes = (ListView) findViewById(R.id.lv_opcoes);
        lvOpcoes.setAdapter( adapter );
    }
}
