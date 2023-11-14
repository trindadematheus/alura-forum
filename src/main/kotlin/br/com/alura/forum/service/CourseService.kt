package br.com.alura.forum.service

import br.com.alura.forum.model.Course
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class CourseService(
    var courses: List<Course> = ArrayList()
) {
    init {
        val course = Course(
            id = 1,
            name = "Kotlin",
            category = "linguagem"
        )

        val course2 = Course(
            id = 2,
            name = "JavaScript",
            category = "linguagem"
        )

        courses = Arrays.asList(course, course2)
    }

    fun getById(id: Long): Course {
        return courses.stream().filter { course ->
            course.id == id
        }.findFirst().get()
    }
}
