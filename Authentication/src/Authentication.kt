import java.util.UUID

data class Authentication(val user: Account) {
    lateinit var users: MutableList<Account>

    var isLoggedIn: Boolean =  false

    fun register(): String{
        users.forEach { x ->
            if(x == user){
                return "Already registered"
            }
        }
        users.add(user)
        return "User ${user.username} registered"
    }
    fun login(){
        users.forEach{ existingUser ->
            if(user.id == existingUser.id){
                isLoggedIn = true
            }
        }
    }

    fun logout(){
        isLoggedIn = false
    }
}