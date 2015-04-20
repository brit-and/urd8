package com.miage.urd8;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class FragmentRDV extends Fragment implements OnGestureListener {

	Context c;
	ListView list;
	List<RDV> allRDV;
	RDVAdapter adapter;
	GestureDetector gestureDetector;

	public FragmentRDV() {

	}

	public FragmentRDV(Context c) {
		this.c = c;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// On rŽcup�re la listview
		View v = inflater.inflate(R.layout.laliste, container, false);
		list = (ListView) v.findViewById(R.id.lvRDV);

		Context context = getActivity().getApplicationContext();

		// On rŽcup�re la liste des RDV
		allRDV = RDV.getAllRDV();

		// On dŽclare notre adapter perso
		adapter = new RDVAdapter(context, RDV.allRDV);

		// SetAdapter
		list.setAdapter(adapter);
		
		// Détection mouvements
		gestureDetector = new GestureDetector(this);
		OnTouchListener gestureListener = new View.OnTouchListener() {
		    public boolean onTouch(View v, MotionEvent event) {
		        return gestureDetector.onTouchEvent(event);
		    }
		};

		list.setOnTouchListener(gestureListener);
		
		// On capture le click sur un item
		list.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent viewEntry = new Intent(getActivity()
						.getApplicationContext(), SelectedRDVActivity.class);
				Bundle objetbundle = new Bundle();
				objetbundle.putInt("position", position);
				viewEntry.putExtras(objetbundle);
				startActivity(viewEntry);
			}
		});

		return v;
	}

	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		return false;
	}

	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

}
