package com.example.mytablayout.retrofit;

import java.util.List;

/**
 * Created by ryan on 18-8-22.
 */

public class DouBan {


    /**
     * rating : {"max":10,"numRaters":18,"average":"7.4","min":0}
     * subtitle :
     * author : ["少华"]
     * pubdate : 2005-01
     * tags : [{"count":16,"name":"军事","title":"军事"},{"count":12,"name":"豆瓣第一个条目","title":"豆瓣第一个条目"},{"count":6,"name":"第一","title":"第一"},{"count":5,"name":"传记","title":"传记"},{"count":5,"name":"一本见证了豆瓣诞生的书","title":"一本见证了豆瓣诞生的书"},{"count":2,"name":"近代史","title":"近代史"},{"count":2,"name":"历史","title":"历史"},{"count":2,"name":"中国","title":"中国"}]
     * origin_title :
     * image : https://img1.doubanio.com/view/subject/m/public/s1727038.jpg
     * binding : 平装
     * translator : []
     * catalog : 飞天骄将黄公略
     百劫将星段德昌
     无衔元帅叶挺
     铁血儒将曾中生
     圣地能人刘志丹
     碧血悲歌许继慎
     神行太保罗炳辉
     殉国名将左权
     文武全才彭雪枫
     赤胆农王方志敏
     军中智囊蔡申熙
     后记
     * pages : 403
     * images : {"small":"https://img1.doubanio.com/view/subject/s/public/s1727038.jpg","large":"https://img1.doubanio.com/view/subject/l/public/s1727038.jpg","medium":"https://img1.doubanio.com/view/subject/m/public/s1727038.jpg"}
     * alt : https://book.douban.com/subject/1000001/
     * id : 1000001
     * publisher : 湖北人民出版社
     * isbn10 : 7216041283
     * isbn13 : 9787216041287
     * title : 十一位牺牲在建国前的中共无衔军事家
     * url : https://api.douban.com/v2/book/1000001
     * alt_title :
     * author_intro :
     * summary : 十一位牺牲在建国前的中共无衔军事家，ISBN：9787216041287，作者：少华著
     * price : 26.00元
     */

    private RatingBean rating;
    private String subtitle;
    private String pubdate;
    private String origin_title;
    private String image;
    private String binding;
    private String catalog;
    private String pages;
    private ImagesBean images;
    private String alt;
    private String id;
    private String publisher;
    private String isbn10;
    private String isbn13;
    private String title;
    private String url;
    private String alt_title;
    private String author_intro;
    private String summary;
    private String price;
    private List<String> author;
    private List<TagsBean> tags;
    private List<?> translator;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getOrigin_title() {
        return origin_title;
    }

    public void setOrigin_title(String origin_title) {
        this.origin_title = origin_title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlt_title() {
        return alt_title;
    }

    public void setAlt_title(String alt_title) {
        this.alt_title = alt_title;
    }

    public String getAuthor_intro() {
        return author_intro;
    }

    public void setAuthor_intro(String author_intro) {
        this.author_intro = author_intro;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public List<?> getTranslator() {
        return translator;
    }

    public void setTranslator(List<?> translator) {
        this.translator = translator;
    }

    public static class RatingBean {
        /**
         * max : 10
         * numRaters : 18
         * average : 7.4
         * min : 0
         */

        private int max;
        private int numRaters;
        private String average;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getNumRaters() {
            return numRaters;
        }

        public void setNumRaters(int numRaters) {
            this.numRaters = numRaters;
        }

        public String getAverage() {
            return average;
        }

        public void setAverage(String average) {
            this.average = average;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static class ImagesBean {
        /**
         * small : https://img1.doubanio.com/view/subject/s/public/s1727038.jpg
         * large : https://img1.doubanio.com/view/subject/l/public/s1727038.jpg
         * medium : https://img1.doubanio.com/view/subject/m/public/s1727038.jpg
         */

        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class TagsBean {
        /**
         * count : 16
         * name : 军事
         * title : 军事
         */

        private int count;
        private String name;
        private String title;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
