package br.com.alura.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class NewTopicForm(
    @field:NotEmpty(message = "O titulo é obrigatório")
    @field:Size(min = 5, max = 100, message = "Titulo deve ter entre 5 e 100 caracteres")
    val title: String,

    @field:NotEmpty(message = "A mensagem é obrigatória")
    val message: String,

    @field:NotNull(message = "O ID do Curso é obrigatório")
    val courseId: Long,

    @field:NotNull(message = "O ID do Autor é obrigatório")
    val authorId: Long,
)
