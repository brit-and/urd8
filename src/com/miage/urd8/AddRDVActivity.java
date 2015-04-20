package com.miage.urd8;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class AddRDVActivity extends Activity {

	SimpleDateFormat formatHeure = new SimpleDateFormat("kk:mm");
	SimpleDateFormat formatDate = new SimpleDateFormat("EEEE dd MMM. yyyy");
	Calendar dateAndTime = Calendar.getInstance();
	Calendar dateDeb;
	Calendar dateFin;
	Calendar heureDeb;
	Calendar heureFin;
	String flag;

	Button btHeureDeb;
	Button btHeureFin;
	Button btDateDeb;
	Button btDateFin;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_add_rdv);

		btHeureDeb = (Button) findViewById(R.id.btHeureDeb);
		btHeureFin = (Button) findViewById(R.id.btHeureFin);
		btDateDeb = (Button) findViewById(R.id.btDateDeb);
		btDateFin = (Button) findViewById(R.id.btDateFin);
		
		// On alimente les heures/dates par défaut
		 dateDeb = dateAndTime;
		 dateFin = dateAndTime;
		 heureDeb = dateAndTime;
		 heureFin = dateAndTime;
		 heureFin.add(Calendar.HOUR, 1);

		// On alimente les buttons avec la date actuelle
		btDateDeb.setText(formatDate.format(dateDeb.getTime()));
		btDateFin.setText(formatDate.format(dateFin.getTime()));
		btHeureDeb.setText(formatHeure.format(heureDeb.getTime()));
		btHeureFin.setText(formatHeure.format(heureFin.getTime()));
		
		
	}
	

	// Lors de la validation du formulaire
	public void validateForm(View v) {
		// On vérifie si le libellé a été renseigné (seul champ obligatoire)
		EditText etRDVLibelle = (EditText) findViewById(R.id.etRDVLibelle);
		if (etRDVLibelle.getText().length() == 0
				|| etRDVLibelle.getText().toString().trim().isEmpty() == true) {
			etRDVLibelle.setError("Cette information est obligatoire");
		}

		else {
			// On récupère les données
			EditText etDetails = (EditText) findViewById(R.id.etRDVContent);
			EditText etLieu = (EditText) findViewById(R.id.etRDVLieu);
			CheckBox cbJourneeEntiere = (CheckBox) findViewById(R.id.cbJourneeEntiere);
			CheckBox cbImportant = (CheckBox) findViewById(R.id.cbImportant);

			String libelle = etRDVLibelle.getText().toString();
			String details = etDetails.getText().toString();
			String lieu = etLieu.getText().toString();
			
			boolean journeeEntiere = false;
			boolean important = false;

			if (cbJourneeEntiere.isChecked()) {
				journeeEntiere = true;
			}
			
			if (cbImportant.isChecked())
			{
				important = true;
			}
			
			// On peut créer notre objet
			RDV leRDV = new RDV(libelle, details, lieu, dateDeb, dateFin, heureDeb, heureFin, journeeEntiere, important);
			
			// On rajoute l'objet dans la collection
			RDV.getAllRDV().add(leRDV);
			
			Toast.makeText(getApplicationContext(), "Le RDV a ŽtŽ crŽŽ", Toast.LENGTH_LONG).show();

			
			// On retourne sur l'activitŽ principale
			Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
			finish();
            
		}

	}

	// Lors du clic sur la checkbox
	public void toggleTime(View v) {
		CheckBox cb = (CheckBox) v;

		// On cache les heures
		if (cb.isChecked()) {
			btHeureDeb.setVisibility(View.GONE);
			btHeureFin.setVisibility(View.GONE);
		} else {
			btHeureDeb.setVisibility(View.VISIBLE);
			btHeureFin.setVisibility(View.VISIBLE);
		}
	}

	public void chooseDateDeb(View v) {
		new DatePickerDialog(AddRDVActivity.this, d,
				dateAndTime.get(Calendar.YEAR),
				dateAndTime.get(Calendar.MONTH),
				dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
		flag = "DD";
	}

	public void chooseDateFin(View v) {
		new DatePickerDialog(AddRDVActivity.this, d,
				dateAndTime.get(Calendar.YEAR),
				dateAndTime.get(Calendar.MONTH),
				dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
		flag = "DF";
	}

	public void chooseTimeDeb(View v) {
		new TimePickerDialog(AddRDVActivity.this, t,
				dateAndTime.get(Calendar.HOUR_OF_DAY),
				dateAndTime.get(Calendar.MINUTE), true).show();
		flag = "HD";
	}

	public void chooseTimeFin(View v) {
		new TimePickerDialog(AddRDVActivity.this, t,
				dateAndTime.get(Calendar.HOUR_OF_DAY),
				dateAndTime.get(Calendar.MINUTE), true).show();
		flag = "HF";
	}

	private void updateLabelHeureDeb() {
		btHeureDeb.setText(formatHeure.format(heureDeb.getTime()));
	}

	private void updateLabelHeureFin() {
		btHeureFin.setText(formatHeure.format(heureFin.getTime()));
	}

	private void updateLabelDateDeb() {
		btDateDeb.setText(formatDate.format(dateDeb.getTime()));
	}

	private void updateLabelDateFin() {
		btDateFin.setText(formatDate.format(dateFin.getTime()));
	}

	DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			Calendar uneDate = Calendar.getInstance();
			uneDate.set(Calendar.YEAR, year);
			uneDate.set(Calendar.MONTH, monthOfYear);
			uneDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);

			if (flag.equals("DD")) {
				dateDeb = uneDate;
				updateLabelDateDeb();
				
				// On met à jour la dateFin si celle-ci est infèrieure à la nouvelle dateDeb
				if(dateFin.compareTo(dateDeb) == -1)
				{
					dateFin = dateDeb;
					updateLabelDateFin();
				}
			}

			else {
				if(dateDeb.compareTo(uneDate) == -1)
				{
					dateFin = uneDate;
					updateLabelDateFin();
				}
			}
		}
	};

	TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			Calendar uneHeure = Calendar.getInstance();
			uneHeure.set(Calendar.HOUR_OF_DAY, hourOfDay);
			uneHeure.set(Calendar.MINUTE, minute);

			if (flag.equals("HD")) {
				
				heureDeb = uneHeure;
				updateLabelHeureDeb();
				
				// On met à jour l'heure de fin si celle-ci est infèrieure à l'heure de début et si jourDeb = jourFin
				if(dateDeb.compareTo(dateFin) == 0 && heureFin.compareTo(heureDeb) == -1)
				{
					heureFin = heureDeb;
					updateLabelHeureFin();
				}				
			}

			else {
				if(dateDeb.compareTo(dateFin) != 0)
				{
					heureFin = uneHeure;
					updateLabelHeureFin();
				}
				else
				{
					if(uneHeure.compareTo(heureDeb) == 1)
					{
						heureFin = uneHeure;
						updateLabelHeureFin();
					}
				}
			}

		}
	};
}