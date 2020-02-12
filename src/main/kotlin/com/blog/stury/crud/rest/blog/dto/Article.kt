package com.blog.stury.crud.rest.blog.dto

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "article")
class Article(
    @GeneratedValue
    @Id
    var id: Int = 0,
    var title: String = "",
    var content: String = "",
    @Column(name = "registration_time")
    var registrationTime: Date = Date(),
    var genre: String = ""
)