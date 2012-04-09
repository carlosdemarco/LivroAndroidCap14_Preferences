package br.livro.android.cap14.pref;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Exemplo que demonstra como utilizar a classe SharedPreferences
 * 
 * @author ricardo
 *
 */
public class ExemploPreferencias extends Activity implements OnClickListener {

	private static final String CATEGORIA = "livro";

	//Nome da prefer�ncia salva
	private static final String NOME = "LivroAndroid";

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		setContentView(R.layout.form_pref);

		// Recupera o valor do contador, salvo nas preferencias
		SharedPreferences pref = getSharedPreferences(NOME, 0);

		// O segundo argumento é o valor default se não encontrar
		boolean marcado = pref.getBoolean("status", false);

		Log.i(CATEGORIA, "Status atual: " + marcado);

		CheckBox check = (CheckBox) findViewById(R.id.check);

		//Exibe o valor do contador na tela
		check.setChecked(marcado);

		Button btSalvar = (Button) findViewById(R.id.btSalvar);
		btSalvar.setOnClickListener(this);
	}
	/**
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	public void onClick(View view) {
		//Salva o contador nas preferências
		SharedPreferences pref = getSharedPreferences(NOME, MODE_PRIVATE);

		//Abre a preferência para edição
		SharedPreferences.Editor editor = pref.edit();

		CheckBox check = (CheckBox) findViewById(R.id.check);

		boolean isChecked = check.isChecked();

		//Atualiza o valor do contador
		editor.putBoolean("status", isChecked);

		Log.i(CATEGORIA,"Status salvo para: " + isChecked);

		//Faz commit para salvar os dados
		editor.commit();
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();

		Log.i(CATEGORIA,"onDestroy()");
	}
}