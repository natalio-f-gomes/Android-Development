fun main() {
    val users = mutableListOf<Account>()
    var currentUser: Account? = null
    var auth: Authentication? = null

    fun promptInt(prompt: String): Int {
        while (true) {
            print(prompt)
            val raw = readlnOrNull()?.trim()
            val n = raw?.toIntOrNull()
            if (n != null) return n
            println("Please enter a valid number.")
        }
    }

    fun promptLine(prompt: String): String {
        print(prompt)
        return readln().trim()
    }

    while (true) {
        println(
            """
            ===== Menu =====
            1) Register
            2) Login
            3) Add Task
            4) List My Tasks
            5) Logout
            0) Exit
            """.trimIndent()
        )

        when (promptInt("Choose an option: ")) {
            1 -> {
                val username = promptLine("Username: ")
                val password = promptLine("Password: ")
                val newUser = Account(username = username, password = password).also {
                    it.tasks = mutableListOf()
                }


                val tmpAuth = Authentication(user = newUser).also { it.users = users }
                val msg = tmpAuth.register()
                println(msg)

            }

            2 -> {
                if (users.isEmpty()) {
                    println("No users registered yet.")
                    continue
                }
                val username = promptLine("Username: ")
                val password = promptLine("Password: ")

                val found = users.find { it.username == username && it.password == password }
                if (found == null) {
                    println("Invalid credentials.")
                } else {
                    currentUser = found
                    auth = Authentication(user = found).also { it.users = users }
                    auth!!.login()
                    if (auth!!.isLoggedIn) {
                        println("Logged in as ${found.username}.")
                    } else {
                        println("Login failed.")
                    }
                }
            }

            3 -> {
                val a = auth
                val u = currentUser
                if (a == null || u == null || !a.isLoggedIn) {
                    println("You must be logged in to add tasks.")
                    continue
                }

                val title = promptLine("Task title: ")
                val description = promptLine("Task description: ")
                val task = Task(
                    ownerId = java.util.UUID.fromString(u.id),
                    title = title,
                    description = description
                )
                u.addTask(task)
                println("Task '${task.title}' added with id=${task.id}.")
            }

            4 -> {
                val a = auth
                val u = currentUser
                if (a == null || u == null || !a.isLoggedIn) {
                    println("You must be logged in to list tasks.")
                    continue
                }
                val all = u.getAllTasks()
                if (all.isEmpty()) {
                    println("No tasks yet.")
                } else {
                    println("=== Your Tasks ===")
                    all.forEachIndexed { idx, t ->
                        println("${idx + 1}. [done=${t.done}] ${t.title} — ${t.description} (id=${t.id})")
                    }
                }
            }

            5 -> {
                if (auth == null) {
                    println("Not logged in.")
                } else {
                    auth!!.logout()
                    println("Logged out.")
                    currentUser = null
                    auth = null
                }
            }

            0 -> {
                println("Goodbye!")
                break
            }

            else -> println("Unknown option.")
        }
        println()
    }
}
