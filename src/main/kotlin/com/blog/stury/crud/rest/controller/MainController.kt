package com.blog.stury.crud.rest.controller

import com.blog.stury.crud.rest.blog.dto.Article
import com.blog.stury.crud.rest.service.ArticleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.lang.Exception
import javax.validation.Valid


// @Controller + @ResponseBody -> @RestController

@Controller
@RequestMapping("/blog")
class MainController() {

    @Autowired
    lateinit var articleService: ArticleService

    @RequestMapping("/")
    fun hogehoge():String{return "hogehogeghoege"}

    //    @GetMapping("/main")
    @GetMapping("/test")
    fun main(): String {
        return "sasaki"
    }

    @RequestMapping("/title", method = [RequestMethod.GET, RequestMethod.POST])
    fun getTitle(): String {
        return articleService.findAllArticles().toString()
    }

//    @PostMapping
//    fun addArticle(@Valid @ModelAttribute article: Article) {
//        articleService.addArticle(article)
//    }

    @RequestMapping("/blog/{id}")  // required false -> 任意
    fun getOneArticleById(@PathVariable(name = "id", required = false) id: Int): Article {
        return articleService.findById(id)
    }

    @RequestMapping("/blog")  // / blog?title=hogehgoe
    fun getOneArticleByTitle(@RequestParam(name = "title", required = false) title: String): Article {
        return articleService.findByTitle(title = title)
    }

    @RequestMapping("/delete/{id}")
    fun deleteOneArticle(@PathVariable id: Int) {
        articleService.deleteOneArticle(id)
    }


    @RequestMapping("/deleteAll")
    fun deleteAll(): String {
        try {
            articleService.deleteAllArticles()
            return "DELETE ALL SUCCESS!!"
        } catch (e: Exception) {
            return "FAILED TO DELETE ALL ARTICLES"
        }
    }

}