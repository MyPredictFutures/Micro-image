package guokangjie.news.com.weiying.event;

/**
 * Created by 郭康杰 on 2017/11/23.
 */

public class MessageNumEvent {
    private String url;

    public MessageNumEvent(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
