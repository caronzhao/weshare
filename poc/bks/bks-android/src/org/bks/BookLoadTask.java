package org.bks;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.bks.model.Book;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

/**
 * @author Caron Zhao
 * 
 *         Feb 27, 2014 9:57:27 PM
 */
public class BookLoadTask extends AsyncTask<Void, Void, Void> {
	private GridViewAdapter gridViewAdapter;

	public BookLoadTask(GridViewAdapter gridViewAdapter) {
		this.gridViewAdapter = gridViewAdapter;
	}

	@Override
	protected Void doInBackground(Void... params) {
		for (int i = 0; i < gridViewAdapter.getCount(); i++) {
			Book book = (Book) gridViewAdapter.getItem(i);
			Bitmap bitmap = BitmapFactory.decodeStream(getStream(book.getCoverPath()));
			gridViewAdapter.setBitmap(i, bitmap);
			publishProgress(); // 通知去更新UI
		}

		return null;
	}

	public void onProgressUpdate(Void... voids) {
		if (isCancelled()) {
			return;
		}
		// 更新UI
		gridViewAdapter.notifyDataSetChanged();
	}

	public InputStream getStream(String urlStr) {
		InputStream inStream = null;
		try {
			URL url = new URL(urlStr);
			URLConnection conn = url.openConnection();
			conn.setConnectTimeout(10 * 1000);
			inStream = conn.getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inStream;
	}
}