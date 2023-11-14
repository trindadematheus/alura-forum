package br.com.alura.forum.dto

data class UpdateTopicForm(
    val id: Long,
    val title: String,
    val message: String
)
