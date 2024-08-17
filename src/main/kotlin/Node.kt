class Node(private val archive: Any?) : Menu() {
    override val menu: List<String> = listOf("Просмотреть заметку", "Выход")
    fun windowNode() {
        println("МЕНЮ ЗАМЕТКИ")
        choiceMenu(create = { readNode() })
    }

    private fun readNode() {
        println(archive)
    }
}
