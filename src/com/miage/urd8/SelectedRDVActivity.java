package com.miage.urd8;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SelectedRDVActivity extends Activity {

	SimpleDateFormat formatHeure = new SimpleDateFormat("kk:mm");
	SimpleDateFormat formatDate = new SimpleDateFormat("EEEE dd MMMM");
	Calendar dateAndTime = Calendar.getInstance();
	Calendar dateDeb;
	Calendar dateFin;
	Calendar heureDeb;
	Calendar heureFin;
	String flag;

	TextView tvSelectedRDVLibelle;
	TextView tvSelectedRDVDateJours;
	TextView tvSelectedRDVDetails;
	TextView tvSelectedRDVLieu;
	TextView tvSelectedRDVHeures;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selected_rdv);

		// RŽcupŽration des vues
		tvSelectedRDVLibelle = (TextView) findViewById(R.id.tvSelectedRDVLibelle);
		tvSelectedRDVDateJours = (TextView) findViewById(R.id.tvSelectedRDVDateJours);
		tvSelectedRDVDetails = (TextView) findViewById(R.id.tvSelectedRDVDetails);
		tvSelectedRDVLieu = (TextView) findViewById(R.id.tvSelectedRDVLieu);
		tvSelectedRDVHeures = (TextView) findViewById(R.id.tvSelectedRDVHeures);

		// On rŽcup�re les informations du RDV sŽlectionnŽ
		Bundle objetbundle = this.getIntent().getExtras();
		int i = objetbundle.getInt("position");
		RDV leRDVSelectionne = RDV.getRDV(i);

		// On alimente les vues
		tvSelectedRDVLibelle.setText(leRDVSelectionne.getLibelle());
		if (leRDVSelectionne.getContent().isEmpty()) {
			tvSelectedRDVDetails.setText("Non renseigné");
			tvSelectedRDVDetails.setTextColor(Color.GRAY);
		} else {
			tvSelectedRDVDetails.setText(leRDVSelectionne.getContent());
		}

		if (leRDVSelectionne.getContent().isEmpty()) {
			tvSelectedRDVLieu.setText("Non renseigné");
			tvSelectedRDVLieu.setTextColor(Color.GRAY);
		} else {
			tvSelectedRDVLieu.setText(leRDVSelectionne.getLieu());
		}

		if (leRDVSelectionne.getDateDeb().compareTo(
				leRDVSelectionne.getDateFin()) == 0) {
			tvSelectedRDVDateJours.setText(formatDate.format(leRDVSelectionne
					.getDateDeb().getTime()));
		} else {
			tvSelectedRDVDateJours.setText("Du "
					+ formatDate
							.format(leRDVSelectionne.getDateDeb().getTime())
					+ " au "
					+ formatDate
							.format(leRDVSelectionne.getDateFin().getTime()));
		}

		if (!leRDVSelectionne.isJourneeEntiere()) {
			int heureDeb = leRDVSelectionne.getHeureDeb().getTime().getHours();
			int heureFin = leRDVSelectionne.getHeureFin().getTime().getHours();

			int minDeb = leRDVSelectionne.getHeureDeb().getTime().getMinutes();
			int minFin = leRDVSelectionne.getHeureFin().getTime().getMinutes();

			int heureDebConcat = heureDeb + minDeb;
			int heureFinConcat = heureFin + minFin;

			if (heureDebConcat != heureFinConcat) {
				tvSelectedRDVHeures.setText("De "
						+ formatHeure.format(leRDVSelectionne.getHeureDeb()
								.getTime())
						+ " a "
						+ formatHeure.format(leRDVSelectionne.getHeureFin()
								.getTime()));
			}

			else {
				tvSelectedRDVHeures.setText(formatHeure.format(leRDVSelectionne
						.getHeureDeb().getTime()));
			}
		}

		else {
			tvSelectedRDVHeures.setVisibility(View.GONE);
		}

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
			Intent intent = new Intent(this, EditRDVActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			intent.putExtras(objetbundle);
			startActivity(intent);
			return true;
		case R.id.menu_delete:
			final Intent intentMain = new Intent(this, MainActivity.class);
			intentMain.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			Bundle objetbdl = this.getIntent().getExtras();
			final int i = objetbdl.getInt("position");
			RDV leRDVSelectionne = RDV.getRDV(i);
			
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
					this);

			// set dialog message
			alertDialogBuilder
					.setMessage("Etes-vous sûr de vouloir supprimer ce RDV ?")
					.setCancelable(true)
					.setPositiveButton("Oui",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									// On supprimer le rdv
									RDV.getAllRDV().remove(i);
									Toast.makeText(getApplicationContext(), "Le RDV a été supprimé", Toast.LENGTH_LONG).show();
									
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

		RDV leRDVSelectionne = RDV.getRDV(i);

		Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
		sharingIntent.setType("text/plain");

		// Ce que l'on partage
		String stShare = "Nouveau RDV : " + leRDVSelectionne.getLibelle();
		stShare += System.getProperty("line.separator") + "Heure et date : "
				+ formatDate.format(leRDVSelectionne.getDateDeb().getTime())
				+ " "
				+ formatHeure.format(leRDVSelectionne.getHeureDeb().getTime());
		stShare += System.getProperty("line.separator") + "Détails du RDV : "
				+ leRDVSelectionne.getContent();
		stShare += System.getProperty("line.separator") + "Lieu du RDV : "
				+ leRDVSelectionne.getLieu();
		stShare += System.getProperty("line.separator")
				+ System.getProperty("line.separator")
				+ "Créer avec l'application Android URD8 : n'oubliez plus l'essentiel !";

		sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
				"RDV à ne pas oublier : \"" + leRDVSelectionne.getLibelle() + "\"");
		sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, stShare);

		startActivity(Intent.createChooser(sharingIntent, "Partager ce RDV"));

	}
}