package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import java.util.Set;

import models.Post;
import views.html.posts.*;

import javax.inject.Inject;
import play.data.FormFactory;
import play.data.Form;

public class blogController extends Controller {


    //create blog posts
    @Inject
    FormFactory formFactory;
    public Result create(){
        Form<Post> postForm = formFactory.form(Post.class);
        return ok(createPost.render(postForm));
    }

    //landing page
    public Result home(){
        return ok(home.render());
    }

    //about page
    public Result about(){
        return ok(about.render());
    }

    //all blog posts
    public Result genart(){
        Set<Post> posts = Post.allPosts();
        return ok(postIndex.render(posts));
    }

    //save blog posts
    public Result save(){
        Form<Post> postForm = formFactory.form(Post.class).bindFromRequest();
        Post post = postForm.get();
        Post.add(post);
        return redirect(routes.blogController.genart());
    }

    public Result edit(Integer id){
        Post post = Post.findById(id);
        if(post==null){
            return notFound("Post ID not found.");
        }
        Form<Post> postForm = formFactory.form(Post.class).fill(post);

        return ok(editPost.render(postForm, post));
    }

    public Result destroy(Integer id){
        Post post = Post.findById(id);
        if(post==null){
            return notFound("Post ID not found.");
        }

        Post.remove(post);
        return redirect(routes.blogController.genart());
    }

    public Result update(Integer id){
            Post post  = formFactory.form(Post.class).bindFromRequest().get();
            Post oldPost = Post.findById(id);
            if(oldPost == null){
                return notFound("Post not found.");
            }
            oldPost.title = post.title;
            oldPost.author = post.author;
            oldPost.content = post.content;
            oldPost.id = id;

            return redirect(routes.blogController.genart());
    }

    public Result show(Integer id){
        Post post = Post.findById(id);
            if(post==null){
                return notFound("Post not Found");
            }
        return ok(showPost.render(post));
    }
}