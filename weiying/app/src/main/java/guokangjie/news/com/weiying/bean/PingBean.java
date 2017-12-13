package guokangjie.news.com.weiying.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 郭康杰 on 2017/11/23.
 */

public class PingBean  extends BaseBean{

    /**
     * ret : {"pnum":1,"totalRecords":9,"records":4,"list":[{"msg":"一定要听结尾曲！太好听了","phoneNumber":"㌍㌫㌶㍊㍍㍑㌫㌶㍍","dataId":"ff8080815fa38f91015fb086ef376df8","userPic":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK8ichLPACYaD80Y1SZSpqXeTaqYzgKcDaVa3GExDn1SicuQuHYBcJ7ER2HOXbZibkD3qwHQXnNRt3gg/0","time":"2017-11-12 21:59:13","likeNum":0},{"msg":"好看的啊","phoneNumber":"可乐","dataId":"ff8080815f387ddb015f4a0eab976d3a","userPic":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJZwFrofNic2lqNqGuCFibqbRxDx64gOdQicCGYjllic0NTkB0E3OJ2PCyY4dLw4SbKhCUaUvPfJnUGuw/0","time":"2017-10-24 00:26:36","likeNum":0},{"msg":"不是挺好看的吗","phoneNumber":"可乐","dataId":"ff8080815f387ddb015f4a0e5c946d39","userPic":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJZwFrofNic2lqNqGuCFibqbRxDx64gOdQicCGYjllic0NTkB0E3OJ2PCyY4dLw4SbKhCUaUvPfJnUGuw/0","time":"2017-10-24 00:26:16","likeNum":1},{"msg":"真不好看，讲真的的我觉得这特么是辣鸡","phoneNumber":"187****7961","dataId":"ff8080815e7fa211015e809977fc097b","userPic":"http://phonemovie.ks3-cn-beijing.ksyun.com/%2Fupload/memberPic/2017/09/05/1504610734973228271.jpg","time":"2017-09-14 21:34:54","likeNum":1}],"totalPnum":3}
     */

    private RetBean ret;

    public RetBean getRet() {
        return ret;
    }

    public void setRet(RetBean ret) {
        this.ret = ret;
    }

    public static class RetBean {
        /**
         * pnum : 1
         * totalRecords : 9
         * records : 4
         * list : [{"msg":"一定要听结尾曲！太好听了","phoneNumber":"㌍㌫㌶㍊㍍㍑㌫㌶㍍","dataId":"ff8080815fa38f91015fb086ef376df8","userPic":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK8ichLPACYaD80Y1SZSpqXeTaqYzgKcDaVa3GExDn1SicuQuHYBcJ7ER2HOXbZibkD3qwHQXnNRt3gg/0","time":"2017-11-12 21:59:13","likeNum":0},{"msg":"好看的啊","phoneNumber":"可乐","dataId":"ff8080815f387ddb015f4a0eab976d3a","userPic":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJZwFrofNic2lqNqGuCFibqbRxDx64gOdQicCGYjllic0NTkB0E3OJ2PCyY4dLw4SbKhCUaUvPfJnUGuw/0","time":"2017-10-24 00:26:36","likeNum":0},{"msg":"不是挺好看的吗","phoneNumber":"可乐","dataId":"ff8080815f387ddb015f4a0e5c946d39","userPic":"http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJZwFrofNic2lqNqGuCFibqbRxDx64gOdQicCGYjllic0NTkB0E3OJ2PCyY4dLw4SbKhCUaUvPfJnUGuw/0","time":"2017-10-24 00:26:16","likeNum":1},{"msg":"真不好看，讲真的的我觉得这特么是辣鸡","phoneNumber":"187****7961","dataId":"ff8080815e7fa211015e809977fc097b","userPic":"http://phonemovie.ks3-cn-beijing.ksyun.com/%2Fupload/memberPic/2017/09/05/1504610734973228271.jpg","time":"2017-09-14 21:34:54","likeNum":1}]
         * totalPnum : 3
         */

        private int pnum;
        private int totalRecords;
        private int records;
        private int totalPnum;
        private List<ListBean> list;

        public int getPnum() {
            return pnum;
        }

        public void setPnum(int pnum) {
            this.pnum = pnum;
        }

        public int getTotalRecords() {
            return totalRecords;
        }

        public void setTotalRecords(int totalRecords) {
            this.totalRecords = totalRecords;
        }

        public int getRecords() {
            return records;
        }

        public void setRecords(int records) {
            this.records = records;
        }

        public int getTotalPnum() {
            return totalPnum;
        }

        public void setTotalPnum(int totalPnum) {
            this.totalPnum = totalPnum;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * msg : 一定要听结尾曲！太好听了
             * phoneNumber : ㌍㌫㌶㍊㍍㍑㌫㌶㍍
             * dataId : ff8080815fa38f91015fb086ef376df8
             * userPic : http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK8ichLPACYaD80Y1SZSpqXeTaqYzgKcDaVa3GExDn1SicuQuHYBcJ7ER2HOXbZibkD3qwHQXnNRt3gg/0
             * time : 2017-11-12 21:59:13
             * likeNum : 0
             */

            @SerializedName("msg")
            private String msgX;
            private String phoneNumber;
            private String dataId;
            private String userPic;
            private String time;
            private int likeNum;

            public String getMsgX() {
                return msgX;
            }

            public void setMsgX(String msgX) {
                this.msgX = msgX;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public String getDataId() {
                return dataId;
            }

            public void setDataId(String dataId) {
                this.dataId = dataId;
            }

            public String getUserPic() {
                return userPic;
            }

            public void setUserPic(String userPic) {
                this.userPic = userPic;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getLikeNum() {
                return likeNum;
            }

            public void setLikeNum(int likeNum) {
                this.likeNum = likeNum;
            }
        }
    }
}
