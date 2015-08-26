package org.crazyit.app;

import org.crazyit.app.model.BookContent;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Description:
 * <br/>website: <a href="http://www.crazyit.org">crazyit.org</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class BookListFragment extends ListFragment
{
	private Callbacks mCallbacks;
	public interface Callbacks
	{
		public void onItemSelected(Integer id);
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<BookContent.Book>(getActivity(),
				android.R.layout.simple_list_item_activated_1,
				android.R.id.text1, BookContent.Book.ITEMS));
	}
	@Override
	public void onAttach(Activity activity)
	{
		super.onAttach(activity);
		if (!(activity instanceof Callbacks))
		{
			throw new IllegalStateException(
				"BookListFragment������Activity��������Callbacks����!");
		}
		mCallbacks = (Callbacks)activity;
	}
	@Override
	public void onDetach()
	{
		super.onDetach();
		mCallbacks = null;
	}
	@Override
	public void onListItemClick(ListView listView
		, View view, int position, long id)
	{
		super.onListItemClick(listView, view, position, id);
		mCallbacks.onItemSelected(BookContent.Book
			.ITEMS.get(position).id);
	}

	public void setActivateOnItemClick(boolean activateOnItemClick)
	{
		getListView().setChoiceMode(
				activateOnItemClick ? ListView.CHOICE_MODE_SINGLE
						: ListView.CHOICE_MODE_NONE);
	}
}
