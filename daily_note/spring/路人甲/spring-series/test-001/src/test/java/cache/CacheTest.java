package cache;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author WangRui
 * create at 2021/04/01 下午 2:48
 **/
public class CacheTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(CacheConfig.class);
        context.refresh();
        ArticleService articleService = context.getBean(ArticleService.class);
        System.out.println(articleService.getArticleList());
        System.out.println(articleService.getArticleList());
    }
}
