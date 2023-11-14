package br.com.alura.forum.dto

import br.com.alura.forum.model.Course
import br.com.alura.forum.model.TopicStatus
import java.time.LocalDateTime

data class TopicView(
    val id: Long?,
    val title: String,
    val message: String,
    val course: Course,
    val status: TopicStatus,
    val createdAt: LocalDateTime
)
