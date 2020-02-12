package com.blog.stury.crud.rest.blog

import com.blog.stury.crud.rest.blog.dto.Article
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleRepository : JpaRepository<Article, Int> {

    fun findByTitle(title:String): Article

}