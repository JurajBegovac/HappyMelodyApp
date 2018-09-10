package tomislav.kurtovic.com.happymelodyapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import tomislav.kurtovic.com.happymelodyapp.db.School;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.gracani).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(SchoolActivity.getStartIntent(MainActivity.this, School.GRACANI));
			}
		});

		findViewById(R.id.markusevec).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(SchoolActivity.getStartIntent(MainActivity.this, School.MARKUSEVEC));
			}
		});

		findViewById(R.id.srebrnjak).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(SchoolActivity.getStartIntent(MainActivity.this, School.SREBRNJAK));
			}
		});

		findViewById(R.id.mioc).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(SchoolActivity.getStartIntent(MainActivity.this, School.MIOC));
			}
		});
	}
}
