package no20100116.compare;

/**
 * 通过实现Comparable接口进行比较
 */
public class SearchResult implements Comparable<SearchResult> {

    int relativeRatio;
    long count;
    int recentOrders;

    public SearchResult(int relativeRatio, long count){
        this.relativeRatio = relativeRatio;
        this.count = count;
    }

    @Override
    public int compareTo(SearchResult o) {
        //先比较相关度
        if(this.relativeRatio != o.relativeRatio){
            return this.relativeRatio >o.relativeRatio ? 1:-1;
        }
        //相关度相等时比较浏览数
        if(this.count != o.count){
           return this.count > o.count ? 1:-1;
        }
        return 0;
    }

    public void setRecentOrders(int recentOrders) {
        this.recentOrders = recentOrders;
    }
}
