package mainFolder.T2_AccesoABBDDRelacionales.A2InUpTrans;

public class Comment {

    private String description;
    private int typeComment;

    public Comment (String description, int typeComment){

        this.description = description;
        this.typeComment = typeComment;

    }

    public String getDescription() {

        return description;

    }

    public void setDescription(String description) {

        this.description = description;

    }

    public int getTypeComment() {

        return typeComment;

    }

    public void setTypeComment(int typeComment) {

        this.typeComment = typeComment;

    }
}
