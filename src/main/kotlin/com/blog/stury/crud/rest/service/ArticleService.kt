package com.blog.stury.crud.rest.service

import com.blog.stury.crud.rest.blog.ArticleRepository
import com.blog.stury.crud.rest.blog.dto.Article
import org.springframework.stereotype.Service

@Service
class ArticleService(private val articleRepository: ArticleRepository) {

    fun findByTitle(title: String): Article {
        return articleRepository.findByTitle(title)
    }

    fun getTitleList():List<String>{
        return articleRepository.findAll().map { it.title }
    }

    fun findById(id:Int):Article{
        return articleRepository.findById(id).get()
    }

    fun findAllArticles(): List<Article> {
        return articleRepository.findAll()
    }

    fun addArticle(article:Article){
        articleRepository.save(article)
    }

    fun deleteAllArticles() {
        articleRepository.deleteAll()
    }

    fun deleteOneArticle(id:Int){
        articleRepository.deleteById(id)
    }

}