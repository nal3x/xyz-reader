package com.example.xyzreader.adapter;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.xyzreader.data.ArticleLoader;
import com.example.xyzreader.ui.ArticleDetailFragment;

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    private Cursor mCursor;

    public MyPagerAdapter(FragmentManager fm, Cursor cursor) {
        super(fm);
        mCursor = cursor;
    }

    @Override
    public Fragment getItem(int position) {
        mCursor.moveToPosition(position);
        return ArticleDetailFragment.newInstance(mCursor.getLong(ArticleLoader.Query._ID));
    }

    @Override
    public int getCount() {
        return (mCursor != null) ? mCursor.getCount() : 0;
    }

    public Cursor swapCursor(Cursor newCursor) {
        if (newCursor == mCursor) {
            return null;
        }
        mCursor = newCursor;
        if (newCursor != null) {
            notifyDataSetChanged();
        }
        return mCursor;
    }
}
