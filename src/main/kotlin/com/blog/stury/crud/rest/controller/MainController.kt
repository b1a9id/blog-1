package com.blog.stury.crud.rest.controller

import com.blog.stury.crud.rest.entity.Article
import com.blog.stury.crud.rest.service.ArticleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


// @Controller + @ResponseBody -> @RestController
// @Controllerは画面遷移するけど＠RestControllerは画面遷移しない

@Controller
@RequestMapping("/blog")
class MainController() {

    @Autowired
    lateinit var articleService: ArticleService

    @RequestMapping("/main")
    fun mainPage():String{
        return "Main"
    }

    @RequestMapping("/")
    fun hogehoge():String{return "hogehogeghoege"}

    //    @GetMapping("/main")
    @GetMapping("/test")
    fun main(): String {
        return "sasaki"
    }

    @RequestMapping("/title", method = [RequestMethod.GET, RequestMethod.POST])
    fun getTitle(): String {
        return articleService.findById(1).title
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
