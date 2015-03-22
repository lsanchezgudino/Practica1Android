package com.example.practica1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	EditText dolares;
	EditText pesos;
	EditText cambio;
	RadioButton dtop;
	RadioButton etod;
	Button convert;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		dolares = (EditText) this.findViewById(R.id.edtDolares);
		pesos = (EditText) this.findViewById(R.id.edtPesos);
		cambio = (EditText) this.findViewById(R.id.etCambio);
		dtop = (RadioButton) this.findViewById(R.id.rbDolarAPesos);
		dtop.setChecked(true);
		etod = (RadioButton) this.findViewById(R.id.rbPesosAdolar);
		convert = (Button) this.findViewById(R.id.btnConvertir);
		convert.setOnClickListener(this);
		dtop.setOnClickListener(this);
		etod.setOnClickListener(this);

	}


	public void onClick(View v) {
		if (v == convert){
			if (dtop.isChecked()) {
				convertirDolaresAPesos();
			}
			if (etod.isChecked()) {
				convertirPesosADolares();
			}
		}
		if (v == dtop){
			etod.setChecked(false);
		}
		
		if (v == etod){
			dtop.setChecked(false);
		}
	}
protected void convertirDolaresAPesos() {
		
		double val;
		double tmp;
		
		if ("".equals(dolares.getText().toString())){
			val = 0;
		}
		else{
			val = Double.parseDouble(dolares.getText().toString());
		}
		
		if ("".equals(cambio.getText().toString())){
			tmp = 0;
		}
		else{
			tmp = Double.parseDouble(cambio.getText().toString());
		}
		pesos.setText(Double.toString(val* tmp));
	}

	protected void convertirPesosADolares() {
		
		double val;
		double tmp;
		
		if ("".equals(pesos.getText().toString())){
			val = 0;
		}
		else{
			val = Double.parseDouble(pesos.getText().toString());
		}
		
		if ("".equals(cambio.getText().toString())){
			tmp = 0;
		}
		else{
			tmp = Double.parseDouble(cambio.getText().toString());
		}
		
		dolares.setText(Double.toString(val/tmp));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
