import java.util.UUID
import kotlin.contracts.ReturnsNotNull

data class Account(val id: String = UUID.randomUUID().toString(), val username: String, val password: String) {


    lateinit var tasks: MutableList<Task>
    var isLoggedIn: Boolean = false
    fun addTask(newTask: Task){
        tasks.add(newTask)
    }
    fun getAllTasks(): MutableList<Task> {
        return tasks
    }

    fun getTaskByID(id: String): Task?{
        tasks.forEach { task ->
            if (task.id == id){
                return task
            }
        }
        return null
    }

}