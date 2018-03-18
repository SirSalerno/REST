package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import model.Image;
 
public class ImageDAO {
 
    private static final Map<String, Image> imgMap = new HashMap<String, Image>();
 
    static {
        initEmps();
    }
 
    private static void initEmps() {
    	Image img1 = new Image("1", "gif", "1");
    	Image img2 = new Image("2", "png", "2");
    	Image img3 = new Image("3", "jpg", "3");
    	Image img4 = new Image("4", "jpg", "4");
 
        imgMap.put(img1.getImgID(), img1);
        imgMap.put(img2.getImgID(), img2);
        imgMap.put(img3.getImgID(), img3);
        imgMap.put(img4.getImgID(), img4);
    }
 
    public static Image getImage(String id) {
        return imgMap.get(id);
    }
 
    public static Image addImage(Image img) {
        imgMap.put(img.getImgID(), img);
        return img;
    }
 
    public static Image updateImage(Image img) {
        imgMap.put(img.getImgID(), img);
        return img;
    }
 
    public static void deleteImage(String id) {
        imgMap.remove(id);
    }
 
    public static List<Image> getAllImages() {
        Collection<Image> c = imgMap.values();
        List<Image> list = new ArrayList<Image>();
        list.addAll(c);
        return list;
    }
     
    List<Image> list;
 
}
