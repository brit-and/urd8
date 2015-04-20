package com.miage.urd8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddCourseActivity extends Activity {

	EditText etLibelle;
	EditText etContenu;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_add_courses);

		etLibelle = (EditText) findViewById(R.id.etCoursesLibelle);
		etContenu = (EditText) findViewById(R.id.etCoursesProduits);

	}

	// Lors de la validation du formulaire
	public void validateForm(View v) {
		boolean err = false;
		// On vérifie si tous les champs ont ŽtŽ remplis
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
			// On récupère les données

			String libelle = etLibelle.getText().toString();
			String contenu = etContenu.getText().toString();

			// On peut créer notre objet
			Courses laCourse = new Courses(libelle, contenu);

			// On rajoute l'objet dans la collection
			Courses.allCourses.add(laCourse);

			// On retourne sur l'activitŽ principale
			Intent intent = new Intent(this, MainActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			startActivity(intent);
			finish();
			
			Toast.makeText(getApplicationContext(), "La course a ŽtŽ crŽŽe", Toast.LENGTH_LONG).show();

		}

	}

}