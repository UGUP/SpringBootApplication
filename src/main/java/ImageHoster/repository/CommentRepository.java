package ImageHoster.repository;

import ImageHoster.model.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CommentRepository {


    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    //This functions stores all the comments of a user in the database.
    public Comment postComment(Comment newComment) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(newComment);
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        }
        return newComment;

    }

    //This function is used to get all the comments from the database for an Image
    public List<Comment> getComments(Integer imageId, String title) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Comment> typedQuery = em.createQuery("SELECT c from Comment c where c.image.id =:imageId", Comment.class).setParameter("imageId", imageId);
            List<Comment> resultList = typedQuery.getResultList();
            return resultList;
        } catch (NoResultException nre) {
            return null;
        }
    }


}
