package de.schroedel.doitlater.activity;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import de.schroedel.doitlater.R;
import de.schroedel.doitlater.content.ToDoItem;
import de.schroedel.doitlater.fragment.DateTimePickerFragment;

/**
 * Created by Christian Schrödel on 10.04.15.
 *
 * Activity creating/editing to do list items.
 */
public class ItemCreateActivity extends AppCompatActivity implements
	DateTimePickerFragment.OnDateTimePickedCallback
{
	private EditText etTitle;
	private EditText etDesc;

	private long timestamp;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_create);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		final ActionBar actionBar = getSupportActionBar();

		if (actionBar != null)
		{
			actionBar.setTitle(R.string.activity_label_update);
			actionBar.setDisplayHomeAsUpEnabled(true);
		}

		Intent intent = getIntent();

		if (intent == null)
			return;

		this.etTitle = (EditText) findViewById(R.id.et_title);
		this.etDesc = (EditText) findViewById(R.id.et_desc);

		String title = intent.getStringExtra(ToDoItem.EXTRA_TITLE);
		String description = intent.getStringExtra(ToDoItem.EXTRA_DESCRIPTION);

		this.timestamp = intent.getLongExtra(ToDoItem.EXTRA_TIMESTAMP, 0);

		if (title != null)
			etTitle.setText(title);

		if (description != null)
			etDesc.setText(description);

		Button btnDate = (Button) findViewById(R.id.btn_dateTime);
		btnDate.setOnClickListener(
			new View.OnClickListener()
			{
				@Override
				public void onClick(View view)
				{
					Bundle arguments = new Bundle();
					arguments.putLong(ToDoItem.EXTRA_TIMESTAMP, timestamp);

					DialogFragment picker = new DateTimePickerFragment();
					picker.setArguments(arguments);
					picker.show(getFragmentManager(), "dateTimePicker");
				}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_edit, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem)
	{
		int id = menuItem.getItemId();

		if (id == android.R.id.home)
		{
			NavUtils.navigateUpTo(
				this,
				new Intent(
					this,
					ItemListActivity.class));

			return true;
		}
		else if (id == R.id.action_edit)
		{
			Intent data = new Intent();
			data.putExtra(ToDoItem.EXTRA_TITLE, etTitle.getText().toString());
			data.putExtra(
				ToDoItem.EXTRA_DESCRIPTION,
				etDesc.getText().toString());
			data.putExtra(ToDoItem.EXTRA_TIMESTAMP, timestamp);

			setResult(RESULT_OK, data);
			finish();

			return false;
		}

		return super.onOptionsItemSelected(menuItem);
	}

	@Override
	public void onDateTimePicked(long timestamp)
	{
		this.timestamp = timestamp;
	}
}