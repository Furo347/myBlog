package org.ynovschool.myBlog.mapper;

import org.springframework.stereotype.Component;
import org.ynovschool.myBlog.dto.TagDTO;
import org.ynovschool.myBlog.model.Tag;
import org.ynovschool.myBlog.model.Article;
import org.ynovschool.myBlog.repository.ArticleRepository;
import org.ynovschool.myBlog.repository.TagRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TagMapper {
    public final TagRepository tagRepository;
    private final ArticleRepository articleRepository;

    public TagMapper(TagRepository tagRepository, ArticleRepository articleRepository) {
        this.tagRepository = tagRepository;
        this.articleRepository = articleRepository;
    }

    public TagDTO convertToDTO(Tag tag) {
        TagDTO tagDTO = new TagDTO();
        tagDTO.setId(tag.getId());
        tagDTO.setName(tag.getName());
        if (tag.getArticles() != null) {
            tagDTO.setArticleIds(tag.getArticles().stream().map(Article::getId).collect(Collectors.toList()));
        }
        return tagDTO;
    }

    public Tag convertToEntity(TagDTO tagDTO) {
        Tag tag = new Tag();
        tag.setId(tagDTO.getId());
        tag.setName(tagDTO.getName());
        if (tagDTO.getArticleIds() != null) {
            List<Article> articles = articleRepository.findAllById(tagDTO.getArticleIds());
            tag.setArticles(articles);
        }
        return tag;
    }
}
