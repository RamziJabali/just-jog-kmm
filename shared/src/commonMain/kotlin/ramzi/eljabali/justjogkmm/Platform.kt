package ramzi.eljabali.justjogkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform