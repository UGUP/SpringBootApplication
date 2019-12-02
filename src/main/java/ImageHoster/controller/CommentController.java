package ImageHoster.controller;


import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
public class CommentController {

    @Autowired(required = true)
    private CommentService commentservice;

    @Autowired
    private ImageService imageService;


    //This controller method is called when the request pattern is of type ''image/comments'and also the incoming request is of POST type
    //This method passes the value of imageId and Title
    //This method calls the postComment method which has the logic to post the comments in the database
    @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    public String createComment(@PathVariable(name = "imageId") Integer imageId, @PathVariable(value = "imageTitle") String title, @RequestParam(value = "comment") String newComment, HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggeduser");
        Image image = imageService.getImage(imageId);
        Comment comment = new Comment();
        comment.setImage(image);
        comment.setUser(user);
        comment.setText(newComment);
        LocalDate localDate = LocalDate.now();
        comment.setCreatedDate(localDate);
        commentservice.postComment(comment);
        //model.addAttribute("comments", comment);
        return "redirect:/images/" + image.getId() + "/" + image.getTitle();

    }
}
