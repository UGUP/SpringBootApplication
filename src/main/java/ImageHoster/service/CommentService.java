package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    //This function passes the comments to the repository to store it in the database
    public Comment postComment(Comment newCommentt) {
        return commentRepository.postComment(newCommentt);
    }

    //This function returns all the comments posted for an image from the data base
    public List<Comment> getComments(Integer imageId, String title) {
        return commentRepository.getComments(imageId, title);

    }


}
