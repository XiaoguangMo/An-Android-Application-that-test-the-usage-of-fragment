package org.crazyit.app;

import org.crazyit.app.model.BookContent;
import org.crazyit.app.model.BookContent.Book;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
public class BookDetailFragment extends Fragment
{
	public static final String ITEM_ID = "item_id";
	BookContent.Book book;
	
//	book.addItem(new Book(1, "姓名"
//			, "张三"));
//	BookContent.addItem(new Book(1, "姓名"
//			, "张三"));
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		if (getArguments().containsKey(ITEM_ID))
		{
			book = BookContent.Book.ITEM_MAP.get(getArguments()
				.getInt(ITEM_ID)); //��
//			book = BookContent.ITEM_MAP.get(arg0)
//			book.addItem(new Book(1, "姓名"
//					, "张三"));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater
		, ViewGroup container, Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.fragment_book_detail,
				container, false);
		if (book != null)
		{
			((TextView) rootView.findViewById(R.id.book_title))
					.setText(book.title);
			((TextView) rootView.findViewById(R.id.book_desc))
				.setText(book.desc);	
		}
		return rootView;
	}
}
