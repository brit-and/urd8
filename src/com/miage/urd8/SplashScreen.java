package com.miage.urd8;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class SplashScreen extends Activity {
	TextView tvLogin;
	TextView tvMdp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		tvLogin = (TextView) findViewById(R.id.etLogin);
		tvMdp = (TextView) findViewById(R.id.etMdp);
		
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		TextView texteView = (TextView) findViewById(R.id.tvURD8Splash);
		Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Black.ttf");
		texteView.setTypeface(font);

        // Génération des données
		GenerateData.launch();
	}
	
	@Override
	public void onAttachedToWindow() {
	    super.onAttachedToWindow();
	    Window window = getWindow();
	    window.setFormat(PixelFormat.RGBA_8888);
	}
	
	public void connect(View v)
	{
		// vérification des identifiants
		if (tvLogin.getText().toString().equals("user") && tvMdp.getText().toString().equals("user"))
		{
			// Connexion OK
			Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);	
            finish();
		}
		else
		{
			Toast.makeText(getApplicationContext(), "Identifiants incorrects", Toast.LENGTH_LONG).show();
			
		}
		
	}
}
