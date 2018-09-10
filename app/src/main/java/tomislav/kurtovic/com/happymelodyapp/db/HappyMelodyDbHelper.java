package tomislav.kurtovic.com.happymelodyapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import tomislav.kurtovic.com.happymelodyapp.db.HappyMelodyDbContract.StudentEntry;

public class HappyMelodyDbHelper extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "HappyMelody.db";

	public HappyMelodyDbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(HappyMelodyDbContract.CREATE_STUDENT_ENTRIES);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

	public long insertStudent(String name, String surname, School school, String activity,
			String installment) {
		SQLiteDatabase writableDatabase = getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(StudentEntry.COLUMN_NAME, name);
		contentValues.put(StudentEntry.COLUMN_SURNAME, surname);
		contentValues.put(StudentEntry.COLUMN_SCHOOL, school.toString());
		contentValues.put(StudentEntry.COLUMN_ACTIVITY, activity);
		contentValues.put(StudentEntry.COLUMN_INSTALLMENT, installment);
		return writableDatabase.insert(StudentEntry.TABLE_NAME, null, contentValues);
	}

	public Cursor queryStudents(School school) {
		SQLiteDatabase db = getReadableDatabase();

		// Filter results WHERE "school" = school
		String selection = StudentEntry.COLUMN_SCHOOL + " = ?";
		String[] selectionArgs = { school.toString() };

		// How you want the results sorted in the resulting Cursor
		String sortOrder = StudentEntry.COLUMN_SURNAME + " DESC";

		return db.query(
				StudentEntry.TABLE_NAME,   // The table to query
				null,             // The array of columns to return (pass null to get all)
				selection,              // The columns for the WHERE clause
				selectionArgs,          // The values for the WHERE clause
				null,                   // don't group the rows
				null,                   // don't filter by row groups
				sortOrder               // The sort order
		);
	}

}
