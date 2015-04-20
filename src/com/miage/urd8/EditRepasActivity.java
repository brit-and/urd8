package com.miage.urd8;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditRepasActivity extends Activity {

	TextView tvLibelle;
	Button btTypeRepas;
	TextView tvRecette;
	TextView tvNbPersonnes;
	TextView tvCalories;
	int type = 0;
	String leType;

	final CharSequence[] items = { "Entrée", "Plat", "Dessert" };

	public void chooseType(View v) {
		AlertDialog.Builder builder = new AlertDialog.Builder(
				EditRepasActivity.this);
		builder.setTitle("Type de repas").setItems(items,
				new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {

						btTypeRepas.setText(items[which]);
						switch (which) {
						case 0:
							type = 1;
							break;
						case 1:
							type = 2;
							break;
						case 2:
							type = 3;
							break;
						}
					}

				});

		builder.show();
	}

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_add_repas);
		
		btTypeRepas = (Button)findViewById(R.id.btRepasType);
		
		TextView RepasLabel = (TextView)findViewById(R.id.tvRepas);
		RepasLabel.setText("Editer le repas");
		
		
		// On rÈcupËre le RDV que l'on souhaite Èditer
		Bundle objetbundle = this.getIntent().getExtras();
		int i = objetbundle.getInt("position");
		Repas leRepasSelectionne = Repas.getRepas(i);
		type = leRepasSelectionne.getType();
		
		// On affecte les valeurs du RDV aux diffÈrentes vues
		EditText etRepasLibelle = (EditText) findViewById(R.id.etRepasLibelle);
		EditText etRepasCalories = (EditText) findViewById(R.id.etRepasCalories);
		EditText etRepasNbPersonnes = (EditText) findViewById(R.id.etRepasNbPersonnes);
		EditText etRepasRecette = (EditText) findViewById(R.id.etRepasRecette);
		Button btRepasType = (Button) findViewById(R.id.btRepasType);
		
		switch(leRepasSelectionne.getType())
		{
		case 1:
			leType = "Entrée";
			break;
		case 2:
			leType = "Plat";
			break;
		case 3:
			leType = "Dessert";
			break;
		}
		
		btRepasType.setText(leType);
		etRepasLibelle.setText(leRepasSelectionne.getNom());
		etRepasCalories.setText(String.valueOf(leRepasSelectionne.getCalories()));
		etRepasNbPersonnes.setText(String.valueOf(leRepasSelectionne.getNbPersonnes()));
		etRepasRecette.setText(leRepasSelectionne.getRecette());
		
	}

	// Lors de la validation du formulaire
	public void validateForm(View v) {
		Bundle objetbundle = this.getIntent().getExtras();
		int position = objetbundle.getInt("position");
		
		// On vérifie que tous les champs ont été remplis
		EditText etRepasLibelle = (EditText) findViewById(R.id.etRepasLibelle);
		EditText etRepasCalories = (EditText) findViewById(R.id.etRepasCalories);
		EditText etRepasNbPersonnes = (EditText) findViewById(R.id.etRepasNbPersonnes);
		EditText etRepasRecette = (EditText) findViewById(R.id.etRepasRecette);
		
		if (etRepasLibelle.getText().length() == 0
				|| etRepasLibelle.getText().toString().trim().isEmpty() == true ||
				etRepasCalories.getText().length() == 0
				|| etRepasCalories.getText().toString().trim().isEmpty() == true ||
				etRepasNbPersonnes.getText().length() == 0
				|| etRepasNbPersonnes.getText().toString().trim().isEmpty() == true ||
				etRepasRecette.getText().length() == 0
				|| etRepasRecette.getText().toString().trim().isEmpty() == true ||
				type == 0) {
			
			TextView tvErreur = (TextView) findViewById(R.id.tvErreur);
			tvErreur.setVisibility(View.VISIBLE);
		}

		else {

			String libelle = etRepasLibelle.getText().toString();
			String recette = etRepasRecette.getText().toString();
			int nbPersonnes = Integer.parseInt(etRepasNbPersonnes.getText().toString());
			int calories = Integer.parseInt(etRepasCalories.getText().toString());

			// On modifie le RDV en question, grace ‡ sa position
	        Repas unRepas = Repas.getRepas(position);
	        unRepas.setCalories(calories);
	        unRepas.setNbPersonnes(nbPersonnes);
	        unRepas.setNom(libelle);
	        unRepas.setRecette(recette);
	        unRepas.setType(type);
	        
			Toast.makeText(getApplicationContext(), "Le repas a été modifié", Toast.LENGTH_LONG).show();

			
			// On retourne sur l'activité principale
			Intent intent = new Intent(this, MainActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			startActivity(intent);
			finish();
			
		}

	}

}