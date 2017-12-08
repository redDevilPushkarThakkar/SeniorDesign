package com.example.pushkar.seniordesign;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BusinessDisplay extends AppCompatActivity {
    private ListView reviewListView;
    private ReviewListAdapter adapter;
    private List<Review> mReviewList;
    private RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_display);
        ratingBar = (RatingBar) findViewById(R.id.ratingBarID);
       // ratingBar.setIsIndicator(true);
        reviewListView = (ListView)findViewById(R.id.reviewsListViewID);
        mReviewList = new ArrayList<>();
        mReviewList.add(new Review(1,"Pushkar","when a function denotes different and potentially heterogeneous implementations depending on a limited range of individually specified types and combinations. Ad hoc polymorphism is supported in many languages usi. when code is written without mention of any specific type and thus can be used transparently with any number of new types. In the object-oriented programming community, this is often known as generics or generic programming. In the functional programming community, this is often shortened to polymorphi",3.5,1,2,3,4,5));
        mReviewList.add(new Review(2,"Vaishnavi","Coffee is slightly acidic and can have a stimulating effect ",2.5,1,2,3,4,5));
        mReviewList.add(new Review(3,"Lee","Once ripe, coffee berries are picked, processed, and dried. Dried coffee seeds (referred to as beans) are roasted to varying degrees, depending on the desired flavor. Roasted beans are ground and brewed with near-boiling water to produce coffee as a beverage.",4.5,1,2,3,4,5));
        mReviewList.add(new Review(4,"Shivendra","The earliest credible evidence of coffee-drinking or knowledge of the coffee tree appears in the middle of the 15th century in the accounts of Ahmed al-Ghaffar in Yemen.",1.5,1,2,3,4,5));
        mReviewList.add(new Review(5,"Team","Great!",1,1,2,3,4,5));
        mReviewList.add(new Review(6,"Jack","Board is bad",3,1,2,3,4,5));
        mReviewList.add(new Review(7,"Jill","Food is not good but the people are nice and inclusive and accomodating",4,1,2,3,4,5));
        mReviewList.add(new Review(8,"James","This is a trial",5,1,2,3,4,5));
        mReviewList.add(new Review(9,"Shaun","Trials are boring",4.5,1,2,3,4,5));
        mReviewList.add(new Review(10,"Chris","hello everyone",3.5,1,2,3,4,5));
        mReviewList.add(new Review(11,"Christopher","Senior design 2 will be alot smoother",0.5,1,2,3,4,5));

        adapter = new ReviewListAdapter(getApplicationContext(),mReviewList);
        reviewListView.setAdapter(adapter);

        reviewListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Review r = (Review) (reviewListView.getItemAtPosition(i));
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(BusinessDisplay.this);
                View mView = getLayoutInflater().inflate(R.layout.alert_dialog_layout_review,null);
                //declare and assign id to variables
                TextView authorTextViewOnAlert = (TextView) mView.findViewById(R.id.authorTextViewOnAlertID);
                RatingBar overallratingOnAlert = (RatingBar) mView.findViewById(R.id.overallRatingOnAlertRatingBarID);
                RatingBar categoryOneRatingOnAlert = (RatingBar) mView.findViewById(R.id.categoryOneRatingOnAlertRatingBarID);
                RatingBar categoryTwoRatingOnAlert = (RatingBar) mView.findViewById(R.id.categoryTwoRatingOnAlertRatingBarID);
                RatingBar categoryThreeRatingOnAlert = (RatingBar) mView.findViewById(R.id.categoryThreeRatingOnAlertRatingBarID);
                RatingBar categoryFourRatingOnAlert = (RatingBar) mView.findViewById(R.id.categoryFourRatingOnAlertRatingBarID);
                RatingBar categoryFiveRatingOnAlert = (RatingBar) mView.findViewById(R.id.categoryFiveRatingOnAlertRatingBarID);
                TextView commentOnAlertDialog = (TextView) mView.findViewById(R.id.reviewTextViewOnAlertID);
                //setting variables to the data
                authorTextViewOnAlert.setText(r.getAuthor());
                overallratingOnAlert.setRating(((float) r.getReviewStars()));
                categoryOneRatingOnAlert.setRating(r.getCategoryOneStar());
                categoryTwoRatingOnAlert.setRating(r.getCategoryTwoStar());
                categoryThreeRatingOnAlert.setRating(r.getCategoryThreeStar());
                categoryFourRatingOnAlert.setRating(r.getCategoryFourStar());
                categoryFiveRatingOnAlert.setRating(r.getCategoryFiveStar());
                commentOnAlertDialog.setText(r.getComment());
                //create the alert dialog
                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();

            }
        });


    }
}
