package minjjing.springboot.blog_study.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import minjjing.springboot.blog_study.domain.Article;
import minjjing.springboot.blog_study.dto.AddArticleRequest;
import minjjing.springboot.blog_study.dto.UpdateArticleRequest;
import minjjing.springboot.blog_study.repository.BlogReposiroty;
import org.springframework.stereotype.Service;

import java.util.List;

/*RequiredArgsConstructor는 빈을 생성자로 생성하는 롬복에서 지원하는 애너태이션입니다.
* final 키워드나 @Notnull 붙은 필드의 생성자를 만들어줍니다.*/
@RequiredArgsConstructor
/*@Service 애너테이션은 해당 클래스를 빈으로 서블릿 컨테이너에 등록해줍니다.
* save()메서드는 JpaRepository에서 지원하는 저장 메서드 save()로 AddArticleRequest 클래스에 저장된 값들을
* article 데이터베이스에 저장합니다. */
@Service
public class BlogService {

    private final BlogReposiroty blogReposiroty;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogReposiroty.save(request.toEntity());

    }
    /*Jpa 지원 메서드인 findAll()을 호출해 article 테이블에 저장되어 있는 모든 데이터를 조회합니다. */
    public List<Article> findAll() {
        return blogReposiroty.findAll();
    }

    public Article findById(long id) {
        return blogReposiroty.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }


    public void delete(long id) {
        blogReposiroty.deleteById(id);
    }

   @Transactional //트랜잭션 메서드
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogReposiroty.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found:"+id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }


}
