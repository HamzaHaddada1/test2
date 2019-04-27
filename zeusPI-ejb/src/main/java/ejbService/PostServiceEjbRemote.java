package ejbService;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import entities.*;


@Remote
public interface PostServiceEjbRemote {

	/////////////////////     user service    //////////////////
	
	User addUser(User u);
	User updateUser(User u);
	void deleteUser(User u);
	User findUser(int u);
	List<User> findAllUsers();
	
	/////////////////////     Post service    //////////////////
	
	Post addPost(Post u);
	Post updatePost(Post u);
	void deletePost(int u);
	Post findPost(int u);
	ArrayList<Post> findallPosts();
	
	
	/////////////////////     Comments service    //////////////////
	
	void addComment(Comments u);
	void updateComment(Comments u);
	void deleteComment(Comments u);
	Comments findComment(Comments u);
	List<Comments> findallComments();

	/////////////////////     likes service    //////////////////
	
	void addLike(LikedPost u);
	void deleteLike(LikedPost u);
	
}
