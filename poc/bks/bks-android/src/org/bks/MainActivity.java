package org.bks;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.bks.model.Book;
import org.bks.model.SharedBooks;
import org.bks.util.JsonTranslation;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity implements OnTouchListener {
	private LinearLayout linearLayoutHome;
	private LinearLayout linearLayoutBook;
	private LinearLayout linearLayoutShare;
	private LinearLayout linearLayoutSelfinfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		View mainView = loadMainLayout();
		setContentView(mainView);
		loadLinearLayout(mainView);
		
//		ListView listViewHome = (ListView) mainView.findViewById(R.id.listview_home);
//		ListAdapter adapter = new SimpleAdapter(this, getBookList(),
//                R.layout.book_list, new String[] { "title", "introduction", "image" },
//                new int[] { R.id.title, R.id.introduction, R.id.image });
//		listViewHome.setAdapter(adapter);
		
		GridView shareListGridView = (GridView) findViewById(R.id.sharelist_home);
		loadShareList(shareListGridView, ShareFilter.ALL);
		
		shareListGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private View loadMainLayout() {
		View mainView = getLayoutInflater().inflate(R.layout.main, null);
		LinearLayout linearLayout = (LinearLayout) mainView.findViewById(R.id.linearlayout_toolbar);
		String[] toolbarButtonTexts = getResources().getStringArray(R.array.array_toolbar_btn_text);
		TypedArray toolbarButtonImageResourceIds = getResources().obtainTypedArray(R.array.array_toolbar_btn_image_resource);
		TypedArray toolbarButtonIds = getResources().obtainTypedArray(R.array.array_toolbar_btn_id);
		
		for (int i = 0; i < toolbarButtonTexts.length; i++) {
			View view = getLayoutInflater().inflate(R.layout.toolbar_btn, null);
			view.setId(toolbarButtonIds.getResourceId(i, 0));
			view.setOnTouchListener(this);
			ImageView imageView = (ImageView) view.findViewById(R.id.imageview_toolbar_btn);
			TextView textView = (TextView) view.findViewById(R.id.textview_toolbar_text);
			imageView.setImageDrawable(toolbarButtonImageResourceIds.getDrawable(i));
			textView.setText(toolbarButtonTexts[i]);
			view.setFocusableInTouchMode(true);
							
			linearLayout.addView(view, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1));
		}
		
		return mainView;
	}
	
	private void loadLinearLayout(View mainView) {
		linearLayoutHome = (LinearLayout) mainView.findViewById(R.id.linearlayout_home);		
		linearLayoutBook = (LinearLayout) mainView.findViewById(R.id.linearlayout_book);
		linearLayoutShare = (LinearLayout) mainView.findViewById(R.id.linearlayout_share);
		linearLayoutSelfinfo = (LinearLayout) mainView.findViewById(R.id.linearlayout_selfinfo);
		hideLinearLayout();
		
		linearLayoutHome.setVisibility(View.VISIBLE);
	}

	@Override
	public boolean onTouch(View view, MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			switch (view.getId()) {
			case R.id.button_home:
				hideLinearLayout();
				linearLayoutHome.setVisibility(View.VISIBLE);
				break;
			case R.id.button_book:
				hideLinearLayout();
				linearLayoutBook.setVisibility(View.VISIBLE);
				break;
			case R.id.button_share:
				hideLinearLayout();
				linearLayoutShare.setVisibility(View.VISIBLE);
				break;
			case R.id.button_selfinfo:
				hideLinearLayout();
				linearLayoutSelfinfo.setVisibility(View.VISIBLE);
				break;
			}
		}
		return false;
	}
	
	private void hideLinearLayout() {
		linearLayoutHome.setVisibility(View.INVISIBLE);
		linearLayoutBook.setVisibility(View.INVISIBLE);
		linearLayoutShare.setVisibility(View.INVISIBLE);
		linearLayoutSelfinfo.setVisibility(View.INVISIBLE);
	}
	
	private void loadShareList(GridView shareListGridView, ShareFilter filter) {
		List<Book> books = getBookList();		
		GridViewAdapter adapter = new GridViewAdapter(this, books);
//		shareListGridView.setAdapter(new ImageAdapter(this, books));
		
		shareListGridView.setAdapter(adapter);
		new BookLoadTask(adapter).execute(); 
		
	}
	
	private List<Book> getBookList() {
		final List<Book> books = new ArrayList<Book>();
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					String uri = "http://10.0.2.2:8080/bks-web/rest/books/1";
					HttpClient getClient = new DefaultHttpClient();
					HttpGet request = new HttpGet(uri);
					HttpResponse response = getClient.execute(request);
					if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
						String jsonString = EntityUtils.toString(response.getEntity());
						SharedBooks sharedBooks = JsonTranslation.jsonString2Object(jsonString, SharedBooks.class);
						books.addAll(sharedBooks.getBooks());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		thread.start();
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
        return books;
    }
	
//	private List<Map<String, Object>> getBookList() {
//        final List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//		Thread thread = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					String uri = "http://10.0.2.2:8080/bks-web/rest/books/1";
//					HttpClient getClient = new DefaultHttpClient();
//					HttpGet request = new HttpGet(uri);
//					HttpResponse response = getClient.execute(request);
//					if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//						String jsonString = EntityUtils.toString(response.getEntity());
//						SharedBooks books = JsonTranslation.jsonString2Object(jsonString, SharedBooks.class);
//						for (Book book : books.getBooks()) {
//					        Map<String, Object> map = new HashMap<String, Object>();
//					        map.put("title", book.getTitle());
//					        map.put("introduction", book.getIntroduction());
//					        map.put("image", R.drawable.ic_launcher);
//					        list.add(map);
//						}
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//
//		thread.start();
//		
//		try {
//			thread.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//        return list;
//    }
}