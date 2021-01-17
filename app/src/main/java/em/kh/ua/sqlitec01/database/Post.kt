package em.kh.ua.sqlitec01.database

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Класс-модель для постов
 * @constructor установка свойств постов
 * @property userId уникальный идентификатор автора поста
 * @property id идентификатор поста
 * @property title заглавие поста
 * @property body содержание поста
 */

@Entity
data class Post(val userId: Int,
                @PrimaryKey
                val id: Int,
                val title: String,
                val body: String)