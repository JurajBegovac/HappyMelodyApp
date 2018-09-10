package tomislav.kurtovic.com.happymelodyapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import tomislav.kurtovic.com.happymelodyapp.db.HappyMelodyDbContract.StudentEntry;

public class CustomCursorAdapter extends CursorAdapter {

	public CustomCursorAdapter(Context context, Cursor c) {
		super(context, c, 0);
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		return LayoutInflater.from(context).inflate(R.layout.item_student, parent, false);
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {

		TextView tvName = view.findViewById(R.id.itemName);
		TextView tvSurname = view.findViewById(R.id.itemSurname);
		TextView tvActivity = view.findViewById(R.id.itemActivity);
		TextView tvInstallment = view.findViewById(R.id.itemInstallment);

		String name = cursor.getString(cursor.getColumnIndexOrThrow(StudentEntry.COLUMN_NAME));
		String surname = cursor.getString(cursor.getColumnIndexOrThrow(StudentEntry.COLUMN_SURNAME));
		String activity = cursor.getString(cursor.getColumnIndexOrThrow(StudentEntry.COLUMN_ACTIVITY));
		String installment = cursor.getString(cursor.getColumnIndexOrThrow(StudentEntry.COLUMN_INSTALLMENT));

		tvName.setText(name);
		tvSurname.setText(surname);
		tvActivity.setText(activity);
		tvInstallment.setText(installment);
	}
}
