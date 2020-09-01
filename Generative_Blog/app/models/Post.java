package models;

import java.util.Set;
import java.util.HashSet;

public class Post {
    // TODO: change id creation to a UUID implementation
    public Integer id = allPosts().size();
    public String title;
    public String content;
    public String author;
    public String imageName;

    public Post(){

    }

    public Post(String title, String content, String author, String imageName) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.imageName = imageName;

    }

    private static Set<Post> posts;

    static {
        posts = new HashSet<>();
        String lipsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi rhoncus " +
                "justo a lectus pretium, in vestibulum leo sollicitudin. In pulvinar neque vel " +
                "varius vestibulum. Sed rhoncus sit amet nunc quis blandit. Proin ac metus sit " +
                "amet ex molestie elementum. Etiam id libero consequat, imperdiet arcu dictum, " +
                "egestas leo. Nam id metus sit amet diam porta molestie. In et diam velit. " +
                "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac " +
                "turpis egestas. Nam tempor cursus ipsum ut rutrum. Morbi eu rhoncus nisl. Ut e" +
                "fficitur, sapien dignissim volutpat semper, ex orci dictum elit, eu congue erat " +
                "turpis ut dolor. Nulla lobortis tortor molestie mauris rutrum, sed iaculis libero " +
                "lobortis. Nunc cursus ex a risus sollicitudin, eget dignissim tortor fringilla. A" +
                "liquam mattis orci ac nunc rutrum, at pharetra sem congue. Nullam id ultricies tortor. " +
                "Etiam viverra felis odio, vestibulum ultricies ex molestie ut. ";
        posts.add(new Post( "My first post",lipsum ,"Jasper Wagen", "testImage00.png"));
        posts.add(new Post("My second post", lipsum,"Jasper Wagen", "testImage01.png"));

    }

    public static Set<Post> allPosts(){
        return posts;
    }

    public static Post findById(Integer id){
        for(Post post: posts){
            if(id.equals(post.id)) {
                return post;
            }
        }

        return null;
    }



    public static void add(Post post){
        posts.add(post);
    }

    public static boolean remove(Post post) {
        return posts.remove(post);
    }


//    public static void main(String []args) {
//        posts.add(new Post("My third post","content","Jasper Wagen"));
//        System.out.println(findById(2).title);
//    }
}