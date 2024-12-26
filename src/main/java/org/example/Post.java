package org.example;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private  String title;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE}, mappedBy = "post")
    @Column(nullable = false)
    private Set<Comment> comments;

    public Post(){}

//    public Post(int id, String title) {
//        this.id = id;
//        this.title = title;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        Post post = (Post) o;
//        return id == post.id && Objects.equals(title, post.title) && Objects.equals(comments, post.comments);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, title, comments);
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", id=" + id +
                '}';
    }
}
