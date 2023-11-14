package br.com.alura.forum.service

import br.com.alura.forum.dto.NewTopicForm
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.dto.UpdateTopicForm
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.TopicFormMapper
import br.com.alura.forum.mapper.TopicViewMapper
import br.com.alura.forum.model.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.streams.toList

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val notFoundMessage: String = "Tópico não encontrado!"
) {
    fun list(): List<TopicView> {
        return topics.stream().map { t -> topicViewMapper.map(t) }.collect(Collectors.toList())
    }

    fun getById(id: Long): TopicView {
        val topic =
            topics.stream().filter { t -> t.id == id }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }

        return topicViewMapper.map(topic)
    }

    fun create(createTopicDto: NewTopicForm): TopicView {
        var topic = topicFormMapper.map(createTopicDto)
        topic.id = topics.size.toLong() + 1

        topics = topics.plus(topic)

        return topicViewMapper.map(topic)
    }

    fun update(updateTopicDto: UpdateTopicForm): TopicView {
        val topic = topics.stream().filter { t -> t.id == updateTopicDto.id }.findFirst()
            .orElseThrow { NotFoundException(notFoundMessage) }

        val updatedTopic = Topic(
            id = updateTopicDto.id,
            title = updateTopicDto.title,
            message = updateTopicDto.message,
            author = topic.author,
            course = topic.course,
            answers = topic.answers,
            status = topic.status,
            createdAt = topic.createdAt,
        )

        topics = topics.minus(topic).plus(updatedTopic)

        return topicViewMapper.map(updatedTopic)
    }

    fun delete(id: Long) {
        val topic =
            topics.stream().filter { t -> t.id == id }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }
        topics = topics.minus(topic)
    }
}