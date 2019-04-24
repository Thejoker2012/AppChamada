package unipac.com.br.appchamada;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nomeEdt ;
    EditText emailEdt;
    EditText telefoneEdt;
    Button salvarBtn;
    Button limparBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeEdt = (EditText)findViewById(R.id.nomeEdt);
        emailEdt = (EditText)findViewById(R.id.emailEdt);
        telefoneEdt = (EditText)findViewById(R.id.telefoneEdt);
        salvarBtn = (Button)findViewById(R.id.salvarBtn);
        limparBtn = (Button)findViewById(R.id.limparBtn);

        salvarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = nomeEdt.getText().toString();
                String email = nomeEdt.getText().toString();
                String telefone = nomeEdt.getText().toString();

                insereInformacao(nome,email,telefone);
            }
        });


    }

    public void insereInformacao(String nome, String email, String telefone){

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("NOME",nome);
        editor.putString("EMAIL",email);
        editor.putString("TELEFONE",telefone);

        editor.commit();
    }
    public  void lerDados(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor = preferences.edit();

        String nome = preferences.getString("NOME","Retornou nada");
        String email = preferences.getString("EMAIL","Retornou nada");
        String telefone = preferences.getString("TELEFONE","Retornou nada");

        editor.putString("NOME",nome);
        editor.putString("EMAIL",email);
        editor.putString("TELEFONE",telefone);

        editor.commit();
    }
    public void imprime(String nome, String email, String telefone){
        StringBuilder sb = new StringBuilder(1200);
        sb.append("Os dados cadastrados foram:");
        sb.append("NOME"+nome);
        sb.append("EMAIL"+nome);
        sb.append("TELEFONE"+nome);

        Toast.makeText(MainActivity.this,sb.toString(),Toast.LENGTH_LONG).show();
    }
}
