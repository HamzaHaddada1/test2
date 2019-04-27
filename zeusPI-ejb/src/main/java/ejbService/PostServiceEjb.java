package ejbService;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Comments;
import entities.LikedPost;
import entities.Post;
import entities.User;
/**
 * Session Bean implementation class PostServiceEjb
 */
@Stateless
@LocalBean
public class PostServiceEjb implements PostServiceEjbRemote, PostServiceEjbLocal {

	@PersistenceContext(unitName = "zeusPI-ejb")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public PostServiceEjb() {
		// TODO Auto-generated constructor stub
	}

	///////////////////// user service //////////////////////
	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		
		em.persist(u);
		em.flush();

		return u;
	}

	@Override
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		
		em.clear();
		return em.merge(u);
	}

	@Override
	public void deleteUser(User u) {
		// TODO Auto-generated method stub
		em.clear();
		User u1 = em.find(User.class, u.getId());
		em.remove(u1);

	}

	@Override
	public User findUser(int u) {
		// TODO Auto-generated method stub
		em.clear();
		return em.find(User.class, u);
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub

		// Query qr = em.createQuery(" select Firstname from user u");

		List<User> result = (List<User>) em.createQuery("from User").getResultList();
		return result;
	}

    ////////////////////////////////////////////////////////////////////////////////////////
	///////////////////// post service /////////////////////////////////////////////////////

	

	@Override
	public Post addPost(Post p) {
		// TODO Auto-generated method stub
		em.persist(p);
		em.flush();
		return p;
	}

	@Override
	public Post updatePost(Post p) {
		// TODO Auto-generated method stub

		em.clear();
		return em.merge(p);
	}

	@Override
	public void deletePost(int p) {
		// TODO Auto-generated method stub
		em.clear();
		Post p1 = em.find(Post.class, p);
		em.remove(p1);
	}
	
	@Override
	public Post findPost(int p) {
		// TODO Auto-generated method stub
		
		return em.find(Post.class, p);
	}

	@Override
	public ArrayList<Post> findallPosts() {
		// TODO Auto-generated method stub List<User> result = (List<User>) em.createQuery("from User").getResultList();
		ArrayList<Post> result = (ArrayList<Post>) em.createQuery("from Post").getResultList();
		return result;
	}

	
    ////////////////////////////////////////////////////////////////////////////////////////
	///////////////////// Comments service ////////////////////////////////////////////////
	@Override
	public void addComment(Comments c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateComment(Comments c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteComment(Comments c) {
		// TODO Auto-generated method stub

	}

	@Override
	public Comments findComment(Comments c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comments> findallComments() {
		// TODO Auto-generated method stub
		return null;
	}

	///////////////////// likes service //////////////////////
	@Override
	public void addLike(LikedPost l) {
		// TODO Auto-generated method stub

		em.persist(l);
		em.flush();
		
		
	}

	@Override
	public void deleteLike(LikedPost l) {
		// TODO Auto-generated method stub

		em.flush();
		em.clear();
		Query query = em.createQuery("delete from LikedPost where idpost = '"+ l.getPost().getIdPost() +"' and iduser = '"+l.getUser().getId()+"'");
		query.executeUpdate();
		
	}

	

}
