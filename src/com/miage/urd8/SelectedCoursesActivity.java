package com.miage.urd8;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class SelectedCoursesActivity extends Activity {

	SimpleDateFormat formatDate = new SimpleDateFormat("EEEE dd MMMM");
	Calendar dateAndTime = Calendar.getInstance();

	TextView tvSelectedCourseLibelle;
	TextView tvSelectedCourseDate;
	TextView tvSelectedCourseProduits;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selected_courses);

		// RŽcupŽration des vues
		tvSelectedCourseLibelle = (TextView) findViewById(R.id.tvSelectedCourseLibelle);
		tvSelectedCourseDate = (TextView) findViewById(R.id.tvSelectedCourseDate);
		tvSelectedCourseProduits = (TextView) findViewById(R.id.tvSelectedCourseProduits);

		// On rŽcup�re les informations du RDV sŽlectionnŽ
		Bundle objetbundle = this.getIntent().getExtras();
		int i = objetbundle.getInt("position");
		Courses laCourseSelectionnee = Courses.getCourse(i);

		SimpleDateFormat formatDate = new SimpleDateFormat("dd MMMM yyyy");
		
		// On alimente les vues
		tvSelectedCourseLibelle.setText(laCourseSelectionnee.getNom());
		tvSelectedCourseProduits.setText(laCourseSelectionnee.getLesProduits());
		tvSelectedCourseDate.setText(formatDate.format(laCourseSelectionnee.getDate().getTime()));


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
			Intent intent = new Intent(this, EditCourseActivity.class);
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
					.setMessage("Etes-vous sûr de vouloir supprimer cette course ?")
					.setCancelable(true)
					.setPositiveButton("Oui",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									// On supprimer la course
									Courses.allCourses.remove(i);
									
									Toast.makeText(getApplicationContext(), "La course a été supprimée", Toast.LENGTH_LONG).show();
									
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

		Courses laCourseSelectionnee = Courses.getCourse(i);

		Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
		sharingIntent.setType("text/plain");

		// Ce que l'on partage
		String stShare = "Nouvelle Course : " + laCourseSelectionnee.getNom();
		stShare += System.getProperty("line.separator") + "Liste des produits : "
				+ laCourseSelectionnee.getLesProduits();
		stShare += System.getProperty("line.separator")
				+ System.getProperty("line.separator")
				+ "Créer avec l'application Android URD8 : n'oubliez plus l'essentiel !";

		sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
				"Course à ne pas oublier : \"" + laCourseSelectionnee.getNom() + "\"");
		sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, stShare);

		startActivity(Intent.createChooser(sharingIntent, "Partager cette course"));

	}
}