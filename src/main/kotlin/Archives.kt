class Archives : Menu() {
    private val archivesList: MutableList<Archive> = mutableListOf()
    override val menu: List<String> = listOf("Создать архив", "Выбрать архив", "Выход")

    fun windowArchives() {
        println("МЕНЮ АРХИВЫ")
        choiceMenu({ createArchive() }, { choiceArchive() })
    }

    private fun createArchive() {
        while (true) {
            println("Введите имя архива")
            val nameArchive = name()
            if (nameArchive.isNotBlank()) {
                val archive = Archive(nameArchive)
                archivesList.add(archive)
                break
            } else {
                println("Поле ввода не может быть пустым")
            }
        }
    }

    private fun choiceArchive() {
        if (archivesList.isEmpty()) {
            println("Список архивов пуст")
        } else {
            while (true) {
                println("Выберите требуемый архив, введя цифру перед описанием")
                archivesList.forEachIndexed { index, element -> println("$index. ${element.nameArchive}") }
                val numberArchive = numberMenu()
                if (numberArchive != null && numberArchive < archivesList.size) {
                    val currentArchive = archivesList[numberArchive]
                    currentArchive.windowArchive()
                    break
                } else {
                    println("Некорректный ввод")
                }
            }
        }
    }
}
