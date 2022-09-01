
package Utils.Views;

import java.util.List;

public class NewsView {
    public static String IndexContent(List<news.el.News> newss){
        String content = "";
        for (news.el.News news : newss){
            content += "<tr>"
                    + "<th>" + news.getIdNews() + "</th>"
                    + "<th>" + news.getIdUser()+ "</th>"
                    + "<th>" + news.getTittle()+ "</th>"
                    + "<th>" + news.getCategory()+ "</th>"
                    + "<th>" + news.getDescription()+ "</th>"
                    + "<th>" + news.getDateNews()+ "</th>"
                    + "<th>" + news.getImageNews()+ "</th>"
                    + "<th>" 
                        + "<a href=\""+ "/news/news?view=delete&id="+ news.getIdNews()+"\">Delete</a>"
                        + "<a href=\""+ "/news/news?view=details&id="+ news.getIdNews() +"\">Details</a>"
                        + "<a href=\""+ "/news/news?view=update&id="+ news.getIdNews() +"\">Update</a>"
                    + "</th>"
                    + "</tr>";
        }
        return content;
    }
}
