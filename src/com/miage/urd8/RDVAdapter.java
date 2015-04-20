package com.miage.urd8;

import java.text.SimpleDateFormat;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class RDVAdapter extends BaseAdapter {

	private List<RDV> biblio;
	private LayoutInflater inflater;

	public RDVAdapter(Context context, List<RDV> biblio) {

		inflater = LayoutInflater.from(context);
		this.biblio = biblio;
	}

	public int getCount() {
		return biblio.size();
	}

	public Object getItem(int i) {
		return biblio.get(i);
	}

	public long getItemId(int i) {
		return i;
	}

	private class ViewHolder {
		TextView tvLibelle;
		TextView tvJour;
		TextView tvDateMoisAnnee;
		TextView tvDuAu;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;
		
		// On rŽcup�re les jours / heures de l'Žv�nement
		SimpleDateFormat formatJour = new SimpleDateFormat("EEEE");
		SimpleDateFormat formatDateMoisAnnee = new SimpleDateFormat("dd MMMM yyyy");
		SimpleDateFormat formatHeure = new SimpleDateFormat("kk:mm");

		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.item_rdv, null);
			holder.tvLibelle = (TextView) convertView.findViewById(R.id.tvAllRDVLibelle);
			holder.tvJour = (TextView) convertView.findViewById(R.id.tvAllRDVJour);
			holder.tvDateMoisAnnee = (TextView) convertView.findViewById(R.id.tvAllRDVDateMoisAnnee);
			holder.tvDuAu = (TextView) convertView.findViewById(R.id.tvAllRDVDuAu);
			convertView.setTag(holder);
		}

		else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.tvLibelle.setText(biblio.get(position).getLibelle());
		
		holder.tvJour.setText(formatJour.format(biblio.get(position).getDateDeb().getTime()));
		
		if(biblio.get(position).isJourneeEntiere())
		{
			holder.tvDuAu.setText("Journée entière");
		}
		else
		{
			holder.tvDuAu.setText(formatHeure.format(biblio.get(position).getHeureDeb().getTime()));
		}
		holder.tvDateMoisAnnee.setText(formatDateMoisAnnee.format(biblio.get(position).getDateDeb().getTime()));
		
		
		if(biblio.get(position).isImportant())
		{
			holder.tvLibelle.setTextColor(Color.RED);
		}
		else
		{
			holder.tvLibelle.setTextColor(Color.BLACK);
		}
		
		
		return convertView;
	}

}
