//package com.example.mymvp.content;
//
//import android.support.annotation.NonNull;
//
//import java.io.Serializable;
//import java.util.List;
//
///**
// * Created by ryan on 18-8-29.
// */
//
//public class GanHuo {
//
//    /**
//     * count : 10
//     * error : false
//     * results : [{"desc":"简单跟大家讲一下 RecyclerView 的常用方法与奇葩用法；工作原理与ListView比较；源码解析；","ganhuo_id":"5782e5a0421aa90de83c1b4d","publishedAt":"2016-07-12T12:00:59.523000","readability":"","type":"Android","url":"http://kymjs.com/code/2016/07/10/01","who":"张涛"},{"desc":"仿微信朋友圈全文、收起的TextView，可在RecyclerView和ListView中使用，不会有错乱和空白问题，完全采用kotlin编写。","ganhuo_id":"5aff4779421aa961c94cf58f","publishedAt":"2018-05-15T00:00:00","readability":"","type":"Android","url":"https://github.com/devzld/ExpandableTextView","who":"lijinshanmx"},{"desc":"Android流式布局，支持点击、单选、多选等，适合用于产品标签等，用法采用Adapter模式，和ListView、GridView用法一样！！！","ganhuo_id":"573c24d36776591ca2f31b85","publishedAt":"2016-05-20T10:05:09.959000","readability":"","type":"Android","url":"https://github.com/hanhailong/FlowTag","who":"大熊"},{"desc":"很实用的一个库，帮你做 ListView / RecyclerView 等组件的状态维护，比如：无数据 / 网络出现问题 / 数据获取成功等。","ganhuo_id":"57edb5f6421aa95de3b8ab26","publishedAt":"2016-09-30T11:46:31.941000","readability":"","type":"Android","url":"https://github.com/WassimBenltaief/FlowLayout","who":"代码家"},{"desc":"仿微信实现的朋友圈，模拟与后台交互实现了点赞、评论、删除等功能，listview可以根据键盘的显示或隐藏实现联动。与后台交互采用mvp模式。","ganhuo_id":"56cc6d29421aa95caa708232","publishedAt":"2016-01-29T04:18:12.680000","readability":"","type":"Android","url":"https://github.com/Naoki2015/CircleDemo","who":"Jason"},{"desc":"TEmptyView是一个小轮子，希望能够更简单地设置EmptyView，免除每次设置emptyView都要写xml之苦。 支持AdapterView(ListView/GridView等)、RecyclerView。【话说我好不容易下定决心提交一下干货试试，结果就看了审核机制变化的公告~什么鬼 o(╯□╰)o】","ganhuo_id":"577b84d4421aa90191bc2a5b","publishedAt":"2016-07-06T12:16:53.218000","readability":"","type":"Android","url":"https://github.com/barryhappy/TEmptyView","who":"Barry"},{"desc":"Archi - 用三种 Android 代码架构来重构一个应用","ganhuo_id":"56cc6d22421aa95caa70792d","publishedAt":"2015-10-15T11:01:18.103000","readability":"","type":"Android","url":"https://github.com/ivacf/archi","who":"AllenJuns"},{"desc":"基于Facebook Buck改造Android构建系统之初体验","ganhuo_id":"56cc6d22421aa95caa707930","publishedAt":"2015-10-20T03:45:36.970000","readability":"","type":"Android","url":"http://www.jianshu.com/p/1e990aac7836","who":"AllenJuns"},{"desc":"侧滑菜单流动效果","ganhuo_id":"56cc6d23421aa95caa707959","publishedAt":"2015-10-23T04:01:16.217000","readability":"","type":"Android","url":"https://github.com/mxn21/FlowingDrawer","who":"Jason"},{"desc":"一个垂直的ViewPager","ganhuo_id":"56cc6d22421aa95caa707948","publishedAt":"2015-10-19T03:47:21.650000","readability":"","type":"Android","url":"https://github.com/kaelaela/VerticalViewPager","who":"有时放纵"}]
//     */
//
//    private int count;
//    private boolean error;
//    private List<ResultsBean> results;
//
//    public int getCount() {
//        return count;
//    }
//
//    public void setCount(int count) {
//        this.count = count;
//    }
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
//    public static class ResultsBean implements Comparable<ResultsBean>, Serializable {
//        /**
//         * desc : 简单跟大家讲一下 RecyclerView 的常用方法与奇葩用法；工作原理与ListView比较；源码解析；
//         * ganhuo_id : 5782e5a0421aa90de83c1b4d
//         * publishedAt : 2016-07-12T12:00:59.523000
//         * readability :
//         * type : Android
//         * url : http://kymjs.com/code/2016/07/10/01
//         * who : 张涛
//         */
//
//        private String desc;
//        private String ganhuo_id;
//        private String publishedAt;
//        private String readability;
//        private String type;
//        private String url;
//        private String who;
//
//        public String getDesc() {
//            return desc;
//        }
//
//        public void setDesc(String desc) {
//            this.desc = desc;
//        }
//
//        public String getGanhuo_id() {
//            return ganhuo_id;
//        }
//
//        public void setGanhuo_id(String ganhuo_id) {
//            this.ganhuo_id = ganhuo_id;
//        }
//
//        public String getPublishedAt() {
//            return publishedAt;
//        }
//
//        public void setPublishedAt(String publishedAt) {
//            this.publishedAt = publishedAt;
//        }
//
//        public String getReadability() {
//            return readability;
//        }
//
//        public void setReadability(String readability) {
//            this.readability = readability;
//        }
//
//        public String getType() {
//            return type;
//        }
//
//        public void setType(String type) {
//            this.type = type;
//        }
//
//        public String getUrl() {
//            return url;
//        }
//
//        public void setUrl(String url) {
//            this.url = url;
//        }
//
//        public String getWho() {
//            return who;
//        }
//
//        public void setWho(String who) {
//            this.who = who;
//        }
//
//        @Override
//        public int compareTo(@NonNull ResultsBean o) {
//            return o.getPublishedAt().compareTo(this.getPublishedAt());
//        }
//
//        @Override
//        public String toString() {
//            return "ResultsBean{" +
//                    "desc='" + desc + '\'' +
////                    ", ganhuo_id='" + ganhuo_id + '\'' +
//                    ", publishedAt='" + publishedAt + '\'' +
//                    ", readability='" + readability + '\'' +
//                    ", type='" + type + '\'' +
//                    ", url='" + url + '\'' +
//                    ", who='" + who + '\'' +
//                    '}';
//        }
//    }
//}
