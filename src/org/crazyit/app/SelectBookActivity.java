package org.crazyit.app;

import org.crazyit.app.model.BookContent;
import org.crazyit.app.model.BookContent.Book;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

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
public class SelectBookActivity extends Activity implements
		BookListFragment.Callbacks
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Intent intent = this.getIntent();
		String name = intent.getStringExtra("name");
		String password = intent.getStringExtra("password");
		String nation = intent.getStringExtra("nation");
		String email = intent.getStringExtra("email");
		String sex = intent.getStringExtra("sex");
		setContentView(R.layout.activity_book_twopane);
		BookContent.Book.addItem(new Book(1, "姓名"
				, name));
		BookContent.Book.addItem(new Book(2, "密码"
				, password));
		BookContent.Book.addItem(new Book(3, "邮箱"
				, email));
		BookContent.Book.addItem(new Book(4, "性别"
					, sex));
		BookContent.Book.addItem(new Book(5, "国籍"
					, nation));
	}
	@Override
	public void onItemSelected(Integer id)
	{
		Bundle arguments = new Bundle();
		arguments.putInt(BookDetailFragment.ITEM_ID, id);
		BookDetailFragment fragment = new BookDetailFragment();
		fragment.setArguments(arguments);
		getFragmentManager().beginTransaction()
			.replace(R.id.book_detail_container, fragment)
			.commit();  //��
	}
}
