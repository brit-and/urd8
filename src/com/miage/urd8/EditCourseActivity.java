package com.miage.urd8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditCourseActivity extends Activity {

	EditText etLibelle;
	EditText etContenu;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_add_courses);

		etLibelle = (EditText) findViewById(R.id.etCoursesLibelle);
		etContenu = (EditText) findViewById(R.id.etCoursesProduits);

		TextView label = (TextView) findViewById(R.id.tvCourse);
		label.setText("Editer la course");

		// On r�cup�re la course que l'on souhaite �diter
		Bundle objetbundle = this.getIntent().getExtras();
		int i = objetbundle.getInt("position");
		Courses laCourseSelectionnee = Courses.getCourse(i);

		// On affecte les valeurs du RDV aux diff�rentes vues
		etLibelle.setText(laCourseSelectionnee.getNom());
		etContenu.setText(laCourseSelectionnee.getLesProduits());

	}

	// Lors de la validation du formulaire
	public void validateForm(View v) {
		boolean err = false;
		// On v�rifie si tous les champs ont �t� remplis
		if (etLibelle.getText().length() == 0
				|| etLibelle.getText().toString().trim().isEmpty() == true) {
			etLibelle.setError("Cette information est obligatoire");
			err = true;
		}

		if (etContenu.getText().length() == 0
				|| etContenu.getText().toString().trim().isEmpty() == true) {
			etContenu.setError("Cette information est obligatoire");
			err = true;
		}

		if (!err) {
			// On r�cup�re les donn�es
			Bundle objetbundle = this.getIntent().getExtras();
			int position = objetbundle.getInt("position");
			Courses laCourseSelectionnee = Courses.getCourse(position);

			String libelle = etLibelle.getText().toString();
			String contenu = etContenu.getText().toString();

			// On peut �diter notre objet
			laCourseSelectionnee.setNom(libelle);
			laCourseSelectionnee.setLesProduits(contenu);

			// On retourne sur l'activit� principale
			Intent intent = new Intent(this, MainActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			startActivity(intent);
			finish();

			Toast.makeText(getApplicationContext(), "La course a �t� �dit�e",
					Toast.LENGTH_LONG).show();

		}

	}

}