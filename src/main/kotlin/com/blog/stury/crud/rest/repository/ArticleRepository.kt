package com.blog.stury.crud.rest.repository

import com.blog.stury.crud.rest.entity.Article
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleRepository : JpaRepository<Article, Int> {

    fun findByTitle(title:String): Article

}
