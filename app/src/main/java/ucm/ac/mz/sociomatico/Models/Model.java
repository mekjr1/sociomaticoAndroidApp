package ucm.ac.mz.sociomatico.Models;

public class Model {

    public static final int IMAGE_TYPE =1;
    public String title, subtitle, Image, content;

    public int type;



    public Model (int mtype, String mtitle, String msubtitle, String image,  String content ){

        this.title = mtitle;
        this.subtitle = msubtitle;
        this.type = mtype;
        this.Image = image;
        this.content = content;
    }
}

