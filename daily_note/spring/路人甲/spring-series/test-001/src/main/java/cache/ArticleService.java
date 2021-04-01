package cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author WangRui
 * create at 2021/04/01 下午 2:41
 **/
@Component
public class ArticleService {

    @Cacheable(cacheNames = "cache1")
    public List<String> getArticleList() {
        System.out.println("getArticleList");
        return Arrays.asList("aa", "bb", "cc");
    }

}
