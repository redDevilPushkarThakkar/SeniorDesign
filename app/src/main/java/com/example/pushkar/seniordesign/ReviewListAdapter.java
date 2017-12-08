package com.example.pushkar.seniordesign;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pushkar on 11/11/17.
 */

public class ReviewListAdapter extends BaseAdapter {
    private Context mContext;
    private List<Review> mReviewList;


    //constructor



    public ReviewListAdapter(Context mContext, List<Review> mReviewList) {
        this.mContext = mContext;
        this.mReviewList = mReviewList;
    }

    @Override
    public int getCount() {
        return mReviewList.size();
    }

    @Override
    public Object getItem(int i) {
        return mReviewList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(mContext,R.layout.review_element,null);
        TextView tvAuthor = (TextView)v.findViewById(R.id.reviewAuthorID);
        TextView tvComment = (TextView)v.findViewById(R.id.reviewStringID);
        tvAuthor.setText(mReviewList.get(i).getAuthor()+": ");
        tvComment.setText(mReviewList.get(i).getComment());

        return v;
    }
}
