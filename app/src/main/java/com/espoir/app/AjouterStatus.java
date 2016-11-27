package com.espoir.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AjouterStatus extends AppCompatActivity {

    private static final String REQUIRED ="REQUIRED" ;
    private static final String TAG ="hhhhhhhhh" ;
    Button bText;
    Button bImage;
    EditText Citation;
    ImageView imageView;
    private DatabaseReference mDatabase;
    Date date = new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_status);

        mDatabase = FirebaseDatabase.getInstance().getReference();


        bImage=(Button) findViewById(R.id.ajouterImageStatus);
        bText=(Button)findViewById(R.id.ajouterTextStatus);
        Citation=(EditText) findViewById(R.id.textStatus);
        imageView=(ImageView) findViewById(R.id.imageStatus);

        bImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  addStatusWithImage();

            }
        });

        bText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitPost();
            }
        });

    }

    private void submitPost() {
        final String title = Citation.getText().toString();

        // Title is required
        if (TextUtils.isEmpty(title)) {
            Citation.setError(REQUIRED);
            return;
        }



        // Disable button so there are no multi-posts
        Toast.makeText(this, "Posting...", Toast.LENGTH_SHORT).show();

        // [START single_value_read]
        final String userId = getUid();
        mDatabase.child("status").child(userId).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value
                        User user = dataSnapshot.getValue(User.class);

                        // [START_EXCLUDE]
                        if (user == null) {
                            // User is null, error out
                            Log.e(TAG, "User " + userId + " is unexpectedly null");
                            Toast.makeText(AjouterStatus.this,
                                    "Error: could not fetch user.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            addStatusText(userId, user.username, title, date.toString());
                        }

                        // Finish this Activity, back to the stream
                        finish();
                        // [END_EXCLUDE]
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w(TAG, "getUser:onCancelled", databaseError.toException());
                        // [START_EXCLUDE]
                        // [END_EXCLUDE]
                    }
                });
        // [END single_value_read]
    }
   
    private void addStatusText(String uid, String author, String body,String date) {


        // Create new post at /user-posts/$userid/$postid and at
        // /posts/$postid simultaneously
        String key = mDatabase.child("Status").push().getKey();
        Status post = new Status( uid,  author,  body);
        Map<String, Object> postValues = post.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/Status/" + key, postValues);
        childUpdates.put("/user-Status/" + uid + "/" + key, postValues);

        mDatabase.updateChildren(childUpdates);
    }
    public String getUid() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }
}
