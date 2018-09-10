package tomislav.kurtovic.com.happymelodyapp.db;

import android.provider.BaseColumns;

public final class HappyMelodyDbContract {

	private HappyMelodyDbContract() {
	}

	public static class StudentEntry implements BaseColumns {

		public static final String TABLE_NAME = "student";
		public static final String COLUMN_NAME = "name";
		public static final String COLUMN_SURNAME = "surname";
		public static final String COLUMN_SCHOOL = "school";
		public static final String COLUMN_ACTIVITY = "activity";
		public static final String COLUMN_INSTALLMENT = "installment";
	}

	public static final String CREATE_STUDENT_ENTRIES =
			"CREATE TABLE " + StudentEntry.TABLE_NAME + " (" +
					StudentEntry._ID + " INTEGER PRIMARY KEY," +
					StudentEntry.COLUMN_NAME + " TEXT," +
					StudentEntry.COLUMN_SURNAME + " TEXT," +
					StudentEntry.COLUMN_SCHOOL + " TEXT," +
					StudentEntry.COLUMN_ACTIVITY + " TEXT," +
					StudentEntry.COLUMN_INSTALLMENT + " TEXT)";

	public static final String DELETE_STUDENT_ENTRIES =
			"DROP TABLE IF EXISTS " + StudentEntry.TABLE_NAME;
}
