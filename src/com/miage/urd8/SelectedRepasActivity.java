package com.miage.urd8;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class SelectedRepasActivity extends Activity {

	TextView tvSelectedRepasLibelle;
	TextView tvSelectedRepasNbPersonnes;
	TextView tvSelectedRepasCalories;
	TextView tvSelectedRepasRecette;
	TextView tvSelectedRepasTypeRepas;
	String leType;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selected_repas);

		// RŽcupŽration des vues
		tvSelectedRepasLibelle = (TextView) findViewById(R.id.tvSelectedRepasLibelle);
		tvSelectedRepasNbPersonnes = (TextView) findViewById(R.id.tvSelectedRepasNbPersonne);
		tvSelectedRepasCalories = (TextView) findViewById(R.id.tvSelectedRepasCalories);
		tvSelectedRepasRecette = (TextView) findViewById(R.id.tvSelectedRepasRecette);
		tvSelectedRepasTypeRepas = (TextView) findViewById(R.id.tvSelectedRepasTypeRepas);

		// On rŽcup�re les informations du repas sŽlectionnŽ
		Bundle objetbundle = this.getIntent().getExtras();
		int i = objetbundle.getInt("position");
		Repas leRepasSelectionne = Repas.getRepas(i);

		// On alimente les vues
		tvSelectedRepasLibelle.setText(leRepasSelectionne.getNom());
		tvSelectedRepasNbPersonnes.setText("Pour " + leRepasSelectionne.getNbPersonnes() + " personnes");
		tvSelectedRepasRecette.setText(leRepasSelectionne.getRecette());
		tvSelectedRepasCalories.setText(leRepasSelectionne.getCalories() + " calories");
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
		tvSelectedRepasTypeRepas.setText(Html.fromHtml("<b>Type de repas :</b> ") + leType);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_selected_item, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_share:
			shareIt();
			return true;
		case R.id.menu_edit:
			Bundle objetbundle = this.getIntent().getExtras();
			Intent intent = new Intent(this, EditRepasActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			intent.putExtras(objetbundle);
			startActivity(intent);
			return true;
		case R.id.menu_delete:
			final Intent intentMain = new Intent(this, MainActivity.class);
			intentMain.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			Bundle objetbdl = this.getIntent().getExtras();
			final int i = objetbdl.getInt("position");
			
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
					this);

			// set dialog message
			alertDialogBuilder
					.setMessage("Etes-vous sûr de vouloir supprimer ce repas ?")
					.setCancelable(true)
					.setPositiveButton("Oui",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									// On supprimer le rdv
									Repas.getAllRepas().remove(i);
									
									Toast.makeText(getApplicationContext(), "Le repas a été supprimé", Toast.LENGTH_LONG).show();
									
									startActivity(intentMain);
									finish();
								}
							})
					.setNegativeButton("Non",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									dialog.cancel();
								}
							});

			// create alert dialog
			AlertDialog alertDialog = alertDialogBuilder.create();

			// show it
			alertDialog.show();

		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	public void shareIt() {
		Bundle objetbundle = this.getIntent().getExtras();
		int i = objetbundle.getInt("position");

		Repas leRepasSelectionne = Repas.allRepas.get(i);

		Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
		sharingIntent.setType("text/plain");

		// Ce que l'on partage
		String stShare = "Nouveau Repas : " + leRepasSelectionne.getNom();
		stShare += System.getProperty("line.separator")
				+ System.getProperty("line.separator")
				+ "Créer avec l'application Android URD8 : n'oubliez plus l'essentiel !";

		sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
				"Repas à ne pas oublier : \"" + leRepasSelectionne.getNom() + "\"");
		sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, stShare);

		startActivity(Intent.createChooser(sharingIntent, "Partager ce repas"));

	}
}