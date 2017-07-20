
package edu.beretta.ico.data.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestPost {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("business")
    @Expose
    private String business;
    @SerializedName("post")
    @Expose
    private String post;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("status")
    @Expose
    private Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
