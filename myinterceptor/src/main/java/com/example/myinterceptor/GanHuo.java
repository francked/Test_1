package com.example.myinterceptor;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ryan on 18-8-31.
 */

public class GanHuo implements Comparable<GanHuo>,Serializable {

//    /**
//     * error : false
//     * results : [{"_id":"5b830bba9d2122031f86ee51","createdAt":"2018-08-27T04:21:14.703Z","desc":"2018-08-27","publishedAt":"2018-08-28T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fuo54a6p0uj30sg0zdqnf.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b7b836c9d212201e982de6e","createdAt":"2018-08-21T11:13:48.989Z","desc":"2018-08-21","publishedAt":"2018-08-21T00:00:00.0Z","source":"web","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fuh5fsvlqcj30sg10onjk.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b74e9409d21222c52ae4cb4","createdAt":"2018-08-16T11:02:24.289Z","desc":"2018-08-16","publishedAt":"2018-08-16T00:00:00.0Z","source":"api","type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fubd0blrbuj30ia0qp0yi.jpg","used":true,"who":"lijinshan"},{"_id":"5b7102749d2122341d563844","createdAt":"2018-08-13T12:00:52.458Z","desc":"2018-08-13","publishedAt":"2018-08-13T00:00:00.0Z","source":"api","type":"福利","url":"https://ww1.sinaimg.cn/large/0065oQSqly1fu7xueh1gbj30hs0uwtgb.jpg","used":true,"who":"lijinshan"},{"_id":"5b6bad449d21226f45755582","createdAt":"2018-08-09T10:56:04.962Z","desc":"2018-08-09","publishedAt":"2018-08-09T00:00:00.0Z","source":"web","type":"福利","url":"https://ww1.sinaimg.cn/large/0065oQSqgy1fu39hosiwoj30j60qyq96.jpg","used":true,"who":"lijinshanmx"},{"_id":"5b67b7fd9d2122195bdbd806","createdAt":"2018-08-06T10:52:45.809Z","desc":"2018-08-06","publishedAt":"2018-08-06T00:00:00.0Z","source":"api","type":"福利","url":"https://ww1.sinaimg.cn/large/0065oQSqly1ftzsj15hgvj30sg15hkbw.jpg","used":true,"who":"lijinshan"},{"_id":"5b63cd4e9d21225e0d3f58c9","createdAt":"2018-08-03T11:34:38.672Z","desc":"2018-08-03","publishedAt":"2018-08-03T00:00:00.0Z","source":"api","type":"福利","url":"https://ww1.sinaimg.cn/large/0065oQSqgy1ftwcw4f4a5j30sg10j1g9.jpg","used":true,"who":"lijinshan"},{"_id":"5b6151509d21225206860f08","createdAt":"2018-08-01T14:21:04.556Z","desc":"2018-08-01","publishedAt":"2018-08-01T00:00:00.0Z","source":"api","type":"福利","url":"https://ww1.sinaimg.cn/large/0065oQSqly1ftu6gl83ewj30k80tites.jpg","used":true,"who":"lijinshan"},{"_id":"5b60356a9d212247776a2e0e","createdAt":"2018-07-31T18:09:46.825Z","desc":"2018-07-31","publishedAt":"2018-07-31T00:00:00.0Z","source":"api","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqgy1ftt7g8ntdyj30j60op7dq.jpg","used":true,"who":"lijinshan"},{"_id":"5b5e93499d21220fc64181a9","createdAt":"2018-07-30T12:25:45.937Z","desc":"2018-07-30","publishedAt":"2018-07-30T00:00:00.0Z","source":"web","type":"福利","url":"https://ww1.sinaimg.cn/large/0065oQSqgy1ftrrvwjqikj30go0rtn2i.jpg","used":true,"who":"lijinshanmx"}]
//     */
//
//    private boolean error;
//    private List<ResultsBean> results;
//
//    public boolean isError() {
//        return error;
//    }
//
//    public void setError(boolean error) {
//        this.error = error;
//    }
//
//    public List<ResultsBean> getResults() {
//        return results;
//    }
//
//    public void setResults(List<ResultsBean> results) {
//        this.results = results;
//    }
//
//

//    public static class ResultsBean {
//        /**
//         * _id : 5b830bba9d2122031f86ee51
//         * createdAt : 2018-08-27T04:21:14.703Z
//         * desc : 2018-08-27
//         * publishedAt : 2018-08-28T00:00:00.0Z
//         * source : web
//         * type : 福利
//         * url : https://ws1.sinaimg.cn/large/0065oQSqly1fuo54a6p0uj30sg0zdqnf.jpg
//         * used : true
//         * who : lijinshanmx
//         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

    @Override
    public String toString() {
        return "GanHuo{" +
                "_id='" + _id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", desc='" + desc + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", source='" + source + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", used=" + used +
                ", who='" + who + '\'' +
                '}';
    }

    @Override
    public int compareTo(@NonNull GanHuo o) {
        return o.getPublishedAt().compareTo(this.getPublishedAt());
    }
}
