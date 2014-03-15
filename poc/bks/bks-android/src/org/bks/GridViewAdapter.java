package org.bks;

import java.util.List;

import org.bks.model.Book;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Caron Zhao
 * 
 *         Feb 27, 2014 9:39:04 PM
 */
public class GridViewAdapter extends BaseAdapter {
	private Context context;
	private List<Book> books;
	private Bitmap[] bookCovers;

	public GridViewAdapter(Context context, List<Book> books) {
		this.context = context;
		this.books = books;
		bookCovers = new Bitmap[books.size()];
	}

	@Override
	public int getCount() {
		return books.size();
	}

	@Override
	public Object getItem(int position) {
		return books.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		MyGridView tag;
		if (convertView == null) {
			View view = LayoutInflater.from(context).inflate(R.layout.gridview_list, null);
			tag = new MyGridView();
			tag.imageView = (ImageView) view.findViewById(R.id.grid_image);
			tag.textView = (TextView) view.findViewById(R.id.grid_title);
			view.setTag(tag);
			convertView = view;					
		} else {
			tag = (MyGridView) convertView.getTag();
		}

		if (bookCovers[position] != null) {
			tag.imageView.setImageBitmap(bookCovers[position]);	
			tag.textView.setText(books.get(position).getTitle());
			tag.textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);
		}

		return convertView;
	}
	
	public void setBitmap(int position, Bitmap bitmap) {
		bookCovers[position] = bitmap;
	}
	
	class MyGridView {
		ImageView imageView;
		TextView textView;
	}
}