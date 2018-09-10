package tomislav.kurtovic.com.happymelodyapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import tomislav.kurtovic.com.happymelodyapp.db.HappyMelodyDbHelper;
import tomislav.kurtovic.com.happymelodyapp.db.School;

public class SchoolActivity extends AppCompatActivity {

	private static final String KEY_SCHOOL = "KEY_SCHOOL";

	public static Intent getStartIntent(Context context, School school) {
		Intent intent = new Intent(context, SchoolActivity.class);
		intent.putExtra(KEY_SCHOOL, school.toString());
		return intent;
	}

	private HappyMelodyDbHelper happyMelodyDbHelper;
	private School school;
	private CursorAdapter cursorAdapter;

	private EditText etStudentName;
	private EditText etStudentSurname;
	private EditText etStudentActivity;
	private EditText etStudentInstallment;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_school);

		// bind views
		etStudentName = findViewById(R.id.etStudentName);
		etStudentSurname = findViewById(R.id.etStudentSurname);
		etStudentActivity = findViewById(R.id.etStudentActivity);
		etStudentInstallment = findViewById(R.id.etStudentInstallment);
		findViewById(R.id.btnAddStudent).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				addStudent();
			}
		});

		// get school from intent
		school = School.valueOf(getIntent().getStringExtra(KEY_SCHOOL));

		// set title
		ActionBar supportActionBar = getSupportActionBar();
		if (supportActionBar != null) {
			supportActionBar.setTitle(school.getViewPresentation());
		}

		// create db helper
		happyMelodyDbHelper = new HappyMelodyDbHelper(this);

		// create adapter and list
		cursorAdapter = new CustomCursorAdapter(this, getCursor());
		ListView listView = findViewById(R.id.lvStudents);
		listView.setAdapter(cursorAdapter);
	}

	@Override
	protected void onDestroy() {
		// close helper here !
		happyMelodyDbHelper.close();
		super.onDestroy();
	}

	private Cursor getCursor() {
		return happyMelodyDbHelper.queryStudents(school);
	}

	private void addStudent() {
		if (isEmpty(etStudentName)) {
			showToast("Ime je prazno.");
			return;
		}

		if (isEmpty(etStudentSurname)) {
			showToast("Prezime je prazno.");
			return;
		}

		if (isEmpty(etStudentInstallment)) {
			showToast("Rata je prazna.");
			return;
		}

		if (isEmpty(etStudentActivity)) {
			showToast("Aktivnost je prazna.");
			return;
		}

		happyMelodyDbHelper.insertStudent(etStudentName.getText().toString(),
				etStudentSurname.getText().toString(), school,
				etStudentActivity.getText().toString(), etStudentInstallment.getText().toString());

		cursorAdapter.changeCursor(getCursor());
	}

	private void showToast(String text) {
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}

	private boolean isEmpty(EditText etText) {
		return etText.getText().toString().trim().length() == 0;
	}
}
