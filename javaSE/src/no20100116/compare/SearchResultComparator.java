package no20100116.compare;

import java.util.Comparator;

/**
 * 自定义实现的比较器：扩展实现额外的比较策略
 */
public class SearchResultComparator implements Comparator<SearchResult> {

    @Override
    public int compare(SearchResult o1, SearchResult o2) {
        //1.首先比较relativeRatio
        if(o1.relativeRatio != o2.relativeRatio){
            return o1.relativeRatio > o2.relativeRatio ? 1:-1;
        }
        //2.再比较recentOrders
        if(o1.recentOrders != o2.recentOrders){
            return o1.recentOrders > o2.recentOrders ?1:-1;
        }

        //3.最后比较count
        if(o1.count != o2.count){
            return o1.count > o2.count ? 1: -1;
        }

        return 0;
    }
}
