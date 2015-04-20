package com.miage.urd8;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class FragmentCourses extends Fragment  {

	Context c;
	ListView list;
	List<Courses> allCourses;
	CoursesAdapter adapter;
	GestureDetector gestureDetector;

	public FragmentCourses() {

	}

	public FragmentCourses(Context c) {
		this.c = c;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// On rŽcup�re la listview
		View v = inflater.inflate(R.layout.laliste, container, false);
		list = (ListView) v.findViewById(R.id.lvRDV);

		Context context = getActivity().getApplicationContext();

		// On dŽclare notre adapter perso
		adapter = new CoursesAdapter(context, Courses.allCourses);

		// SetAdapter
		list.setAdapter(adapter);
		
		// On capture le click sur un item
		list.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent viewEntry = new Intent(getActivity()
						.getApplicationContext(), SelectedCoursesActivity.class);
				Bundle objetbundle = new Bundle();
				objetbundle.putInt("position", position);
				viewEntry.putExtras(objetbundle);
				startActivity(viewEntry);
			}
		});

		return v;
	}

}
