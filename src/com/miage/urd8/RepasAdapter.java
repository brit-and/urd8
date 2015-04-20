package com.miage.urd8;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RepasAdapter extends BaseAdapter {

	private List<Repas> biblio;
	private LayoutInflater inflater;

	public RepasAdapter(Context context, List<Repas> biblio) {

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
		TextView tvAllRepasType;
		TextView tvAllRepasLibelle;
		TextView tvAllRepasNbPersonnes;
		TextView tvAllRepasCalories;
		TextView tvAllRepasExtraitRecette;
		ImageView imAllRepasImage;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;

		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.item_repas, null);
			holder.tvAllRepasType = (TextView) convertView.findViewById(R.id.tvAllRepasType);
			holder.tvAllRepasLibelle = (TextView) convertView.findViewById(R.id.tvAllRepasLibelle);
			holder.tvAllRepasNbPersonnes = (TextView) convertView.findViewById(R.id.tvAllRepasNbPersonnes);
			holder.tvAllRepasCalories = (TextView) convertView.findViewById(R.id.tvAllRepasCalories);
			holder.tvAllRepasExtraitRecette = (TextView) convertView.findViewById(R.id.tvAllRepasExtraitRecette);
			holder.imAllRepasImage = (ImageView) convertView.findViewById(R.id.ivAllRepasImage);
			convertView.setTag(holder);
		}

		else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		String leType = null;
		switch(biblio.get(position).getType())
		{
		case 1: 
			leType = "Entrée";
			holder.imAllRepasImage.setImageResource(R.drawable.entree);
			break;
		case 2:
			leType = "Plat";
			holder.imAllRepasImage.setImageResource(R.drawable.plat);
			break;
		case 3:
			leType ="Dessert";
			holder.imAllRepasImage.setImageResource(R.drawable.dessert);
			break;
		}

		holder.tvAllRepasType.setText(leType);
		holder.tvAllRepasLibelle.setText(biblio.get(position).getNom());
		holder.tvAllRepasNbPersonnes.setText("Pour " + biblio.get(position).getNbPersonnes() + " personnes");
		holder.tvAllRepasCalories.setText(biblio.get(position).getCalories() + " calories");
		if(biblio.get(position).getRecette().toString().length() > 89)
		{
		holder.tvAllRepasExtraitRecette.setText(biblio.get(position).getRecette().substring(0, 90) + "...");	
		}
		else
		{
		holder.tvAllRepasExtraitRecette.setText(biblio.get(position).getRecette().toString());	
		}
		
		
		return convertView;
	}

}
