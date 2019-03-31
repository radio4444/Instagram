package com.example.instagram.Fragment;

import android.util.Log;

import com.example.instagram.Post;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ProfileFragment extends PostFragment {
    @Override
    protected void queryPost() {
        super.queryPost();
        ParseQuery<Post> postQuery = new ParseQuery<Post>(Post.class);
        postQuery.include(Post.Key_User);
        postQuery.setLimit(20);
        postQuery.whereEqualTo(Post.Key_User, ParseUser.getCurrentUser());
        postQuery.addDescendingOrder(Post.KEY_CREATED_AT);
        postQuery.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if(e!=null){
                    Log.e(TAG, "Error with query");
                    e.printStackTrace();
                    return;
                }
                nPosts.addAll(posts);
                adapter.notifyDataSetChanged();
                for(int i =0; i<posts.size(); i++){
                    Post post = posts.get(i);
                    Log.d(TAG, "Post: " + post.getDescription()+ ", username: " + post.getUser().getUsername() );
                }
            }
        });
    }
}
