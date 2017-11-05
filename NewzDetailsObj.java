package riaz.example.com.newzapp.Objects;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by RIAZ on 31/10/17.
 */

public class NewzDetailsObj {

    @SerializedName("status")
    private String status;

    @SerializedName("source")
    private String source;

    @SerializedName("sortBy")
    private String sortBy;

    @SerializedName("articles")
    private ArrayList<ArticlesDetails> articles;

    public NewzDetailsObj(String status, String source, String sortBy, ArrayList<ArticlesDetails> articles) {
        this.status = status;
        this.source = source;
        this.sortBy = sortBy;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public String getSource() {
        return source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public ArrayList<ArticlesDetails> getArticles() {
        return articles;
    }
}
