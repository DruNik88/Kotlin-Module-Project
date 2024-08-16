import java.util.*

abstract class Menu {
    abstract val menu: List<String>

    companion object {
        val input = Scanner(System.`in`)
    }

    private fun showMenu() {
        menu.forEachIndexed { index, element -> println("$index. $element") }
    }

    fun numberMenu(): Int? {
        return input.nextLine().toIntOrNull()
    }

    fun name(): String {
        return input.nextLine()
    }

    fun choiceMenu(create: () -> Unit, choice: () -> Unit = {}) {
        while (true) {
            println("Выберите пункт меню, введя цифру перед описанием")
            if (menu.size > 2) {
                showMenu()
                when (numberMenu()) {
                    0 -> create()
                    1 -> choice()
                    2 -> break
                    else -> println("Некорректный ввод")
                }
            } else {
                showMenu()
                when (numberMenu()) {
                    0 -> create()
                    1 -> break
                    else -> println("Некорректный ввод")
                }

            }
        }
    }
}
