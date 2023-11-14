package br.com.alura.forum.service

import br.com.alura.forum.model.Course
import br.com.alura.forum.model.User
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class UserService(
    var users: List<User> = ArrayList()
) {
    init {
        val user = User(
            id = 1, name = "matheus", email = "trindadematheus@gmial.com"
        )

        users = Arrays.asList(user)
    }

    fun getById(id: Long): User {
        return users.stream().filter { user ->
            user.id == id
        }.findFirst().get()
    }
}
