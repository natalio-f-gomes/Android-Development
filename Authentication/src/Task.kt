import java.time.Instant
import java.util.UUID

data class Task(
    val id: String = UUID.randomUUID().toString(),
    val ownerId: UUID,
    val title: String,
    val description: String,
    val createdAt: Instant = Instant.now(),
    val done: Boolean = false
)