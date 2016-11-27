package com.espoir.app;

/**
 * Created by Lenovo on 14/11/2016.
 */
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

public class MyListShopping  extends ListeCourseListFragment {

    public MyListShopping() {}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {
        // All my posts
        return databaseReference.child("Status")  ;
    }
}
