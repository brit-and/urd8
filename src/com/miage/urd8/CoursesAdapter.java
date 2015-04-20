package com.miage.urd8;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CoursesAdapter extends BaseAdapter {

	private List<Courses> biblio;
	private LayoutInflater inflater;

	public CoursesAdapter(Context context, List<Courses> biblio) {

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
		TextView tvAllCoursesDate;
		TextView tvAllCoursesLibelle;
		TextView tvAllCoursesNbProduits;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;

		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.item_courses, null);
			holder.tvAllCoursesDate = (TextView) convertView.findViewById(R.id.tvAllCoursesDate);
			holder.tvAllCoursesLibelle = (TextView) convertView.findViewById(R.id.tvAllCoursesLibelle);
			holder.tvAllCoursesNbProduits = (TextView) convertView.findViewById(R.id.tvAllCoursesNbProduits);
			convertView.setTag(holder);
		}

		else {
			holder = (ViewHolder) convertView.getTag();
		}

		Calendar laDate = biblio.get(position).getDate();
		SimpleDateFormat formatDate = new SimpleDateFormat("dd MMMM yyyy");
		
		String lesProduits = biblio.get(position).getLesProduits();
		String[] lines = lesProduits.split(System.getProperty("line.separator"));
		int nbProduits = lines.length;

		
		holder.tvAllCoursesDate.setText(formatDate.format(laDate.getTime()));
		holder.tvAllCoursesLibelle.setText(biblio.get(position).getNom());
		holder.tvAllCoursesNbProduits.setText(nbProduits + " produits");
		
		
		return convertView;
	}

}
