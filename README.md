# SpringBootApplication Image Hoster Project 

This is an imageHoster Project which is Built Using Spring 


To-Do Tasks
Part A: Fixing Issues
1. Image upload issues:

If you upload an image with the same exact title as of a previously uploaded image, it will get uploaded. But then, if you try to navigate to one of the images with the same title, the image uploader will display an error.
Please fix this issue, so that the application should not show an error and take you to respective image’s page.
Please see more details of this issue on Github.
 

2. After logging into the application, it is possible to edit/delete the image which is posted by some other user. This is a bug in the application. Now, fix this bug in the application, such that only the owner of the image can edit/delete the image. Check this link for more details.

If the owner of the image is trying to edit the image, you must return the ‘images/edit.html’ file, thus enabling the user to edit the image. But if the non-owner of the image is trying to edit the image, return the ‘images/image.html’ file displaying all the details of the image and print the message ‘Only the owner of the image can edit the image’. Carefully add all the required attributes in the Model type object needed by ‘images/image.html’ file.
Observe the message when non-owner of the image is trying to edit the image as shown below: 
 
Part B: Implement a new feature
After fixing the above issues, please implement the following features into the image uploader application:

1.  Password Strength

Up till now, there is no check on the strength of the password entered by the user at the time of registration. Let us try to keep a check on the strength of the password entered by the user at the time of registration. You need to implement a feature wherein the password entered by the user must contain at least 1 alphabet (a-z or A-Z), 1 number (0-9) and 1 special character (any character other than a-z, A-Z and 0-9). The user must only be registered if the password contains 1 alphabet, 1 number, and 1 special character. And after successful registration, you must directly return 'users/login.html' file. Otherwise, the user must not be registered and again return the ‘users/registration.html’ file. You also need to display a message ‘Password must contain at least 1 alphabet, 1 number & 1 special character’. Carefully add all the required attributes in the Model type object needed by ‘users/registration.html’ file.
Observe the registration web page and the password does not contain any number or special character as shown below:

Part B: Implement a new feature
After fixing the above issues, please implement the following features into the image uploader application:

1.  Password Strength

Up till now, there is no check on the strength of the password entered by the user at the time of registration. Let us try to keep a check on the strength of the password entered by the user at the time of registration. You need to implement a feature wherein the password entered by the user must contain at least 1 alphabet (a-z or A-Z), 1 number (0-9) and 1 special character (any character other than a-z, A-Z and 0-9). The user must only be registered if the password contains 1 alphabet, 1 number, and 1 special character. And after successful registration, you must directly return 'users/login.html' file. Otherwise, the user must not be registered and again return the ‘users/registration.html’ file. You also need to display a message ‘Password must contain at least 1 alphabet, 1 number & 1 special character’. Carefully add all the required attributes in the Model type object needed by ‘users/registration.html’ file.
Hint:

How to display the error message?

Declare and initialize a string with the message in the Controller logic as shown below:
String error = "Password must contain atleast 1 alphabet, 1 number & 1 special character"

Add the above string specifying the password type error in the Model type object with ‘passwordTypeError’ as the key.
Display a message in ‘users/registration.html’ file with an if condition.
If the Model type object contains the string representing the password type error, only then you should display the message.
Else, the message should not be displayed. Uncomment the following instruction given below in registration.html file to display the message with if condition.
<div th:if="${passwordTypeError}">Password must contain atleast 1 alphabet, 1 number & 1 special character</div>

Note that the test cases are designed in such a way that you need to add the message "Password must contain at least 1 alphabet, 1 number & 1 special character" with the key as ‘passwordTypeError’ for the test cases to pass.
 

2.  Comments

Now, implement a feature wherein a user can add a comment to any image in the application after he is logged in the application, and, to implement this feature, you’ll have to add the following to the image uploader application:

Create a Comment model class. The model class contains the following attributes:
id - Datatype should be int. It should be a primary key. Also explicitly mention the column name as ‘id’ to be created in the database.
text - Datatype should be a string. Note that this column can have text-based data that will be longer than 256 characters.
createdDate - Datatype should be LocalDate.
user - It should be of type User. The ‘comment’ table is mapped to ‘users’ table through this attribute. One user can post multiple comments but one comment should belong to one user. Write the suitable annotation to map the ‘comment’ table to ‘users’ table through this attribute.
Image - It should be of type Image. The ‘comment’ table is mapped to ‘images’ table through this attribute. One image can have multiple comments but one comment can only belong to one image. Write the suitable annotation to map the ‘comment’ table to ‘images’ table through this attribute.
You need to uncomment the HTML code in ‘image.html’ file to display all the comments in the application when you display the details of a particular image as shown below:
<div class="comments mt5">

   <article class="ba b--black-10 mv4" th:each="comment : ${comments}">

       <h1 class="f4 bg-light-gray black-80 mv0 pv2 ph3" th:text="${comment.user.username} + ' says'">Title of

           card</h1>

       <div class="pa3 bt b--black-10">

           <p class="f6 f5-ns lh-copy measure" th:text="${comment.text}">

               text

           </p>

       </div>

   </article>

</div>

Also, modify the code such that before you return ‘images/image.html’ file anywhere in the code, you always need to add the comments of the image in the Model type object in the code, with the key as ‘comments’.
You also need to uncomment the HTML code in ‘image.html’ file to allow the user to add the comments to an image when the details of the image are displayed as shown below:
<form method="POST" enctype="multipart/form-data"

     th:action="'/image/'+ ${image.id} + '/' + ${image.title} + '/comments'">

   <fieldset id="sign_up" class="ba b--transparent ph0 mh0">

       <div class="mt3">

           <label class="db fw6 lh-copy f6" for="comment">Write a comment</label>

           <textarea class="pa2 input-reset ba w-100" rows="5" name="comment" id="comment"></textarea>

       </div>

   </fieldset>

   <div>

       <input class="b ph3 pv2 input-reset ba b--black bg-transparent grow pointer f6 dib" type="submit"

              value="Submit">

   </div>

</form>

Implement a controller class method  that maps to the POST request URL ‘/image/{imageId}/{imageTitle}/comments’ for creating a new comment. After persisting the comment in the database, the controller logic must redirect to the same page displaying all the details of that particular image. Redirect to ‘showImage()’ method in ‘ImageController’ class.

You can obtain the request parameters from the client request using @RequestParam annotation. And obtain the dynamic parameter in the request URI using the annotation @PathVariable. You can read more about @PathParam and @RequestParam in the following links:

@RequestParam vs @PathVariable
How to explicitly obtain post data in Spring MVC?
Implement the required service logic and the Repository logic for the comment feature.
 

 

 
