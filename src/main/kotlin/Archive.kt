class Archive(val nameArchive: String) : Menu() {
    private var archive: MutableMap<String, Any> = mutableMapOf()
    override val menu: List<String> = listOf("Создать заметку", "Выбрать заметку", "Выход")

    fun windowArchive() {
        println("МЕНЮ АРХИВ")
        choiceMenu({ createNode() }, { choiceNode() })
    }

    private fun createNode() {
        while (true) {
            println("Введите имя заметки")
            val nameNode = input.nextLine()
            println("Введите текст заметки")
            val textNode = input.nextLine()
            if (nameNode.isNotEmpty() && textNode.isNotEmpty()) {
                archive[nameNode] = textNode
                break
            } else {
                println("Поле имя или текст не могут быть пустыми!!!")
            }
        }
    }

    private fun choiceNode() {
        if (archive.isEmpty()) {
            println("Архив пуст, заметок нет.")
        } else {
            while (true) {
                println("Выберите требуемую заметку, введя цифру перед описанием")
                val keyNodeWithIndices = archive.keys.mapIndexed { index, key -> key to index }
                keyNodeWithIndices.forEach { (key, index) -> println("$index. $key") }
                val archiveList = archive.values.toList()
                val keyNode = numberMenu()
                if (keyNode != null && keyNode < archiveList.size) {
                    val node = Node(archiveList[keyNode])
                    node.windowNode()
                    break
                } else {
                    println("Некорректный ввод")
                }
            }
        }
    }
}
